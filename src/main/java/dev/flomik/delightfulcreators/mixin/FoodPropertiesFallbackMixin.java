package dev.flomik.delightfulcreators.mixin;

import com.simibubi.create.AllDataComponents;

import dev.flomik.delightfulcreators.item.ModFoods;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.common.extensions.IItemStackExtension;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

/**
 * Our fallback Sequenced Assembly recipes (see CookingPotFallbackRecipes) use a plain copy of the
 * finished dish's own ItemStack as their transitional item, so it looks right on a belt mid-assembly
 * - but that means it's still literally the same item, with the same nutrition/saturation/potion
 * effects, while it's only "in progress" (tagged with Create's SEQUENCED_ASSEMBLY data component).
 * This replaces IItemStackExtension#getFoodProperties (the single choke point every eat/hunger check
 * goes through - see LivingEntity#eat) and substitutes our low-value ModFoods.INCOMPLETE profile
 * whenever that component is present, regardless of which real item is underneath, otherwise falling
 * back to the exact same delegation the original default method did (Mixin's injectors don't support
 * interface targets, so this has to be a full @Overwrite rather than an @Inject).
 *
 * PORT RISK: whether stack.has(AllDataComponents.SEQUENCED_ASSEMBLY) is the correct accessor (versus
 * needing stack.get(...) with a null check, or a differently-named component) could not be verified
 * against the real Create 1.21.1 jar in this environment (no network access to Create's Maven repo).
 */
@Mixin(value = IItemStackExtension.class, remap = false)
public interface FoodPropertiesFallbackMixin {

    @Overwrite
    default FoodProperties getFoodProperties(LivingEntity entity) {
        ItemStack self = (ItemStack) (Object) this;
        if (self.has(AllDataComponents.SEQUENCED_ASSEMBLY))
            return ModFoods.INCOMPLETE;
        return self.getItem()
                .getFoodProperties(self, entity);
    }

}
