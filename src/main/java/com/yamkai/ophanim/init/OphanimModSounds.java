/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.yamkai.ophanim.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import com.yamkai.ophanim.OphanimMod;

public class OphanimModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, OphanimMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> SERAPHIM_ON = REGISTRY.register("seraphim.on", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ophanim", "seraphim.on")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SERAPHIM_OFF = REGISTRY.register("seraphim.off", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ophanim", "seraphim.off")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SERAPHIM_CHAT = REGISTRY.register("seraphim.chat", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ophanim", "seraphim.chat")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SERAPHIM_BURST = REGISTRY.register("seraphim.burst", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("ophanim", "seraphim.burst")));
}