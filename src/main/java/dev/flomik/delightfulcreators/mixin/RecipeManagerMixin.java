package dev.flomik.delightfulcreators.mixin;

import java.util.Map;

import com.google.gson.JsonElement;

import dev.flomik.delightfulcreators.recipe.CookingPotFallbackRecipes;
import dev.flomik.delightfulcreators.recipe.SawBarkFallbackRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * Injects fallback recipes (see CookingPotFallbackRecipes, SawBarkFallbackRecipes) into the raw
 * recipe JSON map before RecipeManager parses it into real Recipe objects - so they go through
 * exactly the same vanilla parsing path as a real datapack recipe, with no further private-field
 * access needed. Runs on every reload (initial load and /reload), always working from the freshly-
 * loaded, real on-disk JSON only - nothing generated here ever persists between reloads.
 */
@Mixin(RecipeManager.class)
public class RecipeManagerMixin {

    @ModifyVariable(method = "apply", at = @At("HEAD"))
    private Map<ResourceLocation, JsonElement> delightfulcreators$injectFallbacks(
            Map<ResourceLocation, JsonElement> object) {
        Map<ResourceLocation, JsonElement> withCookingFallbacks = CookingPotFallbackRecipes.withFallbacks(object);
        return SawBarkFallbackRecipes.withBarkBonus(withCookingFallbacks);
    }

}
