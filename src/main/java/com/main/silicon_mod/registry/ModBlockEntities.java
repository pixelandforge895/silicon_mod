package com.main.silicon_mod.registry;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.plasma_furnace.PlasmaFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SiliconMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PlasmaFurnaceBlockEntity>> PLASMA_FURNACE =
            BLOCK_ENTITIES.register("plasma_furnace",
                    () -> BlockEntityType.Builder.of(
                            PlasmaFurnaceBlockEntity::new,
                            ModBlocks.PLASMA_FURNACE.get()
                    ).build(null));

    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}