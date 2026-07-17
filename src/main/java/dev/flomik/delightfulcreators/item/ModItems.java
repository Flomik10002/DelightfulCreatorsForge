package dev.flomik.delightfulcreators.item;

import dev.flomik.delightfulcreators.DelightfulCreators;
import dev.flomik.delightfulcreators.fluid.ModFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM, DelightfulCreators.MOD_ID);

    public static final DeferredHolder<Item, Item> INCOMPLETE_VEGETABLE_NOODLES = ITEMS.register("incomplete_vegetable_noodles",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_SQUID_INK_PASTA = ITEMS.register("incomplete_squid_ink_pasta",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_MUSHROOM_RICE = ITEMS.register("incomplete_mushroom_rice",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_FRIED_RICE = ITEMS.register("incomplete_fried_rice",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_DUMPLINGS = ITEMS.register("incomplete_dumplings",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_PASTA_DISH = ITEMS.register("incomplete_pasta_dish",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_PASTA_WITH_MEATBALLS = ITEMS.register("incomplete_pasta_with_meatballs",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_PASTA_WITH_MUTTON_CHOP = ITEMS.register("incomplete_pasta_with_mutton_chop",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_EGG_SANDWICH = ITEMS.register("incomplete_egg_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_CHICKEN_SANDWICH = ITEMS.register("incomplete_chicken_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_HAMBURGER = ITEMS.register("incomplete_hamburger",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_BACON_SANDWICH = ITEMS.register("incomplete_bacon_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_MUTTON_WRAP = ITEMS.register("incomplete_mutton_wrap",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_PUMPKIN_PIE = ITEMS.register("incomplete_pumpkin_pie",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_SWEET_BERRY_CHEESECAKE = ITEMS.register("incomplete_sweet_berry_cheesecake",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_APPLE_PIE = ITEMS.register("incomplete_apple_pie",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_ROAST_CHICKEN = ITEMS.register("incomplete_roast_chicken",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_STUFFED_PUMPKIN = ITEMS.register("incomplete_stuffed_pumpkin",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_HONEY_GLAZED_HAM = ITEMS.register("incomplete_honey_glazed_ham",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_SHEPHERDS_PIE = ITEMS.register("incomplete_shepherds_pie",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_RICE_ROLL_MEDLEY = ITEMS.register("incomplete_rice_roll_medley",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_FRUIT_SALAD = ITEMS.register("incomplete_fruit_salad",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_MIXED_SALAD = ITEMS.register("incomplete_mixed_salad",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_NETHER_SALAD = ITEMS.register("incomplete_nether_salad",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_BACON_AND_EGGS = ITEMS.register("incomplete_bacon_and_eggs",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_GRILLED_SALMON = ITEMS.register("incomplete_grilled_salmon",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_HORSE_FEED = ITEMS.register("incomplete_horse_feed",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_ROASTED_MUTTON_CHOPS = ITEMS.register("incomplete_roasted_mutton_chops",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_STEAK_AND_POTATOES = ITEMS.register("incomplete_steak_and_potatoes",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE_BOWL)));

    public static final DeferredHolder<Item, Item> PUMPKIN_PIE_SLICE = ITEMS.register("pumpkin_pie_slice",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> INCOMPLETE_STUFFED_POTATO = ITEMS.register("incomplete_stuffed_potato",
            () -> new Item(new Item.Properties().food(ModFoods.INCOMPLETE)));

    public static final DeferredHolder<Item, Item> TOMATO_SAUCE_BUCKET = ITEMS.register("tomato_sauce_bucket",
            () -> new BucketItem(ModFluids.SOURCE_TOMATO_SAUCE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> HOT_COCOA_BUCKET = ITEMS.register("hot_cocoa_bucket",
            () -> new BucketItem(ModFluids.SOURCE_HOT_COCOA.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> MELON_JUICE_BUCKET = ITEMS.register("melon_juice_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MELON_JUICE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> APPLE_CIDER_BUCKET = ITEMS.register("apple_cider_bucket",
            () -> new BucketItem(ModFluids.SOURCE_APPLE_CIDER.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> BEETROOT_SOUP_BUCKET = ITEMS.register("beetroot_soup_bucket",
            () -> new BucketItem(ModFluids.SOURCE_BEETROOT_SOUP.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> CHICKEN_SOUP_BUCKET = ITEMS.register("chicken_soup_bucket",
            () -> new BucketItem(ModFluids.SOURCE_CHICKEN_SOUP.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> NOODLE_SOUP_BUCKET = ITEMS.register("noodle_soup_bucket",
            () -> new BucketItem(ModFluids.SOURCE_NOODLE_SOUP.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> PUMPKIN_SOUP_BUCKET = ITEMS.register("pumpkin_soup_bucket",
            () -> new BucketItem(ModFluids.SOURCE_PUMPKIN_SOUP.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> VEGETABLE_SOUP_BUCKET = ITEMS.register("vegetable_soup_bucket",
            () -> new BucketItem(ModFluids.SOURCE_VEGETABLE_SOUP.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> FISH_STEW_BUCKET = ITEMS.register("fish_stew_bucket",
            () -> new BucketItem(ModFluids.SOURCE_FISH_STEW.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> BEEF_STEW_BUCKET = ITEMS.register("beef_stew_bucket",
            () -> new BucketItem(ModFluids.SOURCE_BEEF_STEW.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> RABBIT_STEW_BUCKET = ITEMS.register("rabbit_stew_bucket",
            () -> new BucketItem(ModFluids.SOURCE_RABBIT_STEW.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> MUSHROOM_STEW_BUCKET = ITEMS.register("mushroom_stew_bucket",
            () -> new BucketItem(ModFluids.SOURCE_MUSHROOM_STEW.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> GLOW_BERRY_CUSTARD_BUCKET = ITEMS.register("glow_berry_custard_bucket",
            () -> new BucketItem(ModFluids.SOURCE_GLOW_BERRY_CUSTARD.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> RATATOUILLE_BUCKET = ITEMS.register("ratatouille_bucket",
            () -> new BucketItem(ModFluids.SOURCE_RATATOUILLE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> DOG_FOOD_BUCKET = ITEMS.register("dog_food_bucket",
            () -> new BucketItem(ModFluids.SOURCE_DOG_FOOD.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> BAKED_COD_STEW_BUCKET = ITEMS.register("baked_cod_stew_bucket",
            () -> new BucketItem(ModFluids.SOURCE_BAKED_COD_STEW.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> BONE_BROTH_BUCKET = ITEMS.register("bone_broth_bucket",
            () -> new BucketItem(ModFluids.SOURCE_BONE_BROTH.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final DeferredHolder<Item, Item> COOKED_RICE_BUCKET = ITEMS.register("cooked_rice_bucket",
            () -> new BucketItem(ModFluids.SOURCE_COOKED_RICE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

