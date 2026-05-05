package com.main.silicon_mod.datagen.client;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {

    public BlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, SiliconMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(
                ModBlocks.QUARTZ_GLASS.get(),
                models().cubeAll("quartz_glass",
                                modLoc("block/quartz_glass"))
                        .renderType("translucent")
        );
        simpleBlockWithItem(
                ModBlocks.PLASMA_FURNACE.get(),
                models().cube(
                        "plasm_furnace",
                        modLoc("block/plasm_furnace/top"),
                        modLoc("block/plasm_furnace/top"),
                        modLoc("block/plasm_furnace/flont"),
                        modLoc("block/plasm_furnace/flont"),
                        modLoc("block/plasm_furnace/flont"),
                        modLoc("block/plasm_furnace/flont")
                )
        );
    }

    private void simpleBlockWithItem(RegistryObject<Block> block){
        simpleBlockWithItem(block.get(),cubeAll(block.get()));
    }
}
