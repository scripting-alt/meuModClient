package com.scripting.modclient.client.gui;

import com.scripting.modclient.client.config.ModConfig;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class ModMenuGui extends GuiScreen {
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 20;
    private static final int SPACING = 3;

    private int currentPage = 0;
    private static final int BUTTONS_PER_PAGE = 6;

    @Override
    public void initGui() {
        int centerX = this.width / 2;
        int startY = 40;

        this.buttonList.clear();

        // Página 1: Scaffold e ESP
        if (currentPage == 0) {
            // Scaffold
            this.buttonList.add(new GuiButton(0, centerX - BUTTON_WIDTH / 2, startY, BUTTON_WIDTH, BUTTON_HEIGHT,
                    "Scaffold: " + (ModConfig.SCAFFOLD_ENABLED ? "§aON§r" : "§cOFF§r")));

            // Alcance
            this.buttonList.add(new GuiButton(1, centerX - BUTTON_WIDTH / 2, startY + BUTTON_HEIGHT + SPACING,
                    BUTTON_WIDTH / 3 - SPACING, BUTTON_HEIGHT,
                    "Range: " + ModConfig.SCAFFOLD_RANGE));
            this.buttonList.add(new GuiButton(2, centerX - BUTTON_WIDTH / 3, startY + BUTTON_HEIGHT + SPACING,
                    BUTTON_WIDTH / 3 - SPACING, BUTTON_HEIGHT, "+"));
            this.buttonList.add(new GuiButton(3, centerX + BUTTON_WIDTH / 6, startY + BUTTON_HEIGHT + SPACING,
                    BUTTON_WIDTH / 3 - SPACING, BUTTON_HEIGHT, "-"));

            // ESP
            this.buttonList.add(new GuiButton(4, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 2,
                    BUTTON_WIDTH, BUTTON_HEIGHT,
                    "ESP: " + (ModConfig.ESP_ENABLED ? "§aON§r" : "§cOFF§r")));

            // NoFall
            this.buttonList.add(new GuiButton(5, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 3,
                    BUTTON_WIDTH, BUTTON_HEIGHT,
                    "NoFall: " + (ModConfig.NOFALL_ENABLED ? "§aON§r" : "§cOFF§r")));

            // Próxima página
            this.buttonList.add(new GuiButton(100, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 5,
                    BUTTON_WIDTH, BUTTON_HEIGHT, "§6Página 2 →"));
        }
        // Página 2: Mais funções
        else if (currentPage == 1) {
            // Speed
            this.buttonList.add(new GuiButton(6, centerX - BUTTON_WIDTH / 2, startY, BUTTON_WIDTH, BUTTON_HEIGHT,
                    "Speed: " + (ModConfig.SPEED_ENABLED ? "§aON§r" : "§cOFF§r")));

            // Nightvision
            this.buttonList.add(new GuiButton(7, centerX - BUTTON_WIDTH / 2, startY + BUTTON_HEIGHT + SPACING,
                    BUTTON_WIDTH, BUTTON_HEIGHT,
                    "Nightvision: " + (ModConfig.NIGHTVISION_ENABLED ? "§aON§r" : "§cOFF§r")));

            // Fly
            this.buttonList.add(new GuiButton(8, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 2,
                    BUTTON_WIDTH, BUTTON_HEIGHT,
                    "Fly: " + (ModConfig.FLY_ENABLED ? "§aON§r" : "§cOFF§r")));

            // Shooter
            this.buttonList.add(new GuiButton(9, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 3,
                    BUTTON_WIDTH, BUTTON_HEIGHT,
                    "Auto Shooter: " + (ModConfig.SHOOTER_ENABLED ? "§aON§r" : "§cOFF§r")));

            // AntiKnockback
            this.buttonList.add(new GuiButton(10, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 4,
                    BUTTON_WIDTH, BUTTON_HEIGHT,
                    "AntiKnockback: " + (ModConfig.ANTIKNOCKBACK_ENABLED ? "§aON§r" : "§cOFF§r")));

            // Página anterior
            this.buttonList.add(new GuiButton(101, centerX - BUTTON_WIDTH / 2, startY + (BUTTON_HEIGHT + SPACING) * 5,
                    BUTTON_WIDTH, BUTTON_HEIGHT, "§6← Página 1"));
        }

        // Botão salvar
        this.buttonList.add(new GuiButton(200, centerX - BUTTON_WIDTH / 2, this.height - 40,
                BUTTON_WIDTH, BUTTON_HEIGHT, "§aSalvar"));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        // Scaffold
        if (button.id == 0) {
            ModConfig.SCAFFOLD_ENABLED = !ModConfig.SCAFFOLD_ENABLED;
        }
        if (button.id == 2) {
            if (ModConfig.SCAFFOLD_RANGE < 20) ModConfig.SCAFFOLD_RANGE++;
        }
        if (button.id == 3) {
            if (ModConfig.SCAFFOLD_RANGE > 1) ModConfig.SCAFFOLD_RANGE--;
        }

        // ESP
        if (button.id == 4) {
            ModConfig.ESP_ENABLED = !ModConfig.ESP_ENABLED;
        }

        // NoFall
        if (button.id == 5) {
            ModConfig.NOFALL_ENABLED = !ModConfig.NOFALL_ENABLED;
        }

        // Speed
        if (button.id == 6) {
            ModConfig.SPEED_ENABLED = !ModConfig.SPEED_ENABLED;
        }

        // Nightvision
        if (button.id == 7) {
            ModConfig.NIGHTVISION_ENABLED = !ModConfig.NIGHTVISION_ENABLED;
        }

        // Fly
        if (button.id == 8) {
            ModConfig.FLY_ENABLED = !ModConfig.FLY_ENABLED;
        }

        // Shooter
        if (button.id == 9) {
            ModConfig.SHOOTER_ENABLED = !ModConfig.SHOOTER_ENABLED;
        }

        // AntiKnockback
        if (button.id == 10) {
            ModConfig.ANTIKNOCKBACK_ENABLED = !ModConfig.ANTIKNOCKBACK_ENABLED;
        }

        // Navegação
        if (button.id == 100) {
            currentPage = 1;
            this.initGui();
        }
        if (button.id == 101) {
            currentPage = 0;
            this.initGui();
        }

        // Salvar
        if (button.id == 200) {
            ModConfig.syncConfig();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, "§6§lMEU MOD CLIENT§r", this.width / 2, 15, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "Página " + (currentPage + 1) + " de 2", this.width / 2, 25, 0xAAAAAA);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void onGuiClosed() {
        ModConfig.syncConfig();
        super.onGuiClosed();
    }
}