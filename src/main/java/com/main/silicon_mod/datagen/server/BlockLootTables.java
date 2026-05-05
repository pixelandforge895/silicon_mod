package com.main.silicon_mod.datagen.server;

import com.main.silicon_mod.registry.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {

    public BlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider); // ★これが正解
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.QUARTZ_GLASS.get());
        dropSelf(ModBlocks.PLASMA_FURNACE.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Set.of(
                ModBlocks.QUARTZ_GLASS.get(),
                ModBlocks.PLASMA_FURNACE.get()
        );
    }
}