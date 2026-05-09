package com.scripting.modclient.client.config;

import net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ModConfig {
    public static Configuration config;

    public static boolean SCAFFOLD_ENABLED = true;
    public static int SCAFFOLD_RANGE = 5;
    public static boolean PARTICLES_ENABLED = true;
    public static boolean SOUND_ENABLED = true;

    public static void loadConfig(File configDir) {
        File configFile = new File(configDir, "meumodclient.cfg");
        config = new Configuration(configFile);
        syncConfig();
    }

    public static void syncConfig() {
        SCAFFOLD_ENABLED = config.getBoolean("scaffoldEnabled", "general", true, "Ativa ou desativa o sistema de scaffold");
        SCAFFOLD_RANGE = config.getInt("scaffoldRange", "general", 5, 1, 20, "Alcance do scaffold (em blocos)");
        PARTICLES_ENABLED = config.getBoolean("particlesEnabled", "visual", true, "Mostra partículas ao colocar blocos");
        SOUND_ENABLED = config.getBoolean("soundEnabled", "audio", true, "Toca sons ao colocar blocos");

        if (config.hasChanged()) {
            config.save();
        }
    }
}