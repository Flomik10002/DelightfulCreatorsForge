package dev.flomik.delightfulcreators.block.cutter;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;

import dev.flomik.delightfulcreators.DelightfulCreators;
import net.minecraft.resources.ResourceLocation;

/**
 * Partial models used by kinetic block renderers (e.g. the Mechanical Cutter's moving head).
 * Referencing these fields anywhere forces this class to load, which is all PartialModel.of(...)
 * needs to register itself for baking - see Create's own AllPartialModels.init() for the same
 * no-op pattern.
 */
public class ModPartialModels {

    public static final PartialModel MECHANICAL_CUTTER_HEAD =
            block("mechanical_cutter/head");

    private static PartialModel block(String path) {
        return PartialModel.of(ResourceLocation.fromNamespaceAndPath(DelightfulCreators.MOD_ID, "block/" + path));
    }

    public static void init() {
        // init static fields
    }

}
