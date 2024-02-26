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
    public static final RegistryObject<FlowingFluid> SOURCE_HOT_COCOA = FLUIDS.register("hot_cocoa_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HOT_COCOA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HOT_COCOA = FLUIDS.register("flowing_hot_cocoa",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HOT_COCOA_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_MELON_JUICE = FLUIDS.register("melon_juice_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MELON_JUICE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MELON_JUICE = FLUIDS.register("flowing_melon_juice",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MELON_JUICE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_APPLE_CIDER = FLUIDS.register("apple_cider_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.APPLE_CIDER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_APPLE_CIDER = FLUIDS.register("flowing_apple_cider",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.APPLE_CIDER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_BEETROOT_SOUP = FLUIDS.register("beetroot_soup_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BEETROOT_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BEETROOT_SOUP = FLUIDS.register("flowing_beetroot_soup",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BEETROOT_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_CHICKEN_SOUP = FLUIDS.register("chicken_soup_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.CHICKEN_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CHICKEN_SOUP = FLUIDS.register("flowing_chicken_soup",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CHICKEN_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_NOODLE_SOUP = FLUIDS.register("noodle_soup_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.NOODLE_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_NOODLE_SOUP = FLUIDS.register("flowing_noodle_soup",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.NOODLE_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_PUMPKIN_SOUP = FLUIDS.register("pumpkin_soup_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.PUMPKIN_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PUMPKIN_SOUP = FLUIDS.register("flowing_pumpkin_soup",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.PUMPKIN_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_VEGETABLE_SOUP = FLUIDS.register("vegetable_soup_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.VEGETABLE_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_VEGETABLE_SOUP = FLUIDS.register("flowing_vegetable_soup",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.VEGETABLE_SOUP_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_FISH_STEW = FLUIDS.register("fish_stew_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.FISH_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_FISH_STEW = FLUIDS.register("flowing_fish_stew",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.FISH_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_BEEF_STEW = FLUIDS.register("beef_stew_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BEEF_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BEEF_STEW = FLUIDS.register("flowing_beef_stew",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BEEF_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_RABBIT_STEW = FLUIDS.register("rabbit_stew_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.RABBIT_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_RABBIT_STEW = FLUIDS.register("flowing_rabbit_stew",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.RABBIT_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_MUSHROOM_STEW = FLUIDS.register("mushroom_stew_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.MUSHROOM_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_MUSHROOM_STEW = FLUIDS.register("flowing_mushroom_stew",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MUSHROOM_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_GLOW_BERRY_CUSTARD = FLUIDS.register("glow_berry_custard_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.GLOW_BERRY_CUSTARD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_GLOW_BERRY_CUSTARD = FLUIDS.register("flowing_glow_berry_custard",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.GLOW_BERRY_CUSTARD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_RATATOUILLE = FLUIDS.register("ratatouille_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.RATATOUILLE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_RATATOUILLE = FLUIDS.register("flowing_ratatouille",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.RATATOUILLE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_DOG_FOOD = FLUIDS.register("dog_food_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.DOG_FOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_DOG_FOOD = FLUIDS.register("flowing_dog_food",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.DOG_FOOD_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_BAKED_COD_STEW = FLUIDS.register("baked_cod_stew_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BAKED_COD_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BAKED_COD_STEW = FLUIDS.register("flowing_baked_cod_stew",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BAKED_COD_STEW_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_BONE_BROTH = FLUIDS.register("bone_broth_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BONE_BROTH_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BONE_BROTH = FLUIDS.register("flowing_bone_broth",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BONE_BROTH_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> SOURCE_COOKED_RICE = FLUIDS.register("cooked_rice_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.COOKED_RICE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_COOKED_RICE = FLUIDS.register("flowing_cooked_rice",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.COOKED_RICE_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties TOMATO_SAUCE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.TOMATO_SAUCE_FLUID_TYPE, SOURCE_TOMATO_SAUCE, FLOWING_TOMATO_SAUCE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.TOMATO_SAUCE_BLOCK)
            .bucket(ModItems.TOMATO_SAUCE_BUCKET);

    public static final ForgeFlowingFluid.Properties HOT_COCOA_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.HOT_COCOA_FLUID_TYPE, SOURCE_HOT_COCOA, FLOWING_HOT_COCOA)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.HOT_COCOA_BLOCK)
            .bucket(ModItems.HOT_COCOA_BUCKET);

    public static final ForgeFlowingFluid.Properties MELON_JUICE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.MELON_JUICE_FLUID_TYPE, SOURCE_MELON_JUICE, FLOWING_MELON_JUICE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).tickRate(5).block(ModBlocks.MELON_JUICE_BLOCK)
            .bucket(ModItems.MELON_JUICE_BUCKET);

    public static final ForgeFlowingFluid.Properties APPLE_CIDER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.APPLE_CIDER_FLUID_TYPE, SOURCE_APPLE_CIDER, FLOWING_APPLE_CIDER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).tickRate(5).block(ModBlocks.APPLE_CIDER_BLOCK)
            .bucket(ModItems.APPLE_CIDER_BUCKET);

    public static final ForgeFlowingFluid.Properties BEETROOT_SOUP_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.BEETROOT_SOUP_FLUID_TYPE, SOURCE_BEETROOT_SOUP, FLOWING_BEETROOT_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.BEETROOT_SOUP_BLOCK)
            .bucket(ModItems.BEETROOT_SOUP_BUCKET);

    public static final ForgeFlowingFluid.Properties CHICKEN_SOUP_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.CHICKEN_SOUP_FLUID_TYPE, SOURCE_CHICKEN_SOUP, FLOWING_CHICKEN_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.CHICKEN_SOUP_BLOCK)
            .bucket(ModItems.CHICKEN_SOUP_BUCKET);

    public static final ForgeFlowingFluid.Properties NOODLE_SOUP_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.NOODLE_SOUP_FLUID_TYPE, SOURCE_NOODLE_SOUP, FLOWING_NOODLE_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.NOODLE_SOUP_BLOCK)
            .bucket(ModItems.NOODLE_SOUP_BUCKET);

    public static final ForgeFlowingFluid.Properties PUMPKIN_SOUP_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.PUMPKIN_SOUP_FLUID_TYPE, SOURCE_PUMPKIN_SOUP, FLOWING_PUMPKIN_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.PUMPKIN_SOUP_BLOCK)
            .bucket(ModItems.PUMPKIN_SOUP_BUCKET);

    public static final ForgeFlowingFluid.Properties VEGETABLE_SOUP_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.VEGETABLE_SOUP_FLUID_TYPE, SOURCE_VEGETABLE_SOUP, FLOWING_VEGETABLE_SOUP)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.VEGETABLE_SOUP_BLOCK)
            .bucket(ModItems.VEGETABLE_SOUP_BUCKET);

    public static final ForgeFlowingFluid.Properties FISH_STEW_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.FISH_STEW_FLUID_TYPE, SOURCE_FISH_STEW, FLOWING_FISH_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.FISH_STEW_BLOCK)
            .bucket(ModItems.FISH_STEW_BUCKET);

    public static final ForgeFlowingFluid.Properties RABBIT_STEW_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.RABBIT_STEW_FLUID_TYPE, SOURCE_RABBIT_STEW, FLOWING_RABBIT_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.RABBIT_STEW_BLOCK)
            .bucket(ModItems.RABBIT_STEW_BUCKET);

    public static final ForgeFlowingFluid.Properties BEEF_STEW_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.BEEF_STEW_FLUID_TYPE, SOURCE_BEEF_STEW, FLOWING_BEEF_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.BEEF_STEW_BLOCK)
            .bucket(ModItems.BEEF_STEW_BUCKET);

    public static final ForgeFlowingFluid.Properties MUSHROOM_STEW_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.MUSHROOM_STEW_FLUID_TYPE, SOURCE_MUSHROOM_STEW, FLOWING_MUSHROOM_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.MUSHROOM_STEW_BLOCK)
            .bucket(ModItems.MUSHROOM_STEW_BUCKET);

    public static final ForgeFlowingFluid.Properties GLOW_BERRY_CUSTARD_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.GLOW_BERRY_CUSTARD_FLUID_TYPE, SOURCE_GLOW_BERRY_CUSTARD, FLOWING_GLOW_BERRY_CUSTARD)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.GLOW_BERRY_CUSTARD_BLOCK)
            .bucket(ModItems.GLOW_BERRY_CUSTARD_BUCKET);

    public static final ForgeFlowingFluid.Properties RATATOUILLE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.RATATOUILLE_FLUID_TYPE, SOURCE_RATATOUILLE, FLOWING_RATATOUILLE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.RATATOUILLE_BLOCK)
            .bucket(ModItems.RATATOUILLE_BUCKET);

    public static final ForgeFlowingFluid.Properties DOG_FOOD_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.DOG_FOOD_FLUID_TYPE, SOURCE_DOG_FOOD, FLOWING_DOG_FOOD)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.DOG_FOOD_BLOCK)
            .bucket(ModItems.DOG_FOOD_BUCKET);

    public static final ForgeFlowingFluid.Properties BAKED_COD_STEW_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.BAKED_COD_STEW_FLUID_TYPE, SOURCE_BAKED_COD_STEW, FLOWING_BAKED_COD_STEW)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.BAKED_COD_STEW_BLOCK)
            .bucket(ModItems.BAKED_COD_STEW_BUCKET);

    public static final ForgeFlowingFluid.Properties BONE_BROTH_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.BONE_BROTH_FLUID_TYPE, SOURCE_BONE_BROTH, FLOWING_BONE_BROTH)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.BONE_BROTH_BLOCK)
            .bucket(ModItems.BONE_BROTH_BUCKET);

    public static final ForgeFlowingFluid.Properties COOKED_RICE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidsTypes.COOKED_RICE_FLUID_TYPE, SOURCE_COOKED_RICE, FLOWING_COOKED_RICE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).tickRate(30).block(ModBlocks.COOKED_RICE_BLOCK)
            .bucket(ModItems.COOKED_RICE_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
