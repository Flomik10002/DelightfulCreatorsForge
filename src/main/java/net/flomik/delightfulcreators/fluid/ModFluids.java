package net.flomik.delightfulcreators.fluid;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.flomik.delightfulcreators.block.ModBlocks;
import net.flomik.delightfulcreators.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, DelightfulCreators.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_TOMATO_SAUCE = FLUIDS.register("tomato_sauce_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.TOMATO_SAUCE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TOMATO_SAUCE = FLUIDS.register("flowing_tomato_sauce",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.TOMATO_SAUCE_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties TOMATO_SAUCE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.TOMATO_SAUCE_FLUID_TYPE, SOURCE_TOMATO_SAUCE, FLOWING_TOMATO_SAUCE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.TOMATO_SAUCE_BLOCK)
            .bucket(ModItems.TOMATO_SAUCE_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
