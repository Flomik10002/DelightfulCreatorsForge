package net.flomik.delightfulcreators.recipe;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

import com.simibubi.create.compat.jei.category.sequencedAssembly.SequencedAssemblySubCategory;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeParams;
import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.flomik.delightfulcreators.block.ModBlocks;
import net.flomik.delightfulcreators.compat.jei.MechanicalCuttingAssemblySubCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.wrapper.RecipeWrapper;

/**
 * Lets the Mechanical Cutter act as one step of a Create Sequenced Assembly chain, the same way
 * Create's own Mechanical Press does via PressingRecipe. This is a separate, opt-in recipe type
 * from the Farmer's Delight cutting-board recipes the Cutter automates by default - a recipe of
 * this type only exists if a datapack explicitly declares a "delightfulcreators:cutting_processing"
 * step inside a "create:sequenced_assembly" recipe.
 */
@ParametersAreNonnullByDefault
public class CuttingProcessingRecipe extends ProcessingRecipe<RecipeWrapper> implements IAssemblyRecipe {

    public CuttingProcessingRecipe(ProcessingRecipeParams params) {
        super(DCRecipeTypes.CUTTING_PROCESSING, params);
    }

    @Override
    public boolean matches(RecipeWrapper inv, Level level) {
        if (inv.isEmpty())
            return false;
        return ingredients.get(0)
                .test(inv.getItem(0));
    }

    @Override
    protected int getMaxInputCount() {
        return 1;
    }

    @Override
    protected int getMaxOutputCount() {
        return 4;
    }

    @Override
    public void addAssemblyIngredients(List<Ingredient> list) {
        // Nothing extra to require - the transitional item itself is the single ingredient.
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public Component getDescriptionForAssembly() {
        return Component.translatable(DelightfulCreators.MOD_ID + ".recipe.assembly.cutting");
    }

    @Override
    public void addRequiredMachines(Set<ItemLike> list) {
        list.add(ModBlocks.MECHANICAL_CUTTER.get());
    }

    @Override
    public Supplier<Supplier<SequencedAssemblySubCategory>> getJEISubCategory() {
        return () -> MechanicalCuttingAssemblySubCategory::new;
    }

}
