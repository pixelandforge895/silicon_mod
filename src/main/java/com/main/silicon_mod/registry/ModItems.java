package com.main.silicon_mod.registry;

import com.main.silicon_mod.SiliconMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SiliconMod.MOD_ID);

    public static final RegistryObject<Item> SILICON_DIOXIDE_BUCKET = ModItems.ITEMS.register("silicon_dioxide_bucket",
                    () -> new BucketItem(ModFluids.SOURCE,
                            new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> QUARTZ_GLASS =
            ITEMS.register("quartz_glass",
                    () -> new BlockItem(
                            ModBlocks.QUARTZ_GLASS.get(),
                            new Item.Properties()
                    ));

    public static final RegistryObject<Item> PLASMA_FURNACE =
            ITEMS.register("plasma_furnace",
                    () -> new BlockItem(
                            ModBlocks.PLASMA_FURNACE.get(),
                            new Item.Properties()
                    ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
