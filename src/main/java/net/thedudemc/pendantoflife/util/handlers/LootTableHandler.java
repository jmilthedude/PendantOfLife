package net.thedudemc.pendantoflife.util.handlers;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.thedudemc.pendantoflife.util.Reference;

public class LootTableHandler {

	public static ResourceLocation PENDANT_ABANDONED_MINESHAFT;
	public static ResourceLocation PENDANT_DESERT_PYRAMID;
	public static ResourceLocation PENDANT_JUNGLE_TEMPLE;
	public static ResourceLocation PENDANT_NETHER_BRIDGE;
	public static ResourceLocation PENDANT_SIMPLE_DUNGEON;
	public static ResourceLocation PENDANT_STRONGHOLD_CORRIDOR;
	public static ResourceLocation PENDANT_STRONGHOLD_CROSSING;
	public static ResourceLocation PENDANT_VILLAGE_BLACKSMITH;
	
	public static void registerLootTables() {
		PENDANT_ABANDONED_MINESHAFT = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "simple_dungeon"));
		PENDANT_DESERT_PYRAMID = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "simple_dungeon"));
		PENDANT_JUNGLE_TEMPLE = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "simple_dungeon"));
		PENDANT_NETHER_BRIDGE = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "simple_dungeon"));
		PENDANT_SIMPLE_DUNGEON = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "simple_dungeon"));
		PENDANT_STRONGHOLD_CORRIDOR = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "simple_dungeon"));
		PENDANT_STRONGHOLD_CROSSING = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "simple_dungeon"));
		PENDANT_VILLAGE_BLACKSMITH = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "simple_dungeon"));
	}

}
