package com.main.silicon_mod.datagen.client;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModeIProvider extends ItemModelProvider {

    public ItemModeIProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SiliconMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SILICON_DIOXIDE_BUCKET.get());
    }
}
