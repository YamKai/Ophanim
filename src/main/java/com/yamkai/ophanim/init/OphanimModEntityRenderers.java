/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package com.yamkai.ophanim.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import com.yamkai.ophanim.client.renderer.SeraphimRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OphanimModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(OphanimModEntities.SERAPHIM.get(), SeraphimRenderer::new);
	}
}