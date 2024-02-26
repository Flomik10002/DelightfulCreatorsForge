package net.flomik.delightfulcreators.fluid;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidsTypes {
    public static final ResourceLocation STILL_TOMATO_SAUCE_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/tomato_sauce_still");
    public static final ResourceLocation FLOWING_TOMATO_SAUCE_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/tomato_sauce_flow");
    public static final ResourceLocation TOMATO_SAUCE_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/tomato_sauce_still");
    public static final ResourceLocation STILL_HOT_COCOA_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/hot_cocoa_still");
    public static final ResourceLocation FLOWING_HOT_COCOA_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/hot_cocoa_flow");
    public static final ResourceLocation HOT_COCOA_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/hot_cocoa_still");
    public static final ResourceLocation STILL_MELON_JUICE_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLOWING_MELON_JUICE_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation MELON_JUICE_OVERLAY_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation STILL_APPLE_CIDER_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation FLOWING_APPLE_CIDER_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation APPLE_CIDER_OVERLAY_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation STILL_BEETROOT_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/beetroot_soup_still");
    public static final ResourceLocation FLOWING_BEETROOT_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/beetroot_soup_flow");
    public static final ResourceLocation BEETROOT_SOUP_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/beetroot_soup_still");
    public static final ResourceLocation STILL_CHICKEN_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/chicken_soup_still");
    public static final ResourceLocation FLOWING_CHICKEN_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/chicken_soup_flow");
    public static final ResourceLocation CHICKEN_SOUP_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/chicken_soup_still");
    public static final ResourceLocation STILL_NOODLE_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/noodle_soup_still");
    public static final ResourceLocation FLOWING_NOODLE_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/noodle_soup_flow");
    public static final ResourceLocation NOODLE_SOUP_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/noodle_soup_still");
    public static final ResourceLocation STILL_PUMPKIN_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/pumpkin_soup_still");
    public static final ResourceLocation FLOWING_PUMPKIN_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/pumpkin_soup_flow");
    public static final ResourceLocation PUMPKIN_SOUP_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/pumpkin_soup_still");
    public static final ResourceLocation STILL_VEGETABLE_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/vegetable_soup_still");
    public static final ResourceLocation FLOWING_VEGETABLE_SOUP_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/vegetable_soup_flow");
    public static final ResourceLocation VEGETABLE_SOUP_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/vegetable_soup_still");
    public static final ResourceLocation STILL_FISH_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/fish_stew_still");
    public static final ResourceLocation FLOWING_FISH_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/fish_stew_flow");
    public static final ResourceLocation FISH_STEW_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/fish_stew_still");
    public static final ResourceLocation STILL_BEEF_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/beef_stew_still");
    public static final ResourceLocation FLOWING_BEEF_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/beef_stew_flow");
    public static final ResourceLocation BEEF_STEW_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/beef_stew_still");
    public static final ResourceLocation STILL_RABBIT_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/rabbit_stew_still");
    public static final ResourceLocation FLOWING_RABBIT_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/rabbit_stew_flow");
    public static final ResourceLocation RABBIT_STEW_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/rabbit_stew_still");
    public static final ResourceLocation STILL_MUSHROOM_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/mushroom_stew_still");
    public static final ResourceLocation FLOWING_MUSHROOM_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/mushroom_stew_flow");
    public static final ResourceLocation MUSHROOM_STEW_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/mushroom_stew_still");
    public static final ResourceLocation STILL_GLOW_BERRY_CUSTARD_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/glow_berry_custard_still");
    public static final ResourceLocation FLOWING_GLOW_BERRY_CUSTARD_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/glow_berry_custard_flow");
    public static final ResourceLocation GLOW_BERRY_CUSTARD_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/glow_berry_custard_still");
    public static final ResourceLocation STILL_RATATOUILLE_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/ratatouille_still");
    public static final ResourceLocation FLOWING_RATATOUILLE_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/ratatouille_flow");
    public static final ResourceLocation RATATOUILLE_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/ratatouille_still");
    public static final ResourceLocation STILL_DOG_FOOD_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/dog_food_still");
    public static final ResourceLocation FLOWING_DOG_FOOD_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/dog_food_flow");
    public static final ResourceLocation DOG_FOOD_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/dog_food_still");
    public static final ResourceLocation STILL_BAKED_COD_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/baked_cod_stew_still");
    public static final ResourceLocation FLOWING_BAKED_COD_STEW_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/baked_cod_stew_flow");
    public static final ResourceLocation BAKED_COD_STEW_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/baked_cod_stew_still");
    public static final ResourceLocation STILL_BONE_BROTH_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/bone_broth_still");
    public static final ResourceLocation FLOWING_BONE_BROTH_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/bone_broth_flow");
    public static final ResourceLocation BONE_BROTH_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/bone_broth_still");
    public static final ResourceLocation STILL_COOKED_RICE_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/cooked_rice_still");
    public static final ResourceLocation FLOWING_COOKED_RICE_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/cooked_rice_flow");
    public static final ResourceLocation COOKED_RICE_OVERLAY_RL = new ResourceLocation(DelightfulCreators.MOD_ID, "block/cooked_rice_still");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DelightfulCreators.MOD_ID);

    public static final RegistryObject<FluidType> TOMATO_SAUCE_FLUID_TYPE = FLUID_TYPES.register("tomato_sauce_fluid_type",
            () -> new BaseFluidType(STILL_TOMATO_SAUCE_RL, FLOWING_TOMATO_SAUCE_RL, TOMATO_SAUCE_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> HOT_COCOA_FLUID_TYPE = FLUID_TYPES.register("hot_cocoa_fluid_type",
            () -> new BaseFluidType(STILL_HOT_COCOA_RL, FLOWING_HOT_COCOA_RL, HOT_COCOA_OVERLAY_RL,
                    0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> MELON_JUICE_FLUID_TYPE = FLUID_TYPES.register("melon_juice_fluid_type",
            () -> new BaseFluidType(STILL_MELON_JUICE_RL, FLOWING_MELON_JUICE_RL, MELON_JUICE_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> APPLE_CIDER_FLUID_TYPE = FLUID_TYPES.register("apple_cider_fluid_type",
            () -> new BaseFluidType(STILL_APPLE_CIDER_RL, FLOWING_APPLE_CIDER_RL, APPLE_CIDER_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> BEETROOT_SOUP_FLUID_TYPE = FLUID_TYPES.register("beetroot_soup_fluid_type",
            () -> new BaseFluidType(STILL_BEETROOT_SOUP_RL, FLOWING_BEETROOT_SOUP_RL, BEETROOT_SOUP_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> CHICKEN_SOUP_FLUID_TYPE = FLUID_TYPES.register("chicken_soup_fluid_type",
            () -> new BaseFluidType(STILL_CHICKEN_SOUP_RL, FLOWING_CHICKEN_SOUP_RL, CHICKEN_SOUP_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> NOODLE_SOUP_FLUID_TYPE = FLUID_TYPES.register("noodle_soup_fluid_type",
            () -> new BaseFluidType(STILL_NOODLE_SOUP_RL, FLOWING_NOODLE_SOUP_RL, NOODLE_SOUP_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> PUMPKIN_SOUP_FLUID_TYPE = FLUID_TYPES.register("pumpkin_soup_fluid_type",
            () -> new BaseFluidType(STILL_PUMPKIN_SOUP_RL, FLOWING_PUMPKIN_SOUP_RL, PUMPKIN_SOUP_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> VEGETABLE_SOUP_FLUID_TYPE = FLUID_TYPES.register("vegetable_soup_fluid_type",
            () -> new BaseFluidType(STILL_VEGETABLE_SOUP_RL, FLOWING_VEGETABLE_SOUP_RL, VEGETABLE_SOUP_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> FISH_STEW_FLUID_TYPE = FLUID_TYPES.register("fish_stew_fluid_type",
            () -> new BaseFluidType(STILL_FISH_STEW_RL, FLOWING_FISH_STEW_RL, FISH_STEW_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> BEEF_STEW_FLUID_TYPE = FLUID_TYPES.register("beef_stew_fluid_type",
            () -> new BaseFluidType(STILL_BEEF_STEW_RL, FLOWING_BEEF_STEW_RL, BEEF_STEW_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> RABBIT_STEW_FLUID_TYPE = FLUID_TYPES.register("rabbit_stew_fluid_type",
            () -> new BaseFluidType(STILL_RABBIT_STEW_RL, FLOWING_RABBIT_STEW_RL, RABBIT_STEW_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> MUSHROOM_STEW_FLUID_TYPE = FLUID_TYPES.register("mushroom_stew_fluid_type",
            () -> new BaseFluidType(STILL_MUSHROOM_STEW_RL, FLOWING_MUSHROOM_STEW_RL, MUSHROOM_STEW_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> GLOW_BERRY_CUSTARD_FLUID_TYPE = FLUID_TYPES.register("glow_berry_custard_fluid_type",
            () -> new BaseFluidType(STILL_GLOW_BERRY_CUSTARD_RL, FLOWING_GLOW_BERRY_CUSTARD_RL, GLOW_BERRY_CUSTARD_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> RATATOUILLE_FLUID_TYPE = FLUID_TYPES.register("ratatouille_fluid_type",
            () -> new BaseFluidType(STILL_RATATOUILLE_RL, FLOWING_RATATOUILLE_RL, RATATOUILLE_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> DOG_FOOD_FLUID_TYPE = FLUID_TYPES.register("dog_food_fluid_type",
            () -> new BaseFluidType(STILL_DOG_FOOD_RL, FLOWING_DOG_FOOD_RL, DOG_FOOD_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> BAKED_COD_STEW_FLUID_TYPE = FLUID_TYPES.register("baked_cod_stew_fluid_type",
            () -> new BaseFluidType(STILL_BAKED_COD_STEW_RL, FLOWING_BAKED_COD_STEW_RL, BAKED_COD_STEW_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> BONE_BROTH_FLUID_TYPE = FLUID_TYPES.register("bone_broth_fluid_type",
            () -> new BaseFluidType(STILL_BONE_BROTH_RL, FLOWING_BONE_BROTH_RL, BONE_BROTH_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));

    public static final RegistryObject<FluidType> COOKED_RICE_FLUID_TYPE = FLUID_TYPES.register("cooked_rice_fluid_type",
            () -> new BaseFluidType(STILL_COOKED_RICE_RL, FLOWING_COOKED_RICE_RL, COOKED_RICE_OVERLAY_RL,
                0xA1FFFFFF, new Vector3f(196f / 255f, 24f / 255f, 16f / 255f), FluidType.Properties.create()
                    .canSwim(true).density(3000).viscosity(4000).sound(SoundAction.get("drink"), SoundEvents.HONEY_DRINK)));


    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
