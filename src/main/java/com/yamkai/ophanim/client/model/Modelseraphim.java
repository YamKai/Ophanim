package com.yamkai.ophanim.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelseraphim extends EntityModel<LivingEntityRenderState> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath("ophanim", "modelseraphim"), "main");
	public final ModelPart full;
	public final ModelPart wings;
	public final ModelPart wing_1;
	public final ModelPart wing_2;
	public final ModelPart wing_3;
	public final ModelPart wing_4;
	public final ModelPart wing_5;
	public final ModelPart wing_6;
	public final ModelPart head;
	public final ModelPart eye;

	public Modelseraphim(ModelPart root) {
		super(root);
		this.full = root.getChild("full");
		this.wings = this.full.getChild("wings");
		this.wing_1 = this.wings.getChild("wing_1");
		this.wing_2 = this.wings.getChild("wing_2");
		this.wing_3 = this.wings.getChild("wing_3");
		this.wing_4 = this.wings.getChild("wing_4");
		this.wing_5 = this.wings.getChild("wing_5");
		this.wing_6 = this.wings.getChild("wing_6");
		this.head = this.full.getChild("head");
		this.eye = this.head.getChild("eye");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition full = partdefinition.addOrReplaceChild("full", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));
		PartDefinition wings = full.addOrReplaceChild("wings", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.5236F));
		PartDefinition wing_1 = wings.addOrReplaceChild("wing_1", CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition wing_2 = wings.addOrReplaceChild("wing_2", CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));
		PartDefinition wing_3 = wings.addOrReplaceChild("wing_3", CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0944F));
		PartDefinition wing_4 = wings.addOrReplaceChild("wing_4", CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));
		PartDefinition wing_5 = wings.addOrReplaceChild("wing_5", CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0944F));
		PartDefinition wing_6 = wings.addOrReplaceChild("wing_6", CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));
		PartDefinition head = full.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 36).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-9.0F, -17.0F, -9.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 8.0F, 0.0F));
		PartDefinition eye = head.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, 0.7F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -9.0F, 0.0F, 0.0F, -0.7854F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void setupAnim(LivingEntityRenderState state) {
		float limbSwing = state.walkAnimationPos;
		float limbSwingAmount = state.walkAnimationSpeed;
		float ageInTicks = state.ageInTicks;
		float netHeadYaw = state.yRot;
		float headPitch = state.xRot;

		this.full.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.full.xRot = headPitch / (180F / (float) Math.PI);
	}
}