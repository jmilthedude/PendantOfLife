package net.thedudemc.pendantoflife;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedudemc.pendantoflife.proxy.CommonProxy;
import net.thedudemc.pendantoflife.util.Config;
import net.thedudemc.pendantoflife.util.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class PendantOfLife {

	@Instance
	public static PendantOfLife instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {

		Config.init(event.getSuggestedConfigurationFile());
		System.out.println("Pendant loot spawns:" + Config.lootEnabled);
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {

		System.out.println("Is Baubles Mod installed: " + Loader.isModLoaded("baubles"));

	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {

	}

}
