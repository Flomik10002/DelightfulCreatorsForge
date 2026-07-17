package dev.flomik.delightfulcreators.compat.jei;

import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedPress;
import com.simibubi.create.foundation.gui.AllGuiTextures;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotRichTooltipCallback;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;

import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

/**
 * Renders Farmer's Delight cutting board recipes with the Mechanical Press's own animation
 * (borrowed directly from Create's PressingCategory/AnimatedPress) instead of Farmer's Delight's
 * cutting board + knife visuals, since the Mechanical Cutter needs no held knife of its own.
 */
public class MechanicalCuttingCategory extends CreateRecipeCategory<CuttingBoardRecipe> {

    private final AnimatedPress press = new AnimatedPress(false);

    public MechanicalCuttingCategory(Info<CuttingBoardRecipe> info) {
        super(info);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CuttingBoardRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 27, 51)
                .setBackground(getRenderedSlot(), -1, -1)
                .addIngredients(recipe.getIngredients().get(0));

        NonNullList<ChanceResult> results = recipe.getRollableResults();
        int i = 0;
        for (ChanceResult output : results) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 131 + 19 * i, 50)
                    .setBackground(getRenderedSlot(output.chance()), -1, -1)
                    .addItemStack(output.stack())
                    .addRichTooltipCallback(addChanceTooltip(output));
            i++;
        }
    }

    @Override
    public void draw(CuttingBoardRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics graphics, double mouseX,
            double mouseY) {
        AllGuiTextures.JEI_SHADOW.render(graphics, 61, 41);
        AllGuiTextures.JEI_LONG_ARROW.render(graphics, 52, 54);
        press.draw(graphics, getBackground().getWidth() / 2 - 17, 22);
    }

    private static IRecipeSlotRichTooltipCallback addChanceTooltip(ChanceResult output) {
        return (view, tooltip) -> {
            float chance = output.chance();
            if (chance != 1)
                tooltip.add(Component.translatable("recipe.processing.chance", chance < 0.01 ? "<1" : (int) (chance * 100))
                        .withStyle(ChatFormatting.GOLD));
        };
    }

}
