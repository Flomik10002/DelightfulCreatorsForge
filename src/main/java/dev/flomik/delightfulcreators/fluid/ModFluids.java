package dev.flomik.delightfulcreators.fluid;

import dev.flomik.delightfulcreators.DelightfulCreators;
import dev.flomik.delightfulcreators.block.ModBlocks;
import dev.flomik.delightfulcreators.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(Registries.FLUID, DelightfulCreators.MOD_ID);

    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_TOMATO_SAUCE = FLUIDS.register("tomato_sauce",
            () -> new BaseFlowingFluid.Source(ModFluids.TOMATO_SAUCE_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_TOMATO_SAUCE = FLUIDS.register("flowing_tomato_sauce",
            () -> new BaseFlowingFluid.Flowing(ModFluids.TOMATO_SAUCE_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_HOT_COCOA = FLUIDS.register("hot_cocoa",
            () -> new BaseFlowingFluid.Source(ModFluids.HOT_COCOA_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_HOT_COCOA = FLUIDS.register("flowing_hot_cocoa",
            () -> new BaseFlowingFluid.Flowing(ModFluids.HOT_COCOA_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_MELON_JUICE = FLUIDS.register("melon_juice",
            () -> new BaseFlowingFluid.Source(ModFluids.MELON_JUICE_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MELON_JUICE = FLUIDS.register("flowing_melon_juice",
            () -> new BaseFlowingFluid.Flowing(ModFluids.MELON_JUICE_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_APPLE_CIDER = FLUIDS.register("apple_cider",
            () -> new BaseFlowingFluid.Source(ModFluids.APPLE_CIDER_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_APPLE_CIDER = FLUIDS.register("flowing_apple_cider",
            () -> new BaseFlowingFluid.Flowing(ModFluids.APPLE_CIDER_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_BEETROOT_SOUP = FLUIDS.register("beetroot_soup",
            () -> new BaseFlowingFluid.Source(ModFluids.BEETROOT_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BEETROOT_SOUP = FLUIDS.register("flowing_beetroot_soup",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BEETROOT_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_CHICKEN_SOUP = FLUIDS.register("chicken_soup",
            () -> new BaseFlowingFluid.Source(ModFluids.CHICKEN_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_CHICKEN_SOUP = FLUIDS.register("flowing_chicken_soup",
            () -> new BaseFlowingFluid.Flowing(ModFluids.CHICKEN_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_NOODLE_SOUP = FLUIDS.register("noodle_soup",
            () -> new BaseFlowingFluid.Source(ModFluids.NOODLE_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_NOODLE_SOUP = FLUIDS.register("flowing_noodle_soup",
            () -> new BaseFlowingFluid.Flowing(ModFluids.NOODLE_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_PUMPKIN_SOUP = FLUIDS.register("pumpkin_soup",
            () -> new BaseFlowingFluid.Source(ModFluids.PUMPKIN_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PUMPKIN_SOUP = FLUIDS.register("flowing_pumpkin_soup",
            () -> new BaseFlowingFluid.Flowing(ModFluids.PUMPKIN_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_VEGETABLE_SOUP = FLUIDS.register("vegetable_soup",
            () -> new BaseFlowingFluid.Source(ModFluids.VEGETABLE_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_VEGETABLE_SOUP = FLUIDS.register("flowing_vegetable_soup",
            () -> new BaseFlowingFluid.Flowing(ModFluids.VEGETABLE_SOUP_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_FISH_STEW = FLUIDS.register("fish_stew",
            () -> new BaseFlowingFluid.Source(ModFluids.FISH_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_FISH_STEW = FLUIDS.register("flowing_fish_stew",
            () -> new BaseFlowingFluid.Flowing(ModFluids.FISH_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_BEEF_STEW = FLUIDS.register("beef_stew",
            () -> new BaseFlowingFluid.Source(ModFluids.BEEF_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BEEF_STEW = FLUIDS.register("flowing_beef_stew",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BEEF_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_RABBIT_STEW = FLUIDS.register("rabbit_stew",
            () -> new BaseFlowingFluid.Source(ModFluids.RABBIT_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_RABBIT_STEW = FLUIDS.register("flowing_rabbit_stew",
            () -> new BaseFlowingFluid.Flowing(ModFluids.RABBIT_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_MUSHROOM_STEW = FLUIDS.register("mushroom_stew",
            () -> new BaseFlowingFluid.Source(ModFluids.MUSHROOM_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MUSHROOM_STEW = FLUIDS.register("flowing_mushroom_stew",
            () -> new BaseFlowingFluid.Flowing(ModFluids.MUSHROOM_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_GLOW_BERRY_CUSTARD = FLUIDS.register("glow_berry_custard",
            () -> new BaseFlowingFluid.Source(ModFluids.GLOW_BERRY_CUSTARD_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_GLOW_BERRY_CUSTARD = FLUIDS.register("flowing_glow_berry_custard",
            () -> new BaseFlowingFluid.Flowing(ModFluids.GLOW_BERRY_CUSTARD_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_RATATOUILLE = FLUIDS.register("ratatouille",
            () -> new BaseFlowingFluid.Source(ModFluids.RATATOUILLE_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_RATATOUILLE = FLUIDS.register("flowing_ratatouille",
            () -> new BaseFlowingFluid.Flowing(ModFluids.RATATOUILLE_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_DOG_FOOD = FLUIDS.register("dog_food",
            () -> new BaseFlowingFluid.Source(ModFluids.DOG_FOOD_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_DOG_FOOD = FLUIDS.register("flowing_dog_food",
            () -> new BaseFlowingFluid.Flowing(ModFluids.DOG_FOOD_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_BAKED_COD_STEW = FLUIDS.register("baked_cod_stew",
            () -> new BaseFlowingFluid.Source(ModFluids.BAKED_COD_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BAKED_COD_STEW = FLUIDS.register("flowing_baked_cod_stew",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BAKED_COD_STEW_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_BONE_BROTH = FLUIDS.register("bone_broth",
            () -> new BaseFlowingFluid.Source(ModFluids.BONE_BROTH_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BONE_BROTH = FLUIDS.register("flowing_bone_broth",
            () -> new BaseFlowingFluid.Flowing(ModFluids.BONE_BROTH_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> SOURCE_COOKED_RICE = FLUIDS.register("cooked_rice",
            () -> new BaseFlowingFluid.Source(ModFluids.COOKED_RICE_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_COOKED_RICE = FLUIDS.register("flowing_cooked_rice",
            () -> new BaseFlowingFluid.Flowing(ModFluids.COOKED_RICE_FLUID_PROPERTIES));


    public static final BaseFlowingFluid.Properties TOMATO_SAUCE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.TOMATO_SAUCE_FLUID_TYPE, SOURCE_TOMATO_SAUCE, FLOWING_TOMATO_SAUCE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.TOMATO_SAUCE_BLOCK)
            .bucket(ModItems.TOMATO_SAUCE_BUCKET);

    public static final BaseFlowingFluid.Properties HOT_COCOA_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.HOT_COCOA_FLUID_TYPE, SOURCE_HOT_COCOA, FLOWING_HOT_COCOA)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.HOT_COCOA_BLOCK)
            .bucket(ModItems.HOT_COCOA_BUCKET);

    public static final BaseFlowingFluid.Properties MELON_JUICE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.MELON_JUICE_FLUID_TYPE, SOURCE_MELON_JUICE, FLOWING_MELON_JUICE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).tickRate(5).block(ModBlocks.MELON_JUICE_BLOCK)
            .bucket(ModItems.MELON_JUICE_BUCKET);

    public static final BaseFlowingFluid.Properties APPLE_CIDER_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.APPLE_CIDER_FLUID_TYPE, SOURCE_APPLE_CIDER, FLOWING_APPLE_CIDER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).tickRate(5).block(ModBlocks.APPLE_CIDER_BLOCK)
            .bucket(ModItems.APPLE_CIDER_BUCKET);

    public static final BaseFlowingFluid.Properties BEETROOT_SOUP_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.BEETROOT_SOUP_FLUID_TYPE, SOURCE_BEETROOT_SOUP, FLOWING_BEETROOT_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.BEETROOT_SOUP_BLOCK)
            .bucket(ModItems.BEETROOT_SOUP_BUCKET);

    public static final BaseFlowingFluid.Properties CHICKEN_SOUP_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.CHICKEN_SOUP_FLUID_TYPE, SOURCE_CHICKEN_SOUP, FLOWING_CHICKEN_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.CHICKEN_SOUP_BLOCK)
            .bucket(ModItems.CHICKEN_SOUP_BUCKET);

    public static final BaseFlowingFluid.Properties NOODLE_SOUP_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.NOODLE_SOUP_FLUID_TYPE, SOURCE_NOODLE_SOUP, FLOWING_NOODLE_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.NOODLE_SOUP_BLOCK)
            .bucket(ModItems.NOODLE_SOUP_BUCKET);

    public static final BaseFlowingFluid.Properties PUMPKIN_SOUP_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.PUMPKIN_SOUP_FLUID_TYPE, SOURCE_PUMPKIN_SOUP, FLOWING_PUMPKIN_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.PUMPKIN_SOUP_BLOCK)
            .bucket(ModItems.PUMPKIN_SOUP_BUCKET);

    public static final BaseFlowingFluid.Properties VEGETABLE_SOUP_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.VEGETABLE_SOUP_FLUID_TYPE, SOURCE_VEGETABLE_SOUP, FLOWING_VEGETABLE_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.VEGETABLE_SOUP_BLOCK)
            .bucket(ModItems.VEGETABLE_SOUP_BUCKET);

    public static final BaseFlowingFluid.Properties FISH_STEW_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.FISH_STEW_FLUID_TYPE, SOURCE_FISH_STEW, FLOWING_FISH_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.FISH_STEW_BLOCK)
            .bucket(ModItems.FISH_STEW_BUCKET);

    public static final BaseFlowingFluid.Properties RABBIT_STEW_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.RABBIT_STEW_FLUID_TYPE, SOURCE_RABBIT_STEW, FLOWING_RABBIT_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.RABBIT_STEW_BLOCK)
            .bucket(ModItems.RABBIT_STEW_BUCKET);

    public static final BaseFlowingFluid.Properties BEEF_STEW_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.BEEF_STEW_FLUID_TYPE, SOURCE_BEEF_STEW, FLOWING_BEEF_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.BEEF_STEW_BLOCK)
            .bucket(ModItems.BEEF_STEW_BUCKET);

    public static final BaseFlowingFluid.Properties MUSHROOM_STEW_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.MUSHROOM_STEW_FLUID_TYPE, SOURCE_MUSHROOM_STEW, FLOWING_MUSHROOM_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.MUSHROOM_STEW_BLOCK)
            .bucket(ModItems.MUSHROOM_STEW_BUCKET);

    public static final BaseFlowingFluid.Properties GLOW_BERRY_CUSTARD_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.GLOW_BERRY_CUSTARD_FLUID_TYPE, SOURCE_GLOW_BERRY_CUSTARD, FLOWING_GLOW_BERRY_CUSTARD)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.GLOW_BERRY_CUSTARD_BLOCK)
            .bucket(ModItems.GLOW_BERRY_CUSTARD_BUCKET);

    public static final BaseFlowingFluid.Properties RATATOUILLE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.RATATOUILLE_FLUID_TYPE, SOURCE_RATATOUILLE, FLOWING_RATATOUILLE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.RATATOUILLE_BLOCK)
            .bucket(ModItems.RATATOUILLE_BUCKET);

    public static final BaseFlowingFluid.Properties DOG_FOOD_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.DOG_FOOD_FLUID_TYPE, SOURCE_DOG_FOOD, FLOWING_DOG_FOOD)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.DOG_FOOD_BLOCK)
            .bucket(ModItems.DOG_FOOD_BUCKET);

    public static final BaseFlowingFluid.Properties BAKED_COD_STEW_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.BAKED_COD_STEW_FLUID_TYPE, SOURCE_BAKED_COD_STEW, FLOWING_BAKED_COD_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.BAKED_COD_STEW_BLOCK)
            .bucket(ModItems.BAKED_COD_STEW_BUCKET);

    public static final BaseFlowingFluid.Properties BONE_BROTH_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.BONE_BROTH_FLUID_TYPE, SOURCE_BONE_BROTH, FLOWING_BONE_BROTH)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.BONE_BROTH_BLOCK)
            .bucket(ModItems.BONE_BROTH_BUCKET);

    public static final BaseFlowingFluid.Properties COOKED_RICE_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            ModFluidsTypes.COOKED_RICE_FLUID_TYPE, SOURCE_COOKED_RICE, FLOWING_COOKED_RICE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.COOKED_RICE_BLOCK)
            .bucket(ModItems.COOKED_RICE_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}

