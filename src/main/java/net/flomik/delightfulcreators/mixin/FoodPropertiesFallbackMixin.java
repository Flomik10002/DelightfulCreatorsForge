package net.flomik.delightfulcreators.mixin;

import net.flomik.delightfulcreators.item.ModFoods;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;

import net.minecraftforge.common.extensions.IForgeItemStack;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * Our fallback Sequenced Assembly recipes (see CookingPotFallbackRecipes) use a plain copy of the
 * finished dish's own ItemStack as their transitional item, so it looks right on a belt mid-assembly
 * - but that means it's still literally the same item, with the same nutrition/saturation/potion
 * effects, while it's only "in progress" (tagged with Create's "SequencedAssembly" NBT). This
 * replaces IForgeItemStack#getFoodProperties (the single choke point every eat/hunger check goes
 * through - see LivingEntity#eat) and substitutes our low-value ModFoods.INCOMPLETE profile whenever
 * that tag is present, regardless of which real item is underneath, otherwise falling back to the
 * exact same delegation the original default method did (Mixin's injectors don't support interface
 * targets, so this has to be a full @Overwrite rather than an @Inject).
 */
@Mixin(value = IForgeItemStack.class, remap = false)
public interface FoodPropertiesFallbackMixin {

    @Overwrite
    default FoodProperties getFoodProperties(LivingEntity entity) {
        ItemStack self = (ItemStack) (Object) this;
        if (self.hasTag() && self.getTag()
                .contains("SequencedAssembly"))
            return ModFoods.INCOMPLETE;
        return self.getItem()
                .getFoodProperties(self, entity);
    }

}
