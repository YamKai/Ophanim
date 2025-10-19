package com.yamkai.ophanim.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.yamkai.ophanim.entity.SeraphimEntity;

public class SeraphimRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		{
			Entity _ent = sourceentity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands()
						.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
								_ent.getDisplayName(), _ent.level().getServer(), _ent),
								("give @s ophanim:seraph[custom_data={effect:\"" + "" + (entity instanceof SeraphimEntity _datEntS ? _datEntS.getEntityData().get(SeraphimEntity.DATA_effect) : "") + "\"}]"));
			}
		}
		if (!entity.level().isClientSide())
			entity.discard();
	}
}