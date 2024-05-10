package net.icemannn999.supermobs.item;

import net.icemannn999.supermobs.SuperMobs;
import net.icemannn999.supermobs.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SuperMobs.MOD_ID);

    public static final RegistryObject<Item> SUPER_SKELETON_SPAWN_EGG = ITEMS.register("super_skeleton_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SKELETON, 10000536, 5395026, new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
