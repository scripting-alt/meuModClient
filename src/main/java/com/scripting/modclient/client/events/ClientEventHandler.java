package com.scripting.modclient.client.events;

import com.scripting.modclient.client.config.ModConfig;
import com.scripting.modclient.client.gui.ModMenuGui;
import com.scripting.modclient.client.scaffold.ScaffoldManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber
public class ClientEventHandler {
    private static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public static void onMouseClick(MouseEvent event) {
        if (event.getButton() == 1 && mc.player != null) { // Clique direito
            if (mc.player.isSneaking() && event.isButtonstate()) { // Shift pressionado
                mc.displayGuiScreen(new ModMenuGui());
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (ModConfig.SCAFFOLD_ENABLED && mc.player != null && mc.world != null) {
                ScaffoldManager.updateScaffold();
            }
        }
    }
}