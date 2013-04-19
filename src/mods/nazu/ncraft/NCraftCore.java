package mods.nazu.ncraft;

import mods.nazu.ncraft.world.PlaceholderOre;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
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
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="ncraft", name="ncraft", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class NCraftCore
{
	@Instance
	public static NCraftCore instance;
	
	@SidedProxy(clientSide="mods.nazu.ncraft.client.ClientProxy", serverSide="mods.nazu.ncraft.CommonProxy")
	public static CommonProxy proxy;
	
	public static final Block placeholderOre = new PlaceholderOre(501);
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		
	}
	
	@Init
	public void load(FMLInitializationEvent event)
	{
		LanguageRegistry.addName(placeholderOre, "Placeholder Ore");
		MinecraftForge.setBlockHarvestLevel(placeholderOre, "pickaxe", 3);
		GameRegistry.registerBlock(placeholderOre, "placeholderOre");
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
