package net.icemannn999.supermobs.entity.client;

import net.icemannn999.supermobs.SuperMobs;
import net.icemannn999.supermobs.entity.custom.SuperSkeletonEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SuperSkeletonRenderer extends MobRenderer<SuperSkeletonEntity, SuperSkeletonModel<SuperSkeletonEntity>> {
    public SuperSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SuperSkeletonModel<>(pContext.bakeLayer(ModModelLayers.SKELETON_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(SuperSkeletonEntity skeletonEntity) {
        return new ResourceLocation(SuperMobs.MOD_ID, "textures/entity/mutant_skeleton.png");
    }
}
