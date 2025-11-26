package dev.flomik.delightfulcreators.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties INCOMPLETE = new FoodProperties.Builder().nutrition(3).fast()
            .saturationModifier(0.3f).build();
}

