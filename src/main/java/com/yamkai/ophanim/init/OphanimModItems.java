/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.yamkai.ophanim.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import java.util.function.Function;

import com.yamkai.ophanim.item.SeraphItem;
import com.yamkai.ophanim.OphanimMod;

public class OphanimModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(OphanimMod.MODID);
	public static final DeferredItem<Item> SERAPH = register("seraph", SeraphItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}