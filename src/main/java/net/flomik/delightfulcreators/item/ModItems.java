package net.flomik.delightfulcreators.item;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DelightfulCreators.MOD_ID);

    public static final RegistryObject<Item> INCOMPLETE_VEGETABLE_NOODLES = ITEMS.register("incomplete_vegetable_noodles",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_SQUID_INK_PASTA = ITEMS.register("incomplete_squid_ink_pasta",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_MUSHROOM_RICE = ITEMS.register("incomplete_mushroom_rice",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_FRIED_RICE = ITEMS.register("incomplete_fried_rice",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_DUMPLINGS = ITEMS.register("incomplete_dumplings",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_PASTA_DISH = ITEMS.register("incomplete_pasta_dish",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_PASTA_WITH_MEATBALLS = ITEMS.register("incomplete_pasta_with_meatballs",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_PASTA_WITH_MUTTON_CHOP = ITEMS.register("incomplete_pasta_with_mutton_chop",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_EGG_SANDWICH = ITEMS.register("incomplete_egg_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_CHICKEN_SANDWICH = ITEMS.register("incomplete_chicken_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_HAMBURGER = ITEMS.register("incomplete_hamburger",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_BACON_SANDWICH = ITEMS.register("incomplete_bacon_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_MUTTON_WRAP = ITEMS.register("incomplete_mutton_wrap",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_PUMPKIN_PIE = ITEMS.register("incomplete_pumpkin_pie",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_SWEET_BERRY_CHEESECAKE = ITEMS.register("incomplete_sweet_berry_cheesecake",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_APPLE_PIE = ITEMS.register("incomplete_apple_pie",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_ROAST_CHICKEN = ITEMS.register("incomplete_roast_chicken",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_STUFFED_PUMPKIN = ITEMS.register("incomplete_stuffed_pumpkin",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_HONEY_GLAZED_HAM = ITEMS.register("incomplete_honey_glazed_ham",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_SHEPHERDS_PIE = ITEMS.register("incomplete_shepherds_pie",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_RICE_ROLL_MEDLEY = ITEMS.register("incomplete_rice_roll_medley",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_FRUIT_SALAD = ITEMS.register("incomplete_fruit_salad",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_MIXED_SALAD = ITEMS.register("incomplete_mixed_salad",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_NETHER_SALAD = ITEMS.register("incomplete_nether_salad",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_BACON_AND_EGGS = ITEMS.register("incomplete_bacon_and_eggs",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_GRILLED_SALMON = ITEMS.register("incomplete_grilled_salmon",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_HORSE_FEED = ITEMS.register("incomplete_horse_feed",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final RegistryObject<Item> INCOMPLETE_ROASTED_MUTTON_CHOPS = ITEMS.register("incomplete_roasted_mutton_chops",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> INCOMPLETE_STEAK_AND_POTATOES = ITEMS.register("incomplete_steak_and_potatoes",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE).craftRemainder(Items.BOWL)));

    public static final RegistryObject<Item> PUMPKIN_PIE_SLICE = ITEMS.register("pumpkin_pie_slice",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
