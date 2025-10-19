package com.yamkai.ophanim.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.yamkai.ophanim.network.OphanimModVariables;
import com.yamkai.ophanim.init.OphanimModParticleTypes;
import com.yamkai.ophanim.entity.SeraphimEntity;

public class SeraphimOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity owner = null;
		double delta_y_owner = 0;
		if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
			owner = entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null;
			delta_y_owner = ((owner.getY() + 1.25) - entity.getY()) / 20;
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), delta_y_owner, (entity.getDeltaMovement().z())));
			if ((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_cooldown) : 0) >= 1) {
				if (entity instanceof SeraphimEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SeraphimEntity.DATA_cooldown, (int) ((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_cooldown) : 0) - 1));
				if ((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_cooldown) : 0) == 10) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("ophanim:seraphim.on")), SoundSource.MASTER, (float) 0.4, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("ophanim:seraphim.on")), SoundSource.MASTER, (float) 0.4, 1, false);
						}
					}
				}
			}
			if (!((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_cooldown) : 0) >= 1)) {
				if (owner.getData(OphanimModVariables.PLAYER_VARIABLES).hurt == true) {
					if (entity instanceof SeraphimEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SeraphimEntity.DATA_start_effect, 200);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("ophanim:seraphim.burst")), SoundSource.MASTER, (float) 0.6, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("ophanim:seraphim.burst")), SoundSource.MASTER, (float) 0.6, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (OphanimModParticleTypes.ALERT.get()), x, y, z, 3, 0.2, 0.2, 0.2, 0);
					if (entity instanceof SeraphimEntity _datEntSetI)
						_datEntSetI.getEntityData().set(SeraphimEntity.DATA_cooldown, (int) (3 * (entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_start_effect) : 0)));
					entity.getPersistentData().putDouble("timer", (-5));
				}
			}
			if ((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_start_effect) : 0) >= 1) {
				if ((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_start_effect) : 0) == 10) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("ophanim:seraphim.off")), SoundSource.MASTER, (float) 0.4, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("ophanim:seraphim.off")), SoundSource.MASTER, (float) 0.4, 1, false);
						}
					}
				}
				if (entity instanceof SeraphimEntity _datEntSetI)
					_datEntSetI.getEntityData().set(SeraphimEntity.DATA_start_effect, (int) ((entity instanceof SeraphimEntity _datEntI ? _datEntI.getEntityData().get(SeraphimEntity.DATA_start_effect) : 0) - 1));
				if (!((entity instanceof SeraphimEntity _datEntS ? _datEntS.getEntityData().get(SeraphimEntity.DATA_effect) : "").equals("null"))) {
					{
						Entity _ent = owner;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands()
									.performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(),
													_ent.getDisplayName(), _ent.level().getServer(), _ent),
											("effect give @s " + (entity instanceof SeraphimEntity _datEntS ? _datEntS.getEntityData().get(SeraphimEntity.DATA_effect) : "") + " 1 1 false"));
						}
					}
					entity.setDeltaMovement(new Vec3(0, 0, 0));
					entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
					if (entity.getPersistentData().getDouble("timer") >= 4) {
						if (world instanceof ServerLevel _level)
							_level.sendParticles((SimpleParticleType) (OphanimModParticleTypes.BURST.get()), x, y, z, 1, 0, 0, 0, 0);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.MASTER, (float) 0.1, (float) 0.4);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.MASTER, (float) 0.1, (float) 0.4, false);
							}
						}
						entity.getPersistentData().putDouble("timer", 0);
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (OphanimModParticleTypes.JET.get()), (x - entity.getDeltaMovement().x() * 4), (y + 0.1), (z - entity.getDeltaMovement().z() * 4), 1, 0.005, 0.005, 0.005, 0);
				if (entity.getPersistentData().getDouble("timer") >= 1) {
					entity.getPersistentData().putDouble("timer", 0);
				}
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20, 255, false, false));
	}
}