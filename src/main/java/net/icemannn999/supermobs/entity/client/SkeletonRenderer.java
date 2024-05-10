package net.icemannn999.supermobs.entity.client;

import net.icemannn999.supermobs.SuperMobs;
import net.icemannn999.supermobs.entity.custom.SkeletonEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SkeletonRenderer extends MobRenderer<SkeletonEntity, SkeletonModel<SkeletonEntity>> {
    public SkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SkeletonModel<>(pContext.bakeLayer(ModModelLayers.SKELETON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SkeletonEntity skeletonEntity) {
        return new ResourceLocation(SuperMobs.MOD_ID, "textures/entity/mutant_skeleton.png");
    }
}
