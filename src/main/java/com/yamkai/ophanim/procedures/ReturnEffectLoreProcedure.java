package com.yamkai.ophanim.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class ReturnEffectLoreProcedure {
	public static String execute(ItemStack itemstack) {
		return "Contains Capacity For " + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("effect");
	}
}