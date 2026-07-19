package dev.flomik.delightfulcreators.compat.jei;

import static mezz.jei.api.recipe.RecipeType.createRecipeHolderType;

import java.util.List;

import com.simibubi.create.compat.jei.EmptyBackground;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import dev.flomik.delightfulcreators.DelightfulCreators;
import dev.flomik.delightfulcreators.block.ModBlocks;
import dev.flomik.delightfulcreators.recipe.KnifeCuttingRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

/**
 * Registers a JEI category for the Mechanical Cutter that shows Farmer's Delight cutting board
 * recipes, but visually reuses Create's own Mechanical Press animation (see
 * MechanicalCuttingCategory) instead of the cutting board + knife look, since automated cutting
 * has no held knife to show.
 */
@JeiPlugin
public class DelightfulCreatorsJeiPlugin implements IModPlugin {

    private static final ResourceLocation PLUGIN_UID = ResourceLocation.fromNamespaceAndPath(DelightfulCreators.MOD_ID, "jei_plugin");
    private static final ResourceLocation MECHANICAL_CUTTING_ID =
            ResourceLocation.fromNamespaceAndPath(DelightfulCreators.MOD_ID, "mechanical_cutting");

    public static final RecipeType<RecipeHolder<CuttingBoardRecipe>> MECHANICAL_CUTTING =
            createRecipeHolderType(MECHANICAL_CUTTING_ID);

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        CreateRecipeCategory.Info<CuttingBoardRecipe> info = new CreateRecipeCategory.Info<>(
                MECHANICAL_CUTTING,
                Component.translatable("jei.delightfulcreators.mechanical_cutting"),
                new EmptyBackground(177, 70),
                registration.getJeiHelpers().getGuiHelper()
                        .createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MECHANICAL_CUTTER.get())),
                DelightfulCreatorsJeiPlugin::getCuttingRecipes,
                List.of(() -> new ItemStack(ModBlocks.MECHANICAL_CUTTER.get())));
        registration.addRecipeCategories(new MechanicalCuttingCategory(info));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(MECHANICAL_CUTTING, getCuttingRecipes());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MECHANICAL_CUTTER.get()), MECHANICAL_CUTTING);
    }

    private static List<RecipeHolder<CuttingBoardRecipe>> getCuttingRecipes() {
        ClientLevel level = Minecraft.getInstance().level;
        if (level == null)
            return List.of();
        return level.getRecipeManager().getAllRecipesFor(ModRecipeTypes.CUTTING.get())
                .stream()
                .filter(recipe -> KnifeCuttingRecipes.isKnifeRecipe(recipe.value()))
                .toList();
    }

}
