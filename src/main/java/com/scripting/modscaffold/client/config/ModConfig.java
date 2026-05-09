package com.scripting.modscaffold.client.config;

import java.io.*;
import java.util.Properties;

public class ModConfig {
    private static final String CONFIG_FILE = "config/modscaffold.cfg";
    
    public static boolean scaffoldEnabled = true;
    public static int scaffoldRange = 5;
    public static boolean particlesEnabled = true;
    public static boolean soundEnabled = true;

    public static void loadConfig() {
        try {
            File configDir = new File("config");
            if (!configDir.exists()) {
                configDir.mkdirs();
            }

            File configFile = new File(CONFIG_FILE);
            Properties props = new Properties();

            if (configFile.exists()) {
                props.load(new FileInputStream(configFile));
                scaffoldEnabled = Boolean.parseBoolean(props.getProperty("scaffoldEnabled", "true"));
                scaffoldRange = Integer.parseInt(props.getProperty("scaffoldRange", "5"));
                particlesEnabled = Boolean.parseBoolean(props.getProperty("particlesEnabled", "true"));
                soundEnabled = Boolean.parseBoolean(props.getProperty("soundEnabled", "true"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveConfig() {
        try {
            File configDir = new File("config");
            if (!configDir.exists()) {
                configDir.mkdirs();
            }

            File configFile = new File(CONFIG_FILE);
            Properties props = new Properties();

            props.setProperty("scaffoldEnabled", String.valueOf(scaffoldEnabled));
            props.setProperty("scaffoldRange", String.valueOf(scaffoldRange));
            props.setProperty("particlesEnabled", String.valueOf(particlesEnabled));
            props.setProperty("soundEnabled", String.valueOf(soundEnabled));

            props.store(new FileOutputStream(configFile), "Configuracoes do Mod Scaffold");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}