package net.icemannn999.supermobs.events;

import net.icemannn999.supermobs.SuperMobs;
import net.icemannn999.supermobs.entity.client.ModModelLayers;
import net.icemannn999.supermobs.entity.client.SuperSkeletonModel;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SuperMobs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventsBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event)
    {
        event.registerLayerDefinition(ModModelLayers.SKELETON_LAYER, SuperSkeletonModel::createBodyLayer);
    }
}
