package com.yamkai.ophanim.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import com.yamkai.ophanim.network.OphanimModVariables;

@EventBusSubscriber
public class PlayerTickProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(OphanimModVariables.PLAYER_VARIABLES).hurt == true) {
			{
				OphanimModVariables.PlayerVariables _vars = entity.getData(OphanimModVariables.PLAYER_VARIABLES);
				_vars.hurt_time = entity.getData(OphanimModVariables.PLAYER_VARIABLES).hurt_time + 1;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(OphanimModVariables.PLAYER_VARIABLES).hurt_time >= 10) {
			{
				OphanimModVariables.PlayerVariables _vars = entity.getData(OphanimModVariables.PLAYER_VARIABLES);
				_vars.hurt = false;
				_vars.syncPlayerVariables(entity);
			}
			{
				OphanimModVariables.PlayerVariables _vars = entity.getData(OphanimModVariables.PLAYER_VARIABLES);
				_vars.hurt_time = 0;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}