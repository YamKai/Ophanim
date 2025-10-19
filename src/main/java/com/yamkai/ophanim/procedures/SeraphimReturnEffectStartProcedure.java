package com.yamkai.ophanim.procedures;

import net.minecraft.world.entity.Entity;

import com.yamkai.ophanim.entity.SeraphimEntity;

public class SeraphimReturnEffectStartProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return (entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_start_effect) : 0) >= 1 ? true : false;
	}
}