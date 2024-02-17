package net.flomik.delightfulcreators.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties INCOMPLETE = new FoodProperties.Builder().nutrition(3).fast()
            .saturationMod(0.3f).build();
}
