package net.giuliano.peruviansdelight.block.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.giuliano.peruviansdelight.block.custom.TendalBlock;
import net.giuliano.peruviansdelight.block.entity.TendalBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public class TendalBlockRenderer implements BlockEntityRenderer<TendalBlockEntity> {
    private final ItemRenderer itemRenderer;

    public TendalBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(TendalBlockEntity be, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        // Seguridad: Si el mundo o el bloque no son válidos, no hacemos nada
        if (be.getLevel() == null || be.getBlockState().getBlock() == net.minecraft.world.level.block.Blocks.AIR) {
            return;
        }

        BlockState state = be.getBlockState();
        // Seguridad: Verificamos si la propiedad existe antes de usarla
        Direction facing = Direction.NORTH;
        if (state.hasProperty(TendalBlock.FACING)) {
            facing = state.getValue(TendalBlock.FACING);
        }

        int gridSize = 3;
        float step = 1.0f / gridSize;
        float scale = 0.30f;

        // Usamos getSlots() para evitar índices fuera de rango
        int slots = be.inventory.getSlots();

        for (int i = 0; i < slots; i++) {
            ItemStack stack = be.inventory.getStackInSlot(i);
            if (!stack.isEmpty()) {
                poseStack.pushPose();

                // Centrar en el bloque
                poseStack.translate(0.5f, 0.51f, 0.5f);

                // Rotar según la dirección del bloque
                poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));

                // Calcular posición en la grilla 3x3
                // Centramos la grilla restando 0.5
                float xOffset = (i % gridSize) * step + (step / 2.0f) - 0.5f;
                float zOffset = (i / gridSize) * step + (step / 2.0f) - 0.5f;

                poseStack.translate(xOffset, 0, zOffset);

                // Escalar y rotar el ítem para que esté plano
                poseStack.scale(scale, scale, scale);
                poseStack.mulPose(Axis.XP.rotationDegrees(90));
                poseStack.mulPose(Axis.ZP.rotationDegrees(180)); // Corregir orientación de textura

                // Renderizar
                itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, bufferSource, be.getLevel(), 0);

                poseStack.popPose();
            }
        }
    }
}
