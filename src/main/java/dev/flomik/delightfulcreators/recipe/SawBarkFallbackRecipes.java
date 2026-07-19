package dev.flomik.delightfulcreators.recipe;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;

/**
 * Adds Farmer's Delight's Tree Bark (or Straw, for bamboo-like blocks) as a bonus output on top of
 * Create's own auto-generated log-stripping "create:cutting" recipes, so stripping a log with the
 * Mechanical Saw drops the same bonus item the real Cutting Board would. Those generated recipes are
 * themselves just entries in the same raw JSON map RecipeManager#apply() receives (Create injects
 * them through its own synthetic resource pack before recipes are parsed), so we find and patch them
 * without touching any of Create's Java - see RecipeManagerMixin.
 *
 * Deliberately does not touch Farmer's Delight's own "axe_strip" cutting-board recipes at all - the
 * Mechanical Cutter only ever processes "knife_dig" recipes (see MechanicalCutterBlockEntity), so
 * stripping automation is left entirely to the real Mechanical Saw.
 */
public class SawBarkFallbackRecipes {

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final String CUTTING_TYPE = "create:cutting";
    private static final String GENERATED_PATH_PREFIX = "cutting/runtime_generated/compat/";
    private static final String TREE_BARK = "farmersdelight:tree_bark";
    private static final String STRAW = "farmersdelight:straw";

    public static Map<ResourceLocation, JsonElement> withBarkBonus(Map<ResourceLocation, JsonElement> original) {
        // No config gate here (unlike the rest of this mod): recipes are loaded well before server
        // configs become available, so a config read at this point would throw.
        try {
            return apply(original);
        } catch (Exception e) {
            LOGGER.error("Failed to add bark bonus to Saw stripping recipes, skipping this pass", e);
            return original;
        }
    }

    private static Map<ResourceLocation, JsonElement> apply(Map<ResourceLocation, JsonElement> original) {
        Map<ResourceLocation, JsonElement> result = new HashMap<>(original);
        int patched = 0;

        for (Map.Entry<ResourceLocation, JsonElement> entry : original.entrySet()) {
            ResourceLocation id = entry.getKey();
            if (!id.getNamespace()
                    .equals("create") || !id.getPath()
                            .startsWith(GENERATED_PATH_PREFIX))
                continue;

            String bonus = strippingBonusItem(entry.getValue());
            if (bonus == null)
                continue;

            JsonObject patchedJson = entry.getValue()
                    .deepCopy()
                    .getAsJsonObject();
            JsonObject bonusOutput = new JsonObject();
            bonusOutput.addProperty("id", bonus);
            patchedJson.getAsJsonArray("results")
                    .add(bonusOutput);

            result.put(id, patchedJson);
            patched++;
            LOGGER.debug("Added {} to Saw stripping recipe {}", bonus, id);
        }

        if (patched > 0)
            LOGGER.info("Added a bark/straw bonus to {} Saw stripping recipe(s)", patched);

        return result;
    }

    // Only the actual log/wood/stem/hyphae -> stripped-variant recipes qualify - the same generator
    // also produces stripped-or-not -> planks/stairs/slabs/etc recipes under an identical ID prefix,
    // which must not get a bark bonus.
    private static String strippingBonusItem(JsonElement element) {
        if (!(element instanceof JsonObject json))
            return null;
        JsonElement type = json.get("type");
        if (type == null || !type.isJsonPrimitive() || !CUTTING_TYPE.equals(type.getAsString()))
            return null;

        JsonArray ingredients = json.getAsJsonArray("ingredients");
        JsonArray results = json.getAsJsonArray("results");
        if (ingredients == null || ingredients.size() != 1 || results == null || results.size() != 1)
            return null;

        JsonElement resultElement = results.get(0);
        if (!resultElement.isJsonObject() || !resultElement.getAsJsonObject()
                .has("id"))
            return null;

        String outputItem = resultElement.getAsJsonObject()
                .get("id")
                .getAsString();
        String outputPath = outputItem.substring(outputItem.indexOf(':') + 1);
        if (!outputPath.contains("stripped"))
            return null;

        return outputPath.contains("block") ? STRAW : TREE_BARK;
    }

}
