package com.scripting.modclient.client.features;

import com.scripting.modclient.client.config.ModConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class SpeedHandler {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void handleSpeed() {
        EntityPlayer player = mc.player;
        if (player == null) return;

        if (player.moveForward > 0 || player.moveStrafing > 0) {
            player.motionX *= ModConfig.SPEED_MULTIPLIER;
            player.motionZ *= ModConfig.SPEED_MULTIPLIER;
        }
    }
}