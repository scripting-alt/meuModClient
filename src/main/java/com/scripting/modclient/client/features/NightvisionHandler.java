package com.scripting.modclient.client.features;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class NightvisionHandler {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void handleNightvision() {
        EntityPlayer player = mc.player;
        if (player == null) return;

        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 9999, 0));
    }
}