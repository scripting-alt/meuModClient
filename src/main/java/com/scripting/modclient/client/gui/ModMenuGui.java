package com.scripting.modclient.client.gui;

import com.scripting.modclient.client.config.ModConfig;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class ModMenuGui extends GuiScreen {
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 20;
    private static final int SPACING = 5;

    @Override
    public void initGui() {
        int centerX = this.width / 2;
        int startY = 50;

        this.buttonList.clear();

        // Botão para ativar/desativar Scaffold
        this.buttonList.add(new GuiButton(0, centerX - BUTTON_WIDTH / 2, startY, BUTTON_WIDTH, BUTTON_HEIGHT,
                "Scaffold: " + (ModConfig.SCAFFOLD_ENABLED ? "§aON§r" : "§cOFF§r")));

        // Botão de alcance
        this.buttonList.add(new GuiButton(1, centerX - BUTTON_WIDTH / 2, startY + BUTTON_HEIGHT + SPACING,
                BUTTON_WIDTH / 2 - SPACING / 2, BUTTON_HEIGHT,
                "Alcance: " + ModConfig.SCAFFOLD_RANGE));

        // Botões + e -
        this.buttonList.add(new GuiButton(2, centerX + BUTTON_WIDTH / 4 - SPACING / 2, startY + BUTTON_HEIGHT + SPACING,
                BUTTON_WIDTH / 4 - SPACING / 2, BUTTON_HEIGHT, "+"));
        this.buttonList.add(new GuiButton(3, centerX + BUTTON_WIDTH / 2 - SPACING / 2, startY + BUTTON_HEIGHT + SPACING,
                BUTTON_WIDTH / 4 - SPACING / 2, BUTTON_HEIGHT, "-"));

        // Partículas
        this.buttonList.add(new GuiButton(4, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 2,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                "Partículas: " + (ModConfig.PARTICLES_ENABLED ? "§aON§r" : "§cOFF§r")));

        // Som
        this.buttonList.add(new GuiButton(5, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 3,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                "Som: " + (ModConfig.SOUND_ENABLED ? "§aON§r" : "§cOFF§r")));

        // Salvar e Fechar
        this.buttonList.add(new GuiButton(6, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 4 + 20,
                BUTTON_WIDTH, BUTTON_HEIGHT, "§aSalvar e Fechar"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            ModConfig.SCAFFOLD_ENABLED = !ModConfig.SCAFFOLD_ENABLED;
            this.initGui();
        } else if (button.id == 2) {
            if (ModConfig.SCAFFOLD_RANGE < 20) {
                ModConfig.SCAFFOLD_RANGE++;
            }
            this.initGui();
        } else if (button.id == 3) {
            if (ModConfig.SCAFFOLD_RANGE > 1) {
                ModConfig.SCAFFOLD_RANGE--;
            }
            this.initGui();
        } else if (button.id == 4) {
            ModConfig.PARTICLES_ENABLED = !ModConfig.PARTICLES_ENABLED;
            this.initGui();
        } else if (button.id == 5) {
            ModConfig.SOUND_ENABLED = !ModConfig.SOUND_ENABLED;
            this.initGui();
        } else if (button.id == 6) {
            ModConfig.syncConfig();
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "§6MOD CLIENT MENU§r", this.width / 2, 20, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}