package com.yamkai.ophanim.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import com.yamkai.ophanim.init.OphanimModItems;

public class SeraphLeftClickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity seraphim = null;
		String response = "";
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == OphanimModItems.SERAPH.get()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.LINGERING_POTION) {
					response = executeCommandGetResult(entity, "data get entity @s Inventory[{Slot:-106b}].components.\"minecraft:potion_contents\".potion");
					{
						final String _tagName = "effect";
						final String _tagValue = (response.substring(response.indexOf("\"", 0) + 1, response.indexOf("\"", response.indexOf("\"", 0) + 1)));
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								("Capacitor Effect " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("effect")))), true);
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.GLASS_BOTTLE).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
				}
			}
		}
	}

	private static String executeCommandGetResult(Entity entity, String command) {
		StringBuilder result = new StringBuilder();
		if (!entity.level().isClientSide() && entity.getServer() != null) {
			CommandSource dataConsumer = new CommandSource() {
				@Override
				public void sendSystemMessage(Component message) {
					result.append(message.getString());
				}

				@Override
				public boolean acceptsSuccess() {
					return true;
				}

				@Override
				public boolean acceptsFailure() {
					return true;
				}

				@Override
				public boolean shouldInformAdmins() {
					return false;
				}
			};
			entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(dataConsumer, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel) entity.level() : null, 4,
					entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), command);
		}
		return result.toString();
	}
}