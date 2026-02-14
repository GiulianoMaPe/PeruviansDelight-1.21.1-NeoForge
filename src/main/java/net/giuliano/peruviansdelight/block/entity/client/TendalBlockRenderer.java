package net.giuliano.peruviansdelight.block.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.giuliano.peruviansdelight.block.entity.TendalBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class TendalBlockRenderer implements BlockEntityRenderer<TendalBlockEntity> {
    private final ItemRenderer itemRenderer;

    public TendalBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(TendalBlockEntity be, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        int gridSize = 3; // 3x3
        float step = 1.0f / gridSize;
        float scale = 0.30f;

        for (int i = 0; i < be.inventory.getSlots(); i++) {
            ItemStack stack = be.inventory.getStackInSlot(i);
            if (!stack.isEmpty()) {
                poseStack.pushPose();

                // Calcular posición
                float xOffset = (i % gridSize) * step + (step / 2.0f);
                float zOffset = (i / gridSize) * step + (step / 2.0f);

                poseStack.translate(xOffset, 0.51f, zOffset); // 0.51 para que quede sobre el slab
                poseStack.scale(scale, scale, scale);
                poseStack.mulPose(Axis.XP.rotationDegrees(90)); // Item acostado
                poseStack.mulPose(Axis.ZP.rotationDegrees(180));

                itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, be.getLevel(), 0);

                poseStack.popPose();
            }
        }
    }
}
