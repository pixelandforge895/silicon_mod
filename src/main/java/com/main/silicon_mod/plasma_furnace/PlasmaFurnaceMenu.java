package com.main.silicon_mod.plasma_furnace;


import com.main.silicon_mod.registry.ModBlocks;
import com.main.silicon_mod.registry.ModMenus;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class PlasmaFurnaceMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;

    private void addPlayerInventory(Inventory playerInventory) {

        // メインインベントリ（3行）
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory,
                        j + i * 9 + 9,
                        8 + j * 18,
                        84 + i * 18));
            }
        }

        // ホットバー
        for (int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventory,
                    k,
                    8 + k * 18,
                    142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();

            int containerSize = 3; // 自分のスロット数

            if (index < containerSize) {
                // ブロック → プレイヤー
                if (!this.moveItemStackTo(stack, containerSize, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // プレイヤー → ブロック
                if (!this.moveItemStackTo(stack, 0, containerSize, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public PlasmaFurnaceMenu(int id, Inventory inv, PlasmaFurnaceBlockEntity blockEntity) {
        super(ModMenus.PLASMA_FURNACE.get(), id);

        this.access = ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos());

        // スロット例
        this.addSlot(new SlotItemHandler(blockEntity.inventory, 0, 56, 17));
        this.addSlot(new SlotItemHandler(blockEntity.inventory, 1, 56, 53));
        this.addSlot(new SlotItemHandler(blockEntity.inventory, 2, 116, 35));

        // プレイヤーインベントリ
        addPlayerInventory(inv);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(access, player, ModBlocks.PLASMA_FURNACE.get());
    }
}