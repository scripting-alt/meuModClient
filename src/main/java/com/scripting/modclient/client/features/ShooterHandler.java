package com.scripting.modclient.client.features;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ShooterHandler {
    private static Minecraft mc = Minecraft.getMinecraft();
    private static long lastShot = 0;
    private static final long SHOT_DELAY = 100;

    public static void handleShooter() {
        EntityPlayer player = mc.player;
        if (player == null) return;

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastShot < SHOT_DELAY) {
            return;
        }

        if (mc.player.inventory.getCurrentItem() != null && mc.player.isHandActive()) {
            mc.playerController.clickMouse();
            lastShot = currentTime;
        }
    }
}