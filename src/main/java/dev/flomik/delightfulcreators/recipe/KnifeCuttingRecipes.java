package dev.flomik.delightfulcreators.recipe;

import net.minecraft.world.item.ItemStack;

import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModItems;

/**
 * Shared "is this a knife_dig cutting board recipe" check, used by both MechanicalCutterBlockEntity
 * (belt/world/basin processing) and DelightfulCreatorsJeiPlugin (recipe listing) - the Mechanical
 * Cutter only ever automates the knife subset of Farmer's Delight's cutting board recipes, leaving
 * axe_strip/axe_dig/shovel_dig to the real tools they require. Farmer's Delight's own
 * CuttingBoardRecipe#matches() ignores the tool entirely, so the only way to tell recipes apart is
 * testing a representative knife ItemStack against the recipe's own tool Ingredient directly.
 */
public class KnifeCuttingRecipes {

    private static final ItemStack KNIFE_STAND_IN = new ItemStack(ModItems.IRON_KNIFE.get());

    public static boolean isKnifeRecipe(CuttingBoardRecipe recipe) {
        return recipe.getTool()
                .test(KNIFE_STAND_IN);
    }

}
