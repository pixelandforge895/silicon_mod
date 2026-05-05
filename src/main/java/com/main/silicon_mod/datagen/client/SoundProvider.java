package com.main.silicon_mod.datagen.client;

import com.main.silicon_mod.SiliconMod;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SoundDefinitionsProvider;

public class SoundProvider extends SoundDefinitionsProvider {

    public SoundProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, SiliconMod.MOD_ID, helper);
    }

    @Override
    public void registerSounds() {

    }
}
