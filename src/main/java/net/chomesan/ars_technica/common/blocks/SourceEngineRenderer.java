package net.chomesan.ars_technica.common.blocks;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;

import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.chomesan.ars_technica.client.AllPartialModels;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;

public class SourceEngineRenderer extends KineticBlockEntityRenderer<SourceEngineBlockEntity> {
    public SourceEngineRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(SourceEngineBlockEntity be, BlockState state) {
        return CachedBuffers.partialFacing(AllPartialModels.ARCANE_SHAFT_HALF, state);
    }

    @Override
    public void renderSafe(SourceEngineBlockEntity be, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light, int overlay) {

        super.renderSafe(be, partialTicks, poseStack, bufferSource, light, overlay);
        BlockState state = getRenderedBlockState(be);

        if (be.isFueled()) {

            Direction.Axis axis = ((IRotate) be.getBlockState()
                    .getBlock()).getRotationAxis(be.getBlockState());
            float angle = getAngleForTe(be, be.getBlockPos(), axis);
            SuperByteBuffer shaft = getRotatedModel(be, state);
            shaft.light(light);
            shaft.rotateCentered(angle, Direction.get(Direction.AxisDirection.POSITIVE, axis));
            shaft.renderInto(poseStack, bufferSource.getBuffer(RenderType.translucent()));
        }

    }
    public static float getAngleForTe(KineticBlockEntity be, final BlockPos pos, Direction.Axis axis) {
        float time = AnimationTickHolder.getRenderTime(be.getLevel());
        float offset = getRotationOffsetForPosition(be, pos, axis);
        float angle = ((time * be.getSpeed() * 3f / 10 + offset) % 360) / 180 * (float) Math.PI;
        return angle;
    }

}