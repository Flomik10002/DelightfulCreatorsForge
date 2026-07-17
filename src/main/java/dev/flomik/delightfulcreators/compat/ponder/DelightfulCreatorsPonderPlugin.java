package dev.flomik.delightfulcreators.compat.ponder;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;

import dev.flomik.delightfulcreators.DelightfulCreators;
import dev.flomik.delightfulcreators.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

/**
 * Gives the Mechanical Cutter a Ponder entry (the "Hold [key] for Ponder" in-world tutorial),
 * reusing Create's own "mechanical_press/pressing" schematic - see CutterScenes for why.
 */
public class DelightfulCreatorsPonderPlugin implements PonderPlugin {

    @Override
    public String getModId() {
        return DelightfulCreators.MOD_ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        ResourceLocation cutter = BuiltInRegistries.BLOCK.getKey(ModBlocks.MECHANICAL_CUTTER.get());
        helper.forComponents(cutter)
                .addStoryBoard(ResourceLocation.fromNamespaceAndPath("create", "mechanical_press/pressing"),
                        CutterScenes::cutting);
    }

}
