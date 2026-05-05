package com.main.silicon_mod.registry;

import com.main.silicon_mod.SiliconMod;
import com.main.silicon_mod.plasma_furnace.PlasmaFurnaceBlockEntity;
import com.main.silicon_mod.plasma_furnace.PlasmaFurnaceMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenus {

    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, SiliconMod.MOD_ID);

    public static final RegistryObject<MenuType<PlasmaFurnaceMenu>> PLASMA_FURNACE =
            MENUS.register("plasma_furnace",
                    () -> IForgeMenuType.create((id, inv, buf) -> {

                        BlockPos pos = buf.readBlockPos();
                        BlockEntity be = inv.player.level().getBlockEntity(pos);

                        return new PlasmaFurnaceMenu(
                                id,
                                inv,
                                (PlasmaFurnaceBlockEntity) be
                        );
                    }));

    public static void register(net.minecraftforge.eventbus.api.IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}