package com.scripting.modclient;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
    modid = MeuModClient.MODID,
    name = MeuModClient.NAME,
    version = MeuModClient.VERSION,
    clientSideOnly = true
)
public class MeuModClient {
    public static final String MODID = "meumodclient";
    public static final String NAME = "Meu Mod Client";
    public static final String VERSION = "1.0.0";

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("[" + NAME + "] Mod iniciado com sucesso!");
    }
}