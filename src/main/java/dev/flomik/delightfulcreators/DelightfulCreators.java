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