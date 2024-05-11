package net.icemannn999.supermobs.events;

import net.icemannn999.supermobs.SuperMobs;
import net.icemannn999.supermobs.entity.ModEntities;
import net.icemannn999.supermobs.entity.custom.SuperSkeletonEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SuperMobs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModeEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.SUPER_SKELETON.get(), SuperSkeletonEntity.createAttributes().build());
    }
}
