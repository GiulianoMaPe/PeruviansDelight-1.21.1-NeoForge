package net.giuliano.peruviansdelight.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.entity.custom.AtunEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AtunRenderer extends MobRenderer<AtunEntity, AtunModel<AtunEntity>> {
    public AtunRenderer(EntityRendererProvider.Context context) {
        super(context, new AtunModel<>(context.bakeLayer(AtunModel.LAYER_LOCATION)), 0.8f);
    }

    @Override
    public ResourceLocation getTextureLocation(AtunEntity atunEntity) {
        return ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, "textures/entity/atun.png");
    }

    @Override
    public void render(AtunEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
