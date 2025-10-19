package com.yamkai.ophanim.procedures;

import net.minecraft.world.entity.Entity;

import com.yamkai.ophanim.entity.SeraphimEntity;

public class SeraphimReturnEffectCooldownProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean logic = false;
		if (!((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_start_effect) : 0) >= 1)) {
			if ((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_cooldown) : 0) >= 1) {
				logic = true;
			}
		} else {
			logic = false;
		}
		return logic;
	}
}