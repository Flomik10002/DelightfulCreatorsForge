package dev.flomik.delightfulcreators;

import com.mojang.logging.LogUtils;
import net.createmod.ponder.foundation.PonderIndex;
import dev.flomik.delightfulcreators.block.ModBlockEntityTypes;
import dev.flomik.delightfulcreators.block.ModBlocks;
import dev.flomik.delightfulcreators.block.cutter.MechanicalCutterRenderer;
import dev.flomik.delightfulcreators.block.cutter.ModPartialModels;
import dev.flomik.delightfulcreators.compat.ponder.DelightfulCreatorsPonderPlugin;
import dev.flomik.delightfulcreators.config.DCServerConfig;
import dev.flomik.delightfulcreators.fluid.ModFluids;
import dev.flomik.delightfulcreators.fluid.ModFluidsTypes;
import dev.flomik.delightfulcreators.item.ModCreativeModTabs;
import dev.flomik.delightfulcreators.item.ModItems;
import dev.flomik.delightfulcreators.recipe.DCRecipeTypes;
import net.neoforged.fml.config.ModConfig;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(DelightfulCreators.MOD_ID)
public class DelightfulCreators {
    public static final String MOD_ID = "delightfulcreators";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DelightfulCreators(ModContainer modContainer) {
        IEventBus modEventBus = modContainer.getEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntityTypes.register(modEventBus);

        ModFluidsTypes.register(modEventBus);
        ModFluids.register(modEventBus);

        DCRecipeTypes.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.SERVER, DCServerConfig.SERVER_SPEC);

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.INCOMPLETE_VEGETABLE_NOODLES.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_TOMATO_SAUCE.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_TOMATO_SAUCE.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_HOT_COCOA.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_HOT_COCOA.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MELON_JUICE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MELON_JUICE.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_APPLE_CIDER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_APPLE_CIDER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_BEETROOT_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BEETROOT_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_CHICKEN_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_CHICKEN_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_NOODLE_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_NOODLE_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_PUMPKIN_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PUMPKIN_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_VEGETABLE_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_VEGETABLE_SOUP.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_FISH_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_FISH_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_BEEF_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BEEF_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_RABBIT_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_RABBIT_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_MUSHROOM_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MUSHROOM_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_GLOW_BERRY_CUSTARD.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_GLOW_BERRY_CUSTARD.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_RATATOUILLE.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_RATATOUILLE.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_DOG_FOOD.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_DOG_FOOD.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_BAKED_COD_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BAKED_COD_STEW.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_BONE_BROTH.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BONE_BROTH.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_COOKED_RICE.get(), RenderType.solid());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_COOKED_RICE.get(), RenderType.solid());
            });
            ModPartialModels.init();
            PonderIndex.addPlugin(new DelightfulCreatorsPonderPlugin());
        }

        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntityTypes.MECHANICAL_CUTTER.get(), MechanicalCutterRenderer::new);
        }
    }
}