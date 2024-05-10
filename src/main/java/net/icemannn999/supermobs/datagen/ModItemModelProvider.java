package net.icemannn999.supermobs.datagen;

import net.icemannn999.supermobs.SuperMobs;
import net.icemannn999.supermobs.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SuperMobs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.SUPER_SKELETON_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
