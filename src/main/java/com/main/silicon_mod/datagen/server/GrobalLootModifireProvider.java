package com.main.silicon_mod.datagen.server;

import com.main.silicon_mod.SiliconMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class GrobalLootModifireProvider extends GlobalLootModifierProvider {
    public GrobalLootModifireProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, SiliconMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider registries) {

    }
}
