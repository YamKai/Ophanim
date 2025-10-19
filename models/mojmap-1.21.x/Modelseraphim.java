// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelseraphim<T extends seraphim> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "seraphim"), "main");
	private final ModelPart full;
	private final ModelPart wings;
	private final ModelPart wing_1;
	private final ModelPart wing_2;
	private final ModelPart wing_3;
	private final ModelPart wing_4;
	private final ModelPart wing_5;
	private final ModelPart wing_6;
	private final ModelPart head;
	private final ModelPart eye;

	public Modelseraphim(ModelPart root) {
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

		PartDefinition full = partdefinition.addOrReplaceChild("full", CubeListBuilder.create(),
				PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition wings = full.addOrReplaceChild("wings", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition wing_1 = wings.addOrReplaceChild("wing_1", CubeListBuilder.create().texOffs(96, 12)
				.addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wing_2 = wings
				.addOrReplaceChild("wing_2",
						CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition wing_3 = wings
				.addOrReplaceChild("wing_3",
						CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0944F));

		PartDefinition wing_4 = wings
				.addOrReplaceChild("wing_4",
						CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition wing_5 = wings
				.addOrReplaceChild("wing_5",
						CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0944F));

		PartDefinition wing_6 = wings
				.addOrReplaceChild("wing_6",
						CubeListBuilder.create().texOffs(96, 12).addBox(-29.0F, -8.0F, -1.0F, 16.0F, 16.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition head = full.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 36)
						.addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -17.0F, -9.0F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition eye = head.addOrReplaceChild("eye",
				CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, 0.7F, 6.0F, 6.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -8.0F, -9.0F, 0.0F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		full.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.full.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.full.xRot = headPitch / (180F / (float) Math.PI);
	}
}