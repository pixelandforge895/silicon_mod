package com.main.silicon_mod.datagen.client;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.registry.ModBlocks;
import com.main.silicon_mod.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {

    public ENUSLanguageProvider(PackOutput output) {
        super(output, SiliconMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.SILICON_DIOXIDE_BUCKET,"silicon dioxide bucket");
        add("creatives.silicon_tab","Introduction");
        add("death.attack.silicon_dioxide",
                "%s was dissolved in silicon dioxide");

        addBlock(ModBlocks.SILICON_DIOXIDE,"silicon dioxide");
        addBlock(ModBlocks.QUARTZ_GLASS,"quartz_glass");
        addBlock(ModBlocks.PLASMA_FURNACE,"plasma_furnace");
    }
}
