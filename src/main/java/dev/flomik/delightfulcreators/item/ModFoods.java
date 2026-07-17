package dev.flomik.delightfulcreators.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoods {
    public static final FoodProperties INCOMPLETE = new FoodProperties.Builder().nutrition(3).fast()
            .saturationModifier(0.3f).build();
    public static final FoodProperties INCOMPLETE_BOWL = new FoodProperties.Builder().nutrition(3).fast()
            .saturationModifier(0.3f).usingConvertsTo(Items.BOWL).build();
}

