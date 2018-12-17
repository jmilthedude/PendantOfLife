package net.thedudemc.pendantoflife;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedudemc.pendantoflife.config.Config;
import net.thedudemc.pendantoflife.util.compat.ThaumcraftCompat;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class PendantOfLife {

	public static final boolean BAUBLE = Loader.isModLoaded("baubles");

	@Instance
	public static PendantOfLife instance;

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		Config.init(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		if (Loader.isModLoaded("thaumcraft")) {
			ThaumcraftCompat.registerAspects();
		}
	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {

	}

}
