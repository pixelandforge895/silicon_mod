package com.main.silicon_mod.plasma_furnace;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class PlasmaFurnaceScreen extends AbstractContainerScreen<PlasmaFurnaceMenu> {

    public PlasmaFurnaceScreen(PlasmaFurnaceMenu menu, Inventory inv, Component title) {
        super(menu, inv, title);
    }

    @Override
    protected void renderBg(GuiGraphics gui, float partialTick, int mouseX, int mouseY) {
        // テクスチャ描画
    }
}
