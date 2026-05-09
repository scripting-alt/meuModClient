package com.scripting.modclient.client.features;

import com.scripting.modclient.client.config.ModConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class FlyHandler {
    private static Minecraft mc = Minecraft.getMinecraft();
    private static boolean isFlying = false;

    public static void handleFly() {
        EntityPlayer player = mc.player;
        if (player == null) return;

        if (!isFlying) {
            isFlying = true;
            player.capabilities.isFlying = true;
        }

        if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
            player.motionY = ModConfig.FLY_SPEED;
        } else if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {
            player.motionY = -ModConfig.FLY_SPEED;
        } else {
            player.motionY = 0;
        }
    }

    public static void disableFly() {
        EntityPlayer player = mc.player;
        if (player != null) {
            player.capabilities.isFlying = false;
            isFlying = false;
        }
    }
}