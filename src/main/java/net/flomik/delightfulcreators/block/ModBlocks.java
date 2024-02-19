package net.flomik.delightfulcreators.block;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.flomik.delightfulcreators.fluid.ModFluids;
import net.flomik.delightfulcreators.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DelightfulCreators.MOD_ID);

    public static final RegistryObject<LiquidBlock> TOMATO_SAUCE_BLOCK = BLOCKS.register("tomato_sauce_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TOMATO_SAUCE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> HOT_COCOA_BLOCK = BLOCKS.register("hot_cocoa_block",
            () -> new LiquidBlock(ModFluids.SOURCE_HOT_COCOA, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> APPLE_CIDER_BLOCK = BLOCKS.register("apple_cider_block",
            () -> new LiquidBlock(ModFluids.SOURCE_APPLE_CIDER, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> MELON_JUICE_BLOCK = BLOCKS.register("melon_juice_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MELON_JUICE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> BEETROOT_SOUP_BLOCK = BLOCKS.register("beetroot_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BEETROOT_SOUP, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> CHICKEN_SOUP_BLOCK = BLOCKS.register("chicken_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_CHICKEN_SOUP, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> NOODLE_SOUP_BLOCK = BLOCKS.register("noodle_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_NOODLE_SOUP, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> PUMPKIN_SOUP_BLOCK = BLOCKS.register("pumpkin_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_PUMPKIN_SOUP, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> VEGETABLE_SOUP_BLOCK = BLOCKS.register("vegetable_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_VEGETABLE_SOUP, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> FISH_STEW_BLOCK = BLOCKS.register("fish_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_FISH_STEW, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> BEEF_STEW_BLOCK = BLOCKS.register("beef_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BEEF_STEW, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> RABBIT_STEW_BLOCK = BLOCKS.register("rabbit_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_RABBIT_STEW, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> MUSHROOM_STEW_BLOCK = BLOCKS.register("mushroom_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MUSHROOM_STEW, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> GLOW_BERRY_CUSTARD_BLOCK = BLOCKS.register("glow_berry_custard_block",
            () -> new LiquidBlock(ModFluids.SOURCE_GLOW_BERRY_CUSTARD, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> RATATOUILLE_BLOCK = BLOCKS.register("ratatouille_block",
            () -> new LiquidBlock(ModFluids.SOURCE_RATATOUILLE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> DOG_FOOD_BLOCK = BLOCKS.register("dog_food_block",
            () -> new LiquidBlock(ModFluids.SOURCE_DOG_FOOD, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> BAKED_COD_STEW_BLOCK = BLOCKS.register("baked_cod_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BAKED_COD_STEW, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> BONE_BROTH_BLOCK = BLOCKS.register("bone_broth_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BONE_BROTH, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static final RegistryObject<LiquidBlock> COOKED_RICE_BLOCK = BLOCKS.register("cooked_rice_block",
            () -> new LiquidBlock(ModFluids.SOURCE_COOKED_RICE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
