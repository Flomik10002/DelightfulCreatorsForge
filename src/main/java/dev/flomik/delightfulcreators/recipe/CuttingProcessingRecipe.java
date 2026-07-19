package dev.flomik.delightfulcreators.recipe;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import com.simibubi.create.compat.jei.category.sequencedAssembly.SequencedAssemblySubCategory;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeParams;
import com.simibubi.create.content.processing.sequenced.IAssemblyRecipe;

import dev.flomik.delightfulcreators.DelightfulCreators;
import dev.flomik.delightfulcreators.block.ModBlocks;
import dev.flomik.delightfulcreators.compat.jei.MechanicalCuttingAssemblySubCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/**
 * Lets the Mechanical Cutter act as one step of a Create Sequenced Assembly chain, the same way
 * Create's own Mechanical Press does via PressingRecipe. This is a separate, opt-in recipe type
 * from the Farmer's Delight cutting-board recipes the Cutter automates by default - a recipe of
 * this type only exists if a datapack explicitly declares a "delightfulcreators:cutting_processing"
 * step inside a "create:sequenced_assembly" recipe.
 *
 * PORT RISK: the ProcessingRecipe<I, P> generic shape (I = SingleRecipeInput, P =
 * ProcessingRecipeParams) is inferred from Create 6.0's move to Minecraft 1.21's RecipeInput/Codec
 * recipe system and could not be verified against the real Create 1.21.1 jar in this environment
 * (no network access to Create's Maven repo) - check this file first if compileJava fails here.
 */
public class CuttingProcessingRecipe extends ProcessingRecipe<SingleRecipeInput, ProcessingRecipeParams>
        implements IAssemblyRecipe {

    public CuttingProcessingRecipe(ProcessingRecipeParams params) {
        super(DCRecipeTypes.CUTTING_PROCESSING, params);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        if (input.item().isEmpty())
            return false;
        return ingredients.get(0)
                .test(input.item());
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
