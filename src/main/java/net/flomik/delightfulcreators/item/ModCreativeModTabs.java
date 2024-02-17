package net.flomik.delightfulcreators.item;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DelightfulCreators.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DELIGHTFULCREATORS_TAB = CREATIVE_MODE_TABS.register("delightfulcreators",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PUMPKIN_PIE_SLICE.get()))
                    .title(Component.translatable("creativetab.delightfulcreators_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.INCOMPLETE_VEGETABLE_NOODLES.get());
                        output.accept(ModItems.INCOMPLETE_SQUID_INK_PASTA.get());
                        output.accept(ModItems.INCOMPLETE_MUSHROOM_RICE.get());
                        output.accept(ModItems.INCOMPLETE_FRIED_RICE.get());
                        output.accept(ModItems.INCOMPLETE_DUMPLINGS.get());
                        output.accept(ModItems.INCOMPLETE_PASTA_DISH.get());
                        output.accept(ModItems.INCOMPLETE_PASTA_WITH_MEATBALLS.get());
                        output.accept(ModItems.INCOMPLETE_PASTA_WITH_MUTTON_CHOP.get());
                        output.accept(ModItems.INCOMPLETE_EGG_SANDWICH.get());
                        output.accept(ModItems.INCOMPLETE_CHICKEN_SANDWICH.get());
                        output.accept(ModItems.INCOMPLETE_HAMBURGER.get());
                        output.accept(ModItems.INCOMPLETE_BACON_SANDWICH.get());
                        output.accept(ModItems.INCOMPLETE_MUTTON_WRAP.get());
                        output.accept(ModItems.INCOMPLETE_PUMPKIN_PIE.get());
                        output.accept(ModItems.INCOMPLETE_SWEET_BERRY_CHEESECAKE.get());
                        output.accept(ModItems.INCOMPLETE_APPLE_PIE.get());
                        output.accept(ModItems.INCOMPLETE_ROAST_CHICKEN.get());
                        output.accept(ModItems.INCOMPLETE_STUFFED_PUMPKIN.get());
                        output.accept(ModItems.INCOMPLETE_HONEY_GLAZED_HAM.get());
                        output.accept(ModItems.INCOMPLETE_SHEPHERDS_PIE.get());
                        output.accept(ModItems.INCOMPLETE_RICE_ROLL_MEDLEY.get());
                        output.accept(ModItems.INCOMPLETE_FRUIT_SALAD.get());
                        output.accept(ModItems.INCOMPLETE_MIXED_SALAD.get());
                        output.accept(ModItems.INCOMPLETE_NETHER_SALAD.get());
                        output.accept(ModItems.INCOMPLETE_BACON_AND_EGGS.get());
                        output.accept(ModItems.INCOMPLETE_GRILLED_SALMON.get());
                        output.accept(ModItems.INCOMPLETE_HORSE_FEED.get());
                        output.accept(ModItems.INCOMPLETE_ROASTED_MUTTON_CHOPS.get());
                        output.accept(ModItems.INCOMPLETE_STEAK_AND_POTATOES.get());
                        output.accept(ModItems.PUMPKIN_PIE_SLICE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
