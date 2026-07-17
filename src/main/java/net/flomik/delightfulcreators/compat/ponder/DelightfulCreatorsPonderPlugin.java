package net.flomik.delightfulcreators.compat.ponder;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.flomik.delightfulcreators.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

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
        ResourceLocation cutter = ForgeRegistries.BLOCKS.getKey(ModBlocks.MECHANICAL_CUTTER.get());
        helper.forComponents(cutter)
                .addStoryBoard(new ResourceLocation("create", "mechanical_press/pressing"), CutterScenes::cutting);
    }

}
