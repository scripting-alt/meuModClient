package com.scripting.modclient.client.events;

import com.scripting.modclient.client.config.ModConfig;
import com.scripting.modclient.client.gui.ModMenuGui;
import com.scripting.modclient.client.scaffold.ScaffoldManager;
import com.scripting.modclient.client.features.ESPRenderer;
import com.scripting.modclient.client.features.NoFallHandler;
import com.scripting.modclient.client.features.SpeedHandler;
import com.scripting.modclient.client.features.NightvisionHandler;
import com.scripting.modclient.client.features.FlyHandler;
import com.scripting.modclient.client.features.ShooterHandler;
import com.scripting.modclient.client.features.AntiKnockbackHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

@Mod.EventBusSubscriber
public class ClientEventHandler {
    private static Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public static void onMouseClick(MouseEvent event) {
        // RIGHT-SHIFT (tecla direita Shift)
        if (event.getButton() == 1 && mc.player != null) { // Clique direito
            if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) && event.isButtonstate()) {
                mc.displayGuiScreen(new ModMenuGui());
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && mc.player != null && mc.world != null) {
            // Scaffold
            if (ModConfig.SCAFFOLD_ENABLED) {
                ScaffoldManager.updateScaffold();
            }

            // Speed
            if (ModConfig.SPEED_ENABLED) {
                SpeedHandler.handleSpeed();
            }

            // Nightvision
            if (ModConfig.NIGHTVISION_ENABLED) {
                NightvisionHandler.handleNightvision();
            }

            // Fly
            if (ModConfig.FLY_ENABLED) {
                FlyHandler.handleFly();
            }

            // Shooter
            if (ModConfig.SHOOTER_ENABLED) {
                ShooterHandler.handleShooter();
            }
        }
    }

    @SubscribeEvent
    public static void onRenderWorldLast(RenderWorldLastEvent event) {
        // ESP
        if (ModConfig.ESP_ENABLED && mc.player != null && mc.world != null) {
            ESPRenderer.render(event.getPartialTicks());
        }
    }

    @SubscribeEvent
    public static void onLivingAttack(net.minecraftforge.fml.common.eventhandler.SubscribeEvent event) {
        // AntiKnockback
        if (ModConfig.ANTIKNOCKBACK_ENABLED && mc.player != null) {
            AntiKnockbackHandler.handleAntiKnockback();
        }
    }
}