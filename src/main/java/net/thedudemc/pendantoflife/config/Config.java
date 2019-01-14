package net.thedudemc.pendantoflife.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

	public static Configuration config;
	public static boolean lootEnabled = true;
	public static boolean everlastingRecipeEnabled = false;
	public static boolean pendantRecipeEnabled = false;
	public static int rarity = 10;

	public static void init(File file) {

		config = new Configuration(new File("config/Pendant of Life.cfg"));
		config.load();

		lootEnabled = config.getBoolean("enable_loot_spawns", "Loot", lootEnabled, "When true, the Pendant of Life to spawn in chests generated in the world.");
		everlastingRecipeEnabled = config.getBoolean("enable_everlasting_recipe", "Recipe", everlastingRecipeEnabled, "Set this to true to enable the Everlasting Pendant of Life, which can be crafted with a dragon egg surrounded by 8 pendants..");
		pendantRecipeEnabled = config.getBoolean("enable_pendant_recipe", "Recipe", pendantRecipeEnabled, "Set this to true to enable a recipe for the Pendant of Life.");
		rarity = config.getInt("pendant_rarity", "Rarity", 10, 1, 50, "Set the chance that the Pendant will spawn in chests! For reference, a Notch Apple is 2 by default and a saddle is 20.");
		config.save();
	}

}
