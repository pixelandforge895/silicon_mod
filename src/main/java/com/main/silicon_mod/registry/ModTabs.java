package com.main.silicon_mod.registry;

import com.main.silicon_mod.SiliconMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SiliconMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INTRO_TAB =
            TABS.register("silicon_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("creatives.silicon_tab"))
                    .icon(ModItems.SILICON_DIOXIDE_BUCKET.get()::getDefaultInstance)
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SILICON_DIOXIDE_BUCKET.get());
                    })
                    //.withTabsBefore(CreativeModeTabs.BUILDING_BLOCKS)ひとつ前のタブを指定
                    .withSearchBar()
                    .withLabelColor(new Color(0,2,116,55).getRGB())
                    .build());

    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
