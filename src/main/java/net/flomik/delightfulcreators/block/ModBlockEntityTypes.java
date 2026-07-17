package net.flomik.delightfulcreators.block;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.flomik.delightfulcreators.block.cutter.MechanicalCutterBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, DelightfulCreators.MOD_ID);

    public static final RegistryObject<BlockEntityType<MechanicalCutterBlockEntity>> MECHANICAL_CUTTER =
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
