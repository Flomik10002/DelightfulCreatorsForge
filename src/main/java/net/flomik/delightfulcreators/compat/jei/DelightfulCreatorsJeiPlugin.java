package net.flomik.delightfulcreators.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.flomik.delightfulcreators.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import vectorwing.farmersdelight.integration.jei.FDRecipeTypes;

/**
 * Registers the Mechanical Cutter as an additional catalyst for Farmer's Delight's own "Cutting"
 * JEI category, the same way Create registers the Mechanical Press as a catalyst for its Pressing
 * and Compacting categories - no new category is needed since Farmer's Delight already owns and
 * renders the cutting board recipe category.
 */
@JeiPlugin
public class DelightfulCreatorsJeiPlugin implements IModPlugin {

    private static final ResourceLocation PLUGIN_UID = new ResourceLocation(DelightfulCreators.MOD_ID, "jei_plugin");

    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_UID;
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MECHANICAL_CUTTER.get()), FDRecipeTypes.CUTTING);
    }

}
