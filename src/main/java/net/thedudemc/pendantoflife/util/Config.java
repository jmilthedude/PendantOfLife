package net.thedudemc.pendantoflife.util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static Configuration config;
	public static boolean lootEnabled = true;
	public static boolean recipeEnabled = false;
	
	public static void init(File file) {
		
		config = new Configuration(new File("config/Pendant of Life.cfg"));
		config.load();

		lootEnabled = config.getBoolean("enable_loot_spawns", "Loot", lootEnabled, "When true, the Pendant of Life to spawn in chests generated in the world.");
		recipeEnabled = config.getBoolean("enable_everlasting_recipe", "Recipe", recipeEnabled, "Set this to true to enable the Everlasting Pendant of Life, which can be crafted with a dragon egg surrounded by 8 pendants..");

		config.save();
	}
	


}
