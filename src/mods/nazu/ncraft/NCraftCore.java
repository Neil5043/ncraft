package mods.nazu.ncraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import mods.nazu.ncraft.config.Config;
import mods.nazu.ncraft.world.WorldGenerator;

/**
 * @author nazuraki
 * @since 2013.04.19
 */
@SuppressWarnings("UnusedDeclaration")
@Mod(modid="ncraft", name="ncraft", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class NCraftCore
{
    @Instance
    public static NCraftCore instance;

    @SidedProxy(clientSide="mods.nazu.ncraft.client.ClientProxy", serverSide="mods.nazu.ncraft.CommonProxy")
    public static CommonProxy proxy;

    @PreInit
    public void preInit(FMLPreInitializationEvent event)
    {
        Config config = new Config(event);
    }

    @Init
    public void load(FMLInitializationEvent event)
    {
        Config.registerNames();
        Config.registerBlocks();

        GameRegistry.registerWorldGenerator(new WorldGenerator());
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
