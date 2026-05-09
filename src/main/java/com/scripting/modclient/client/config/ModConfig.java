package com.scripting.modclient.client.config;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ModConfig {
    public static Configuration config;

    // Scaffold
    public static boolean SCAFFOLD_ENABLED = true;
    public static int SCAFFOLD_RANGE = 5;
    public static boolean PARTICLES_ENABLED = true;
    public static boolean SOUND_ENABLED = true;

    // ESP
    public static boolean ESP_ENABLED = false;

    // NoFall
    public static boolean NOFALL_ENABLED = false;

    // Speed
    public static boolean SPEED_ENABLED = false;
    public static float SPEED_MULTIPLIER = 1.5f;

    // Nightvision
    public static boolean NIGHTVISION_ENABLED = false;

    // Fly
    public static boolean FLY_ENABLED = false;
    public static float FLY_SPEED = 0.1f;

    // Shooter
    public static boolean SHOOTER_ENABLED = false;

    // AntiKnockback
    public static boolean ANTIKNOCKBACK_ENABLED = false;

    public static void loadConfig(File configDir) {
        File configFile = new File(configDir, "meumodclient.cfg");
        config = new Configuration(configFile);
        syncConfig();
    }

    public static void syncConfig() {
        // Scaffold
        SCAFFOLD_ENABLED = config.getBoolean("scaffoldEnabled", "scaffold", true, "Ativa ou desativa o sistema de scaffold");
        SCAFFOLD_RANGE = config.getInt("scaffoldRange", "scaffold", 5, 1, 20, "Alcance do scaffold (em blocos)");
        PARTICLES_ENABLED = config.getBoolean("particlesEnabled", "scaffold", true, "Mostra partículas ao colocar blocos");
        SOUND_ENABLED = config.getBoolean("soundEnabled", "scaffold", true, "Toca sons ao colocar blocos");

        // ESP
        ESP_ENABLED = config.getBoolean("espEnabled", "esp", false, "Mostra inimigos em vermelho");

        // NoFall
        NOFALL_ENABLED = config.getBoolean("nofallEnabled", "nofall", false, "Remove damage de queda");

        // Speed
        SPEED_ENABLED = config.getBoolean("speedEnabled", "speed", false, "Aumenta velocidade de movimento");
        SPEED_MULTIPLIER = config.getFloat("speedMultiplier", "speed", 1.5f, 1.0f, 5.0f, "Multiplicador de velocidade");

        // Nightvision
        NIGHTVISION_ENABLED = config.getBoolean("nightvisionEnabled", "nightvision", false, "Ativa visão noturna");

        // Fly
        FLY_ENABLED = config.getBoolean("flyEnabled", "fly", false, "Ativa voo (apenas cliente)");
        FLY_SPEED = config.getFloat("flySpeed", "fly", 0.1f, 0.01f, 1.0f, "Velocidade de voo");

        // Shooter
        SHOOTER_ENABLED = config.getBoolean("shooterEnabled", "shooter", false, "Ativa atirador automático");

        // AntiKnockback
        ANTIKNOCKBACK_ENABLED = config.getBoolean("antiKnockbackEnabled", "antiknockback", false, "Reduz knockback recebido");

        if (config.hasChanged()) {
            config.save();
        }
    }
}