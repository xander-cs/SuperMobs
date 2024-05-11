package net.icemannn999.supermobs.entity;

import net.icemannn999.supermobs.SuperMobs;
import net.icemannn999.supermobs.entity.custom.SuperSkeletonEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SuperMobs.MOD_ID);

    public static final RegistryObject<EntityType<SuperSkeletonEntity>> SUPER_SKELETON = ENTITY_TYPES.register("mutant_skeleton", () -> EntityType.Builder.of(SuperSkeletonEntity::new, MobCategory.MONSTER).sized(0.5f, 2.5f).build("mutant_skeleton"));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}
