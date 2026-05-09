package com.scripting.modclient.client.features;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class NoFallHandler {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void handle() {
        EntityPlayer player = mc.player;
        if (player == null) return;
        
        player.fallDistance = 0;
    }
}