package dev.flomik.delightfulcreators.recipe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.logging.LogUtils;

import dev.flomik.delightfulcreators.DelightfulCreators;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import org.slf4j.Logger;

/**
 * Generates fallback recipes for Farmer's Delight Cooking Pot recipes that don't already have a
 * hand-authored equivalent in our own datapack
 * (data/delightfulcreators/recipe/{sequenced_assembly,filling,compacting,deploying}). A 2-ingredient
 * cooking recipe (after accounting for an implicit container, see below) becomes a single
 * "create:deploying"/"create:filling" recipe - there's no need for a transitional item or a
 * multi-step chain to apply just one ingredient. Anything with 3 or more effective ingredients
 * becomes a "create:sequenced_assembly" chain.
 *
 * Runs entirely on the raw recipe JSON handed to RecipeManager#apply(), before any of it is parsed
 * into real Recipe objects - see RecipeManagerMixin. This means it works from plain JSON structure
 * only, except where it needs to consult the already-fully-registered Item registry (see
 * impliedContainer()) - item registration happens long before recipes are loaded, so that's safe.
 *
 * The generated Sequenced Assembly recipe's transitional item is a plain copy of the finished dish's
 * own ItemStack (same item id) rather than a bespoke "incomplete" item - there is no way to know in
 * advance what a dynamically discovered recipe should look like mid-assembly, so it intentionally
 * just looks like the dish is already sitting there being worked on, using the dish's own texture.
 * FoodPropertiesFallbackMixin (see dev.flomik.delightfulcreators.mixin) makes sure that stack can't
 * be eaten for the real dish's nutrition/effects while it's still mid-sequence.
 *
 * The JSON field names below (results use "id"/"amount" rather than "item", ingredients still use
 * "item"/"tag", fluid ingredients need the "neoforge:single"/"neoforge:tag" wrapper) were cross-
 * checked against this branch's own committed recipe files (bacon_sandwich.json, stuffed_potato.json,
 * emptying/tomato_sauce.json). Farmer's Delight 1.21.1's own "farmersdelight:cooking" recipe schema
 * was verified against the real Farmer's Delight 1.21.1 jar: "result" and "container" both already
 * use the vanilla ItemStack-result shape ("id"/"count"), not FD's older "item"-keyed Ingredient shape
 * - see containerAsIngredient()/impliedContainer() below for where that gets converted back into a
 * plain Ingredient for use in the generated recipe's own "ingredients" array.
 */
public class CookingPotFallbackRecipes {

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final String COOKING_TYPE = "farmersdelight:cooking";
    private static final String SEQUENCED_ASSEMBLY_TYPE = "create:sequenced_assembly";
    private static final String DEPLOYING_TYPE = "create:deploying";
    private static final String FILLING_TYPE = "create:filling";
    private static final String EMPTYING_TYPE = "create:emptying";
    private static final int DEFAULT_FLUID_AMOUNT = 250;

    // Recipe types of our own hand-authored cooking pipeline whose "results" already cover a dish -
    // if any of these already produces the same item, we must not also generate a fallback for it.
    private static final Set<String> HANDLED_BY_TYPES = Set.of(SEQUENCED_ASSEMBLY_TYPE, FILLING_TYPE,
            "create:compacting", DEPLOYING_TYPE);

    // Item tags that represent "a container of X liquid" - matched against a plain {"tag": ...}
    // ingredient and converted into a "create:filling" step using the fluid tag of the same name,
    // instead of deploying the item as-is. "c:milk" is the fluid tag itself; it never appears as an
    // ingredient's item tag, so the container tags that actually show up in recipes (bottled or
    // bucketed milk - confirmed against Farmer's Delight's and NeoForge's own 1.21.1 tag files) are
    // the ones that need mapping here.
    private static final Map<String, String> ITEM_TAG_TO_FLUID_TAG = Map.of(
            "c:drinks/milk", "c:milk",
            "c:buckets/milk", "c:milk");

    // Bowl/bottle/bucket - the only container shapes Farmer's Delight's own bowlFoodItem() registration
    // helper (and vanilla's own stew items) use. Matched against getCraftingRemainingItem() below.
    private static final Set<String> SERVING_CONTAINERS = Set.of("minecraft:bowl", "minecraft:glass_bottle",
            "minecraft:bucket");

    public static Map<ResourceLocation, JsonElement> withFallbacks(Map<ResourceLocation, JsonElement> original) {
        try {
            return generate(original);
        } catch (Exception e) {
            LOGGER.error("Failed to generate fallback cooking recipes, skipping this pass", e);
            return original;
        }
    }

    private static Map<ResourceLocation, JsonElement> generate(Map<ResourceLocation, JsonElement> original) {
        Set<String> handledResults = collectHandledResults(original);
        Map<String, FluidSource> itemFluids = collectItemFluids(original);
        Map<ResourceLocation, JsonElement> result = new HashMap<>(original);
        int generated = 0;

        for (Map.Entry<ResourceLocation, JsonElement> entry : original.entrySet()) {
            JsonObject cookingRecipe = asCookingRecipe(entry.getValue());
            if (cookingRecipe == null)
                continue;

            JsonObject fdResult = cookingRecipe.getAsJsonObject("result");
            if (fdResult == null || !fdResult.has("id")) {
                LOGGER.debug("Skipping fallback for {}: no simple item result", entry.getKey());
                continue;
            }
            String resultId = fdResult.get("id").getAsString();
            if (handledResults.contains(resultId)) {
                LOGGER.debug("Skipping fallback for {}: already hand-authored", entry.getKey());
                continue;
            }

            JsonArray ingredients = effectiveIngredients(cookingRecipe, fdResult);
            if (ingredients.size() < 2) {
                LOGGER.debug("Skipping fallback for {}: fewer than 2 effective ingredients", entry.getKey());
                continue;
            }

            ResourceLocation originalId = entry.getKey();
            ResourceLocation fallbackId = ResourceLocation.fromNamespaceAndPath(DelightfulCreators.MOD_ID,
                    "cooking_fallback/" + originalId.getNamespace() + "/" + originalId.getPath());
            if (result.containsKey(fallbackId)) {
                LOGGER.debug("Skipping fallback for {}: {} already present", entry.getKey(), fallbackId);
                continue;
            }

            JsonObject resultOutput = toResultOutput(fdResult);
            JsonObject generatedRecipe = ingredients.size() == 2
                    ? buildSingleStep(ingredients.get(0), ingredients.get(1), resultOutput, itemFluids)
                    : buildSequencedAssembly(ingredients, resultOutput, itemFluids);
            result.put(fallbackId, generatedRecipe);
            generated++;
            LOGGER.debug("Generated fallback recipe {} for {}", fallbackId, entry.getKey());
        }

        if (generated > 0)
            LOGGER.info("Generated {} fallback cooking-pot recipe(s)", generated);

        return result;
    }

    // Farmer's Delight 1.21.1's own "result"/"container" fields already use the same vanilla
    // ItemStack-result shape ({"id": ..., "count": ?}) Create's own "results" entries use - see this
    // branch's own emptying/tomato_sauce.json and sequenced_assembly/bacon_sandwich.json, and FD's
    // own data/farmersdelight/recipe/cooking/mushroom_stew.json. Only "id"/"count" are copied over,
    // dropping any FD-only fields.
    private static JsonObject toResultOutput(JsonObject fdItemOutput) {
        JsonObject output = new JsonObject();
        output.addProperty("id", fdItemOutput.get("id").getAsString());
        if (fdItemOutput.has("count"))
            output.addProperty("count", fdItemOutput.get("count").getAsInt());
        return output;
    }

    // Some Cooking Pot recipes require an empty container (a Bowl) that never shows up in
    // "ingredients" at all - vanilla's own mushroom_stew/rabbit_stew declare it explicitly via the
    // separate "container" field, but Farmer's Delight's own bowl-shaped dishes (onion_soup,
    // bone_broth, ...) don't - FD registers those items through its own bowlFoodItem() helper, which
    // sets a Bowl as the item's crafting remainder, and Farmer's Delight's Cooking Pot logic requires
    // that remainder as an implicit extra ingredient purely in Java, never in the recipe JSON. We
    // replicate that by checking the real, already-registered result Item's own crafting remainder.
    private static JsonArray effectiveIngredients(JsonObject cookingRecipe, JsonObject fdResult) {
        JsonArray ingredients = cookingRecipe.getAsJsonArray("ingredients");
        if (ingredients == null)
            return new JsonArray();

        JsonObject container = cookingRecipe.getAsJsonObject("container");
        JsonObject containerIngredient = container != null && container.has("id") ? containerAsIngredient(container)
                : impliedContainer(fdResult);
        if (containerIngredient == null)
            return ingredients;

        JsonArray withContainer = new JsonArray();
        withContainer.add(containerIngredient);
        ingredients.forEach(withContainer::add);
        return withContainer;
    }

    // The "container" field (and impliedContainer()'s crafting-remainder lookup below) both describe
    // an item by id, FD-ItemStack-shaped ({"id": ...}) or otherwise - convert to a plain vanilla
    // Ingredient ({"item": ...}) so it can sit in the generated recipe's own ingredients array.
    private static JsonObject containerAsIngredient(JsonObject container) {
        JsonObject ingredient = new JsonObject();
        ingredient.addProperty("item", container.get("id").getAsString());
        return ingredient;
    }

    private static JsonObject impliedContainer(JsonObject fdResult) {
        if (fdResult == null || !fdResult.has("id"))
            return null;
        ResourceLocation resultId = ResourceLocation.tryParse(fdResult.get("id").getAsString());
        if (resultId == null)
            return null;

        Item item = BuiltInRegistries.ITEM.get(resultId);
        if (item == null || !item.hasCraftingRemainingItem())
            return null;

        ResourceLocation remainderId = BuiltInRegistries.ITEM.getKey(item.getCraftingRemainingItem());
        if (remainderId == null || !SERVING_CONTAINERS.contains(remainderId.toString()))
            return null;

        JsonObject json = new JsonObject();
        json.addProperty("item", remainderId.toString());
        return json;
    }

    private static JsonObject asCookingRecipe(JsonElement element) {
        if (!(element instanceof JsonObject json))
            return null;
        JsonElement type = json.get("type");
        if (type == null || !type.isJsonPrimitive() || !COOKING_TYPE.equals(type.getAsString()))
            return null;
        return json;
    }

    private static Set<String> collectHandledResults(Map<ResourceLocation, JsonElement> recipes) {
        // Deliberately not filtered by namespace: any existing recipe of these types that already
        // produces a given dish - ours or a third party's - is equally a valid reason to skip
        // generating a duplicate fallback for it.
        Set<String> handled = new HashSet<>();
        for (Map.Entry<ResourceLocation, JsonElement> entry : recipes.entrySet()) {
            if (!(entry.getValue() instanceof JsonObject json))
                continue;

            JsonElement type = json.get("type");
            if (type == null || !type.isJsonPrimitive() || !HANDLED_BY_TYPES.contains(type.getAsString()))
                continue;

            JsonArray results = json.getAsJsonArray("results");
            if (results == null)
                continue;
            for (JsonElement result : results) {
                if (result.isJsonObject() && result.getAsJsonObject().has("id"))
                    handled.add(result.getAsJsonObject()
                            .get("id")
                            .getAsString());
            }
        }
        return handled;
    }

    // A dish item can itself be a container of one of our own registered fluids, if we already have a
    // "create:emptying" recipe unpacking it (e.g. farmersdelight:tomato_sauce -> a Bowl + our
    // delightfulcreators:tomato_sauce fluid). When such an item shows up as an ingredient elsewhere,
    // pour the fluid in directly via "create:filling" instead of deploying the whole dish item.
    private static Map<String, FluidSource> collectItemFluids(Map<ResourceLocation, JsonElement> recipes) {
        Map<String, FluidSource> itemFluids = new HashMap<>();
        for (JsonElement element : recipes.values()) {
            if (!(element instanceof JsonObject json))
                continue;
            JsonElement type = json.get("type");
            if (type == null || !type.isJsonPrimitive() || !EMPTYING_TYPE.equals(type.getAsString()))
                continue;

            JsonArray ingredients = json.getAsJsonArray("ingredients");
            JsonArray results = json.getAsJsonArray("results");
            if (ingredients == null || ingredients.size() != 1 || results == null)
                continue;
            JsonElement ingredient = ingredients.get(0);
            if (!ingredient.isJsonObject() || !ingredient.getAsJsonObject()
                    .has("item"))
                continue;

            for (JsonElement resultEntry : results) {
                if (!resultEntry.isJsonObject())
                    continue;
                JsonObject resultObject = resultEntry.getAsJsonObject();
                // Emptying's fluid result sits alongside its emptied-container item result in the
                // same "results" array, both shaped {"id": ..., "amount"/"count": ?} - the fluid one
                // is the entry that carries "amount" (see this branch's emptying/tomato_sauce.json).
                if (!resultObject.has("amount") || !resultObject.has("id"))
                    continue;
                String itemId = ingredient.getAsJsonObject()
                        .get("item")
                        .getAsString();
                String fluidId = resultObject.get("id")
                        .getAsString();
                int amount = resultObject.get("amount")
                        .getAsInt();
                itemFluids.put(itemId, new FluidSource(fluidId, amount));
                break;
            }
        }
        return itemFluids;
    }

    private static JsonObject buildSequencedAssembly(JsonArray ingredients, JsonObject resultOutput,
            Map<String, FluidSource> itemFluids) {
        JsonObject transitionalItem = new JsonObject();
        transitionalItem.addProperty("id", resultOutput.get("id").getAsString());

        JsonObject recipe = new JsonObject();
        recipe.addProperty("type", SEQUENCED_ASSEMBLY_TYPE);
        recipe.add("ingredient", ingredients.get(0));
        recipe.addProperty("loops", 1);

        JsonArray results = new JsonArray();
        results.add(resultOutput);
        recipe.add("results", results);
        recipe.add("transitional_item", transitionalItem);

        JsonArray sequence = new JsonArray();
        for (int i = 1; i < ingredients.size(); i++)
            sequence.add(buildStep(transitionalItem, ingredients.get(i), transitionalItem, itemFluids));
        recipe.add("sequence", sequence);

        return recipe;
    }

    // For a plain 2-ingredient recipe (or 1 ingredient + an implied container), there's no need for a
    // transitional item at all - it's either a single "create:deploying" (apply B onto A) or, if B is
    // fluid-representable, a single "create:filling" (pour fluid into A) producing the dish directly.
    private static JsonObject buildSingleStep(JsonElement first, JsonElement second, JsonObject resultOutput,
            Map<String, FluidSource> itemFluids) {
        FluidIngredient fluid = asFluidIngredient(second, itemFluids);
        JsonObject recipe = new JsonObject();

        JsonArray recipeIngredients = new JsonArray();
        recipeIngredients.add(first);

        if (fluid != null) {
            recipe.addProperty("type", FILLING_TYPE);
            recipeIngredients.add(fluid.toJson());
        } else {
            recipe.addProperty("type", DEPLOYING_TYPE);
            recipeIngredients.add(second);
        }
        recipe.add("ingredients", recipeIngredients);

        JsonArray results = new JsonArray();
        results.add(resultOutput);
        recipe.add("results", results);

        return recipe;
    }

    private static JsonObject buildStep(JsonObject transitionalItem, JsonElement ingredient, JsonObject output,
            Map<String, FluidSource> itemFluids) {
        FluidIngredient fluid = asFluidIngredient(ingredient, itemFluids);

        JsonObject step = new JsonObject();
        JsonArray stepIngredients = new JsonArray();
        // Overwritten by Create's own SequencedRecipe parsing regardless of what's here (it always
        // rebinds slot 0 to the transitional item / starting ingredient) - kept explicit to match
        // the shape of our own hand-authored recipes.
        JsonObject transitionalAsIngredient = new JsonObject();
        transitionalAsIngredient.addProperty("item", transitionalItem.get("id").getAsString());
        stepIngredients.add(transitionalAsIngredient);

        if (fluid != null) {
            step.addProperty("type", FILLING_TYPE);
            stepIngredients.add(fluid.toJson());
        } else {
            step.addProperty("type", DEPLOYING_TYPE);
            stepIngredients.add(ingredient);
        }
        step.add("ingredients", stepIngredients);

        JsonArray stepResults = new JsonArray();
        stepResults.add(output);
        step.add("results", stepResults);

        return step;
    }

    private static FluidIngredient asFluidIngredient(JsonElement ingredient, Map<String, FluidSource> itemFluids) {
        if (!ingredient.isJsonObject())
            return null;
        JsonObject json = ingredient.getAsJsonObject();

        if (json.has("tag")) {
            String fluidTag = ITEM_TAG_TO_FLUID_TAG.get(json.get("tag")
                    .getAsString());
            if (fluidTag != null)
                return FluidIngredient.tag(fluidTag, DEFAULT_FLUID_AMOUNT);
        }

        if (json.has("item")) {
            FluidSource source = itemFluids.get(json.get("item")
                    .getAsString());
            if (source != null)
                return FluidIngredient.fluid(source.fluidId, source.amount);
        }

        return null;
    }

    private record FluidSource(String fluidId, int amount) {
    }

    private record FluidIngredient(String type, String key, String value, int amount) {
        static FluidIngredient tag(String fluidTag, int amount) {
            return new FluidIngredient("neoforge:tag", "tag", fluidTag, amount);
        }

        static FluidIngredient fluid(String fluidId, int amount) {
            return new FluidIngredient("neoforge:single", "fluid", fluidId, amount);
        }

        JsonObject toJson() {
            JsonObject json = new JsonObject();
            json.addProperty("type", type);
            json.addProperty(key, value);
            json.addProperty("amount", amount);
            return json;
        }
    }

}
