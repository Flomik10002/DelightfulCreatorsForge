package net.flomik.delightfulcreators.compat.jei;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.compat.jei.category.animations.AnimatedPress;
import com.simibubi.create.compat.jei.category.sequencedAssembly.SequencedAssemblySubCategory;
import com.simibubi.create.content.processing.sequenced.SequencedRecipe;

import net.minecraft.client.gui.GuiGraphics;

/**
 * Visual for the Mechanical Cutter step inside Create's Sequenced Assembly JEI display, reusing
 * the Mechanical Press animation like the rest of our JEI integration (see
 * MechanicalCuttingCategory) instead of drawing anything Cutter-specific.
 */
public class MechanicalCuttingAssemblySubCategory extends SequencedAssemblySubCategory {

    private final AnimatedPress press = new AnimatedPress(false);

    public MechanicalCuttingAssemblySubCategory() {
        super(25);
    }

    @Override
    public void draw(SequencedRecipe<?> recipe, GuiGraphics graphics, double mouseX, double mouseY, int index) {
        PoseStack ms = graphics.pose();
        press.offset = index;
        ms.pushPose();
        ms.translate(-5, 50, 0);
        ms.scale(.6f, .6f, .6f);
        press.draw(graphics, getWidth() / 2, 0);
        ms.popPose();
    }

}
