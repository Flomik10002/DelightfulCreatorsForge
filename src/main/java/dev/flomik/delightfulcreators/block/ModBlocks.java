package dev.flomik.delightfulcreators.block;

import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import dev.flomik.delightfulcreators.DelightfulCreators;
import dev.flomik.delightfulcreators.block.cutter.MechanicalCutterBlock;
import dev.flomik.delightfulcreators.fluid.ModFluids;
import dev.flomik.delightfulcreators.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, DelightfulCreators.MOD_ID);

    public static final DeferredHolder<Block, LiquidBlock> TOMATO_SAUCE_BLOCK = BLOCKS.register("tomato_sauce_block",
            () -> new LiquidBlock(ModFluids.SOURCE_TOMATO_SAUCE.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> HOT_COCOA_BLOCK = BLOCKS.register("hot_cocoa_block",
            () -> new LiquidBlock(ModFluids.SOURCE_HOT_COCOA.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> APPLE_CIDER_BLOCK = BLOCKS.register("apple_cider_block",
            () -> new LiquidBlock(ModFluids.SOURCE_APPLE_CIDER.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> MELON_JUICE_BLOCK = BLOCKS.register("melon_juice_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MELON_JUICE.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> BEETROOT_SOUP_BLOCK = BLOCKS.register("beetroot_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BEETROOT_SOUP.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> CHICKEN_SOUP_BLOCK = BLOCKS.register("chicken_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_CHICKEN_SOUP.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> NOODLE_SOUP_BLOCK = BLOCKS.register("noodle_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_NOODLE_SOUP.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> PUMPKIN_SOUP_BLOCK = BLOCKS.register("pumpkin_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_PUMPKIN_SOUP.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> VEGETABLE_SOUP_BLOCK = BLOCKS.register("vegetable_soup_block",
            () -> new LiquidBlock(ModFluids.SOURCE_VEGETABLE_SOUP.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> FISH_STEW_BLOCK = BLOCKS.register("fish_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_FISH_STEW.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> BEEF_STEW_BLOCK = BLOCKS.register("beef_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BEEF_STEW.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> RABBIT_STEW_BLOCK = BLOCKS.register("rabbit_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_RABBIT_STEW.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> MUSHROOM_STEW_BLOCK = BLOCKS.register("mushroom_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_MUSHROOM_STEW.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> GLOW_BERRY_CUSTARD_BLOCK = BLOCKS.register("glow_berry_custard_block",
            () -> new LiquidBlock(ModFluids.SOURCE_GLOW_BERRY_CUSTARD.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> RATATOUILLE_BLOCK = BLOCKS.register("ratatouille_block",
            () -> new LiquidBlock(ModFluids.SOURCE_RATATOUILLE.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> DOG_FOOD_BLOCK = BLOCKS.register("dog_food_block",
            () -> new LiquidBlock(ModFluids.SOURCE_DOG_FOOD.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> BAKED_COD_STEW_BLOCK = BLOCKS.register("baked_cod_stew_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BAKED_COD_STEW.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> BONE_BROTH_BLOCK = BLOCKS.register("bone_broth_block",
            () -> new LiquidBlock(ModFluids.SOURCE_BONE_BROTH.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, LiquidBlock> COOKED_RICE_BLOCK = BLOCKS.register("cooked_rice_block",
            () -> new LiquidBlock(ModFluids.SOURCE_COOKED_RICE.get(), BlockBehaviour.Properties.of().noCollission().strength(100.0F).noLootTable()));

    public static final DeferredHolder<Block, MechanicalCutterBlock> MECHANICAL_CUTTER = BLOCKS.register("mechanical_cutter",
            () -> new MechanicalCutterBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PODZOL)
                    .sound(SoundType.WOOD)
                    .strength(1.5F, 6.0F)
                    .noOcclusion()));

    // Uses Create's own AssemblyOperatorBlockItem so that placing this block directly on top of a
    // belt/depot/basin (like the Mechanical Press) skips the required empty gap automatically.
    public static final DeferredHolder<Item, Item> MECHANICAL_CUTTER_ITEM = ModItems.ITEMS.register("mechanical_cutter",
            () -> new AssemblyOperatorBlockItem(MECHANICAL_CUTTER.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

