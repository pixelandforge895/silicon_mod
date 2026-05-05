package com.main.silicon_mod.datagen;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.datagen.client.*;
import com.main.silicon_mod.datagen.server.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

//runData実行時に実行される.
@Mod.EventBusSubscriber(modid = SiliconMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        net.minecraft.data.DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new ItemModeIProvider(packOutput,existingFileHelper));

        generator.addProvider(event.includeClient(),new BlockStateProvider(packOutput,existingFileHelper));

        generator.addProvider(event.includeClient(),new JAJPLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(),new ENUSLanguageProvider(packOutput));

        generator.addProvider(event.includeClient(),new SoundProvider(packOutput,existingFileHelper));

        BlockTagsProvider blockTagsProvider = generator.addProvider(event.includeServer(),
                new BlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(),
                new ItemTagsProvider(packOutput,lookupProvider,
                        blockTagsProvider.contentsGetter(),existingFileHelper));

        generator.addProvider(
                event.includeServer(),
                new DamageTypeProvider(
                        event.getGenerator().getPackOutput(),
                        event.getLookupProvider()
                )
        );

        generator.addProvider(event.includeServer(), LootTables.crate(packOutput,lookupProvider));

        generator.addProvider(event.includeServer(),new RecipeProvider(packOutput,lookupProvider));

        generator.addProvider(event.includeServer(),new AdvancementsProvider(packOutput,lookupProvider,existingFileHelper));


        generator.addProvider(event.includeServer(),
                new GrobalLootModifireProvider(packOutput,lookupProvider));
    }
}
