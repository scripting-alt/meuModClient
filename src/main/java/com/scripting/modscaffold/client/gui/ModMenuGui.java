package com.scripting.modscaffold.client.gui;

import com.scripting.modscaffold.client.config.ModConfig;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;

public class ModMenuGui extends GuiScreen {
    private GuiButton toggleScaffoldBtn;
    private GuiButton increaseRangeBtn;
    private GuiButton decreaseRangeBtn;
    private GuiButton toggleParticlesBtn;
    private GuiButton toggleSoundBtn;
    private GuiButton saveBtn;

    @Override
    public void initGui() {
        this.buttonList.clear();
        
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        toggleScaffoldBtn = new GuiButton(1, centerX - 100, centerY - 80, 200, 20, 
            "Scaffold: " + (ModConfig.scaffoldEnabled ? "§aON" : "§cOFF"));
        this.buttonList.add(toggleScaffoldBtn);

        decreaseRangeBtn = new GuiButton(2, centerX - 100, centerY - 50, 95, 20, "- Alcance");
        this.buttonList.add(decreaseRangeBtn);

        increaseRangeBtn = new GuiButton(3, centerX + 5, centerY - 50, 95, 20, "+ Alcance");
        this.buttonList.add(increaseRangeBtn);

        toggleParticlesBtn = new GuiButton(4, centerX - 100, centerY - 20, 200, 20,
            "Partículas: " + (ModConfig.particlesEnabled ? "§aON" : "§cOFF"));
        this.buttonList.add(toggleParticlesBtn);

        toggleSoundBtn = new GuiButton(5, centerX - 100, centerY + 10, 200, 20,
            "Som: " + (ModConfig.soundEnabled ? "§aON" : "§cOFF"));
        this.buttonList.add(toggleSoundBtn);

        saveBtn = new GuiButton(6, centerX - 100, centerY + 50, 200, 20, "§aSalvar e Fechar");
        this.buttonList.add(saveBtn);
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 1) {
            ModConfig.scaffoldEnabled = !ModConfig.scaffoldEnabled;
            toggleScaffoldBtn.displayString = "Scaffold: " + (ModConfig.scaffoldEnabled ? "§aON" : "§cOFF");
        } else if (button.id == 2) {
            if (ModConfig.scaffoldRange > 1) {
                ModConfig.scaffoldRange--;
            }
        } else if (button.id == 3) {
            if (ModConfig.scaffoldRange < 20) {
                ModConfig.scaffoldRange++;
            }
        } else if (button.id == 4) {
            ModConfig.particlesEnabled = !ModConfig.particlesEnabled;
            toggleParticlesBtn.displayString = "Partículas: " + (ModConfig.particlesEnabled ? "§aON" : "§cOFF");
        } else if (button.id == 5) {
            ModConfig.soundEnabled = !ModConfig.soundEnabled;
            toggleSoundBtn.displayString = "Som: " + (ModConfig.soundEnabled ? "§aON" : "§cOFF");
        } else if (button.id == 6) {
            ModConfig.saveConfig();
            this.mc.displayGuiScreen(null);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        this.drawCenteredString(this.fontRenderer, "§6§lMod Scaffold", centerX, centerY - 120, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, "Alcance: " + ModConfig.scaffoldRange + " blocos", centerX, centerY - 35, 0xAAAAAA);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }
}