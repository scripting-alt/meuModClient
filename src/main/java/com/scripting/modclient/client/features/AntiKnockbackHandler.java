package com.scripting.modclient.client.features;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class AntiKnockbackHandler {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void handleAntiKnockback() {
        EntityPlayer player = mc.player;
        if (player == null) return;

        player.velocityChanged = false;
    }
}