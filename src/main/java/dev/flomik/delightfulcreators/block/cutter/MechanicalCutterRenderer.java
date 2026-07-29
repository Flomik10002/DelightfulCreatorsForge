package dev.flomik.delightfulcreators.block.cutter;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;

import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;

/**
 * TEMPORARY PLACEHOLDER ART: renders our own copy of Create's Mechanical Press body/pole model
 * with a spinning blade head (see ModPartialModels + assets/delightfulcreators/models/block/mechanical_cutter/*.json),
 * copied rather than referenced directly from Create so it's ours to edit. The blade uses vanilla's
 * animated stonecutter_saw texture, so it spins on its own via Minecraft's texture animation -
 * no per-frame rotation code needed here. The head is rendered into {@link RenderType#cutout()}
 * rather than solid() precisely because that texture has hard alpha edges - the model's own
 * "render_type" JSON field is NOT read here, since this SuperByteBuffer is drawn into a manually
 * chosen buffer instead of going through the normal model render-layer pipeline.
 *
 * This block has no Flywheel Visual registered, and Create's base KineticBlockEntityRenderer skips
 * all rendering (shaft included) once a Flywheel backend is active, so the shaft/head are rendered
 * here directly instead of through super.renderSafe(), bypassing that Flywheel gate entirely.
 */
public class MechanicalCutterRenderer extends KineticBlockEntityRenderer<MechanicalCutterBlockEntity> {

    public MechanicalCutterRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public boolean shouldRenderOffScreen(MechanicalCutterBlockEntity be) {
        return true;
    }

    @Override
    protected void renderSafe(MechanicalCutterBlockEntity be, float partialTicks, PoseStack ms,
            MultiBufferSource buffer, int light, int overlay) {
        BlockState renderedState = getRenderedBlockState(be);
        RenderType renderType = getRenderType(be, renderedState);
        renderRotatingBuffer(be, getRotatedModel(be, renderedState), ms, buffer.getBuffer(renderType), light);

        BlockState blockState = be.getBlockState();
        PressingBehaviour pressingBehaviour = be.getPressingBehaviour();
        float renderedHeadOffset =
                pressingBehaviour.getRenderedHeadOffset(partialTicks) * pressingBehaviour.mode.headOffset;

        SuperByteBuffer headRender = CachedBuffers.partialFacing(ModPartialModels.MECHANICAL_CUTTER_HEAD, blockState,
                blockState.getValue(HORIZONTAL_FACING));
        headRender.translate(0, -renderedHeadOffset, 0)
                .light(light)
                .renderInto(ms, buffer.getBuffer(RenderType.cutout()));
    }

    @Override
    protected BlockState getRenderedBlockState(MechanicalCutterBlockEntity be) {
        return shaft(getRotationAxisOf(be));
    }

}
