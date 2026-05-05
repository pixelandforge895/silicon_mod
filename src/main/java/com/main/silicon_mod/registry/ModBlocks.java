package com.main.silicon_mod.registry;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.fluid.SiliconDioxideBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SiliconMod.MOD_ID);


    public static final RegistryObject<LiquidBlock> SILICON_DIOXIDE =
            ModBlocks.BLOCKS.register("silicon_dioxide_block",
                    () -> new SiliconDioxideBlock(ModFluids.SOURCE,
                            BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA)));

    public static final RegistryObject<Block> QUARTZ_GLASS =
            BLOCKS.register("quartz_glass",
                    () -> new Block(BlockBehaviour.Properties
                            .of()
                            .strength(0.3F)
                            .noOcclusion() //（透過）
                            .requiresCorrectToolForDrops()
                            .isValidSpawn((s, l, p, e) -> false)
                            .lightLevel(state -> 1)
                    ));

    public static final RegistryObject<Block> PLASMA_FURNACE =
            BLOCKS.register("plasma_furnace",
                    () -> new Block(BlockBehaviour.Properties
                            .of()
                            .strength(2.0F)
                            .requiresCorrectToolForDrops()
                            .isValidSpawn((s, l, p, e) -> false)
                            .lightLevel(state -> 10)
                    ));

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
