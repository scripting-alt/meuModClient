package com.scripting.modscaffold.client.events;

import com.scripting.modscaffold.client.config.ModConfig;
import com.scripting.modscaffold.client.gui.ModMenuGui;
import com.scripting.modscaffold.client.scaffold.ScaffoldManager;
import net.minecraftforge.fml.common.eventbus.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientEventHandler {
    private static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public static void onMouseClick(MouseEvent event) {
        if (event.getButton() == 1 && Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            if (mc.player != null && !mc.player.openContainer.canInteractWith(mc.player)) {
                event.setCanceled(true);
                mc.displayGuiScreen(new ModMenuGui());
            }
        }
    }

    @SubscribeEvent
    public static void onClientTick(net.minecraftforge.fml.common.eventbus.SubscribeEvent event) {
        // Este evento será adicionado em ClientProxy
    }
}