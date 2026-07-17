package dev.flomik.delightfulcreators.block;

import dev.flomik.delightfulcreators.DelightfulCreators;
import dev.flomik.delightfulcreators.block.cutter.MechanicalCutterBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, DelightfulCreators.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MechanicalCutterBlockEntity>> MECHANICAL_CUTTER =
            BLOCK_ENTITY_TYPES.register("mechanical_cutter", ModBlockEntityTypes::createMechanicalCutterType);

    private static BlockEntityType<MechanicalCutterBlockEntity> createMechanicalCutterType() {
        return BlockEntityType.Builder.of(
                        (pos, state) -> new MechanicalCutterBlockEntity(MECHANICAL_CUTTER.get(), pos, state),
                        ModBlocks.MECHANICAL_CUTTER.get())
                .build(null);
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}
