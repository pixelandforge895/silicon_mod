package com.main.silicon_mod.plasma_furnace;


import com.main.silicon_mod.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;

public class PlasmaFurnaceBlockEntity extends BlockEntity implements MenuProvider {

    final ItemStackHandler inventory = new ItemStackHandler(3);

    public PlasmaFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PLASMA_FURNACE.get(), pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Silicon Furnace");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new PlasmaFurnaceMenu(id, inv, this);
    }
}