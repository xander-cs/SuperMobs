package net.icemannn999.supermobs.entity.client;// Made with Blockbench 4.10.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.icemannn999.supermobs.entity.animations.ModAnimationDefinitions;
import net.icemannn999.supermobs.entity.custom.SkeletonEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SkeletonModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart superskeleton;
	private final ModelPart torso;
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart arms_right;
	private final ModelPart arm_right_front;
	private final ModelPart bicep_right_front;
	private final ModelPart forearm_right_front;
	private final ModelPart arm_right_back;
	private final ModelPart bicep_right_back;
	private final ModelPart forearm_right_back;
	private final ModelPart arms_left;
	private final ModelPart arm_left_front;
	private final ModelPart bicep_left_front;
	private final ModelPart forearm_left_front;
	private final ModelPart arm_left_back;
	private final ModelPart bicep_left_back;
	private final ModelPart forearm_left_back;
	private final ModelPart leg_right;
	private final ModelPart thigh_right;
	private final ModelPart lower_right;
	private final ModelPart foot_right;
	private final ModelPart leg_left;
	private final ModelPart thigh_left;
	private final ModelPart lower_left;
	private final ModelPart foot_left;

	public SkeletonModel(ModelPart root) {
		this.superskeleton = root.getChild("SuperSkeleton");
		this.torso = superskeleton.getChild("torso");
		this.head = torso.getChild("head");
		this.body = torso.getChild("body");
		this.arms_right = torso.getChild("arms_right");
		this.arm_right_front = arms_right.getChild("arm_right_front");
		this.bicep_right_front = arm_right_front.getChild("bicep_right_front");
		this.forearm_right_front = arm_right_front.getChild("forearm_right_front");
		this.arm_right_back = arms_right.getChild("arm_right_back");
		this.bicep_right_back = arm_right_back.getChild("bicep_right_back");
		this.forearm_right_back = arm_right_back.getChild("forearm_right_back");
		this.arms_left = torso.getChild("arms_left");
		this.arm_left_front = arms_left.getChild("arm_left_front");
		this.bicep_left_front = arm_left_front.getChild("bicep_left_front");
		this.forearm_left_front = arm_left_front.getChild("forearm_left_front");
		this.arm_left_back = arms_left.getChild("arm_left_back");
		this.bicep_left_back = arm_left_back.getChild("bicep_left_back");
		this.forearm_left_back = arm_left_back.getChild("forearm_left_back");
		this.leg_right = superskeleton.getChild("leg_right");
		this.thigh_right = leg_right.getChild("thigh_right");
		this.lower_right = leg_right.getChild("lower_right");
		this.foot_right = lower_right.getChild("foot_right");
		this.leg_left = superskeleton.getChild("leg_left");
		this.thigh_left = leg_left.getChild("thigh_left");
		this.lower_left = leg_left.getChild("lower_left");
		this.foot_left = lower_left.getChild("foot_left");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition SuperSkeleton = partdefinition.addOrReplaceChild("SuperSkeleton", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition torso = SuperSkeleton.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition body = torso.addOrReplaceChild("body", CubeListBuilder.create().texOffs(4, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition arms_right = torso.addOrReplaceChild("arms_right", CubeListBuilder.create(), PartPose.offset(-5.0F, -6.0F, -1.0F));

		PartDefinition arm_right_front = arms_right.addOrReplaceChild("arm_right_front", CubeListBuilder.create(), PartPose.offset(1.0F, -6.0F, 0.5F));

		PartDefinition bicep_right_front = arm_right_front.addOrReplaceChild("bicep_right_front", CubeListBuilder.create().texOffs(28, 17).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition forearm_right_front = arm_right_front.addOrReplaceChild("forearm_right_front", CubeListBuilder.create().texOffs(40, 18).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 12.0F, 0.0F));

		PartDefinition arm_right_back = arms_right.addOrReplaceChild("arm_right_back", CubeListBuilder.create(), PartPose.offset(1.0F, -6.0F, 3.0F));

		PartDefinition bicep_right_back = arm_right_back.addOrReplaceChild("bicep_right_back", CubeListBuilder.create().texOffs(30, 32).addBox(-2.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition forearm_right_back = arm_right_back.addOrReplaceChild("forearm_right_back", CubeListBuilder.create().texOffs(41, 33).mirror().addBox(-2.0F, 0.0F, -1.0F, 1.5F, 10.0F, 1.5F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition arms_left = torso.addOrReplaceChild("arms_left", CubeListBuilder.create(), PartPose.offset(5.0F, -6.0F, -1.0F));

		PartDefinition arm_left_front = arms_left.addOrReplaceChild("arm_left_front", CubeListBuilder.create(), PartPose.offset(-1.0F, -6.0F, 0.5F));

		PartDefinition bicep_left_front = arm_left_front.addOrReplaceChild("bicep_left_front", CubeListBuilder.create().texOffs(28, 17).mirror().addBox(0.0F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition forearm_left_front = arm_left_front.addOrReplaceChild("forearm_left_front", CubeListBuilder.create().texOffs(40, 18).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.5F, 12.0F, 0.0F));

		PartDefinition arm_left_back = arms_left.addOrReplaceChild("arm_left_back", CubeListBuilder.create(), PartPose.offset(-1.0F, -6.0F, 3.0F));

		PartDefinition bicep_left_back = arm_left_back.addOrReplaceChild("bicep_left_back", CubeListBuilder.create().texOffs(30, 32).addBox(0.0F, 0.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition forearm_left_back = arm_left_back.addOrReplaceChild("forearm_left_back", CubeListBuilder.create().texOffs(41, 33).addBox(0.5F, 0.0F, -1.0F, 1.5F, 10.0F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition leg_right = SuperSkeleton.addOrReplaceChild("leg_right", CubeListBuilder.create(), PartPose.offset(-3.0F, -24.0F, 0.0F));

		PartDefinition thigh_right = leg_right.addOrReplaceChild("thigh_right", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition lower_right = leg_right.addOrReplaceChild("lower_right", CubeListBuilder.create().texOffs(12, 32).addBox(0.125F, 0.0F, 0.375F, 1.5F, 12.0F, 1.5F, new CubeDeformation(0.0F))
				.texOffs(16, 32).addBox(-1.375F, 0.0F, 0.375F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.375F, 12.0F, -0.375F));

		PartDefinition foot_right = lower_right.addOrReplaceChild("foot_right", CubeListBuilder.create().texOffs(0, 47).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.125F, 11.0F, 0.375F));

		PartDefinition leg_left = SuperSkeleton.addOrReplaceChild("leg_left", CubeListBuilder.create(), PartPose.offset(3.0F, -24.0F, 0.0F));

		PartDefinition thigh_left = leg_left.addOrReplaceChild("thigh_left", CubeListBuilder.create().texOffs(0, 32).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.5F));

		PartDefinition lower_left = leg_left.addOrReplaceChild("lower_left", CubeListBuilder.create().texOffs(12, 32).mirror().addBox(-1.625F, 0.0F, 0.375F, 1.5F, 12.0F, 1.5F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(16, 32).mirror().addBox(0.375F, 0.0F, 0.375F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.375F, 12.0F, -0.375F));

		PartDefinition foot_left = lower_left.addOrReplaceChild("foot_left", CubeListBuilder.create().texOffs(0, 47).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.125F, 11.0F, 0.375F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);


		this.animateWalk(ModAnimationDefinitions.WALK, limbSwing, limbSwingAmount, 2f, 1f);
		this.animate(((SkeletonEntity) entity).idleAnimationState, ModAnimationDefinitions.IDLE, ageInTicks, 1);
		this.animate(((SkeletonEntity) entity).attackAnimationState, ModAnimationDefinitions.ATTACK, ageInTicks, 1);

		float originalRotation = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;
		this.arm_right_back.xRot = Mth.clamp(originalRotation, -0.1745329F, 0.2617994F);
		this.arm_left_back.xRot = Mth.clamp(originalRotation, -0.1745329F, 0.2617994F);
		this.arm_right_back.yRot = 0;
		this.arm_left_back.yRot = 0;
		this.arm_left_back.zRot = -115f;
		this.arm_right_back.zRot = 115f;
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks)
	{
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0f, 30.0f);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0f, 45.0f);

		this.head.yRot = pNetHeadYaw * ((float) Math.PI / 180f);
		this.head.xRot = pHeadPitch * ((float) Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		superskeleton.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return superskeleton;
	}
}