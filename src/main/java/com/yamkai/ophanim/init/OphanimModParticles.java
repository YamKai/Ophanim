/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.yamkai.ophanim.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.yamkai.ophanim.client.particle.JetParticle;
import com.yamkai.ophanim.client.particle.BurstParticle;
import com.yamkai.ophanim.client.particle.AlertParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OphanimModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(OphanimModParticleTypes.BURST.get(), BurstParticle::provider);
		event.registerSpriteSet(OphanimModParticleTypes.ALERT.get(), AlertParticle::provider);
		event.registerSpriteSet(OphanimModParticleTypes.JET.get(), JetParticle::provider);
	}
}