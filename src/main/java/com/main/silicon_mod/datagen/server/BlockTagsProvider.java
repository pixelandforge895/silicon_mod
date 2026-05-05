package com.main.silicon_mod.datagen.server;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagsProvider extends net.minecraftforge.common.data.BlockTagsProvider {

    public BlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, SiliconMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.QUARTZ_GLASS.get(),
                        ModBlocks.PLASMA_FURNACE.get()
                );

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(
                        ModBlocks.QUARTZ_GLASS.get(),
                        ModBlocks.PLASMA_FURNACE.get()
                );
    }
}
