package com.main.silicon_mod.datagen.client;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.registry.ModBlocks;
import com.main.silicon_mod.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {

    public JAJPLanguageProvider(PackOutput output) {
        super(output, SiliconMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(ModItems.SILICON_DIOXIDE_BUCKET,"酸化ケイ素入りバケツ");
        add("creatives.silicon_tab","入門");
        add("death.attack.silicon_dioxide",
                "%sは二酸化ケイ素に溶かされた");

        addBlock(ModBlocks.SILICON_DIOXIDE,"酸化ケイ素");
        addBlock(ModBlocks.QUARTZ_GLASS,"石英ガラス");
        addBlock(ModBlocks.PLASMA_FURNACE,"プラズマ溶融炉");

    }
}
