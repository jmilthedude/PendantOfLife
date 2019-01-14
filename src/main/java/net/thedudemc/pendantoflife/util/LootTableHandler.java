package net.thedudemc.pendantoflife.util;

import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thedudemc.pendantoflife.PendantOfLife;
import net.thedudemc.pendantoflife.Reference;
import net.thedudemc.pendantoflife.config.Config;
import net.thedudemc.pendantoflife.init.BaubleItems;
import net.thedudemc.pendantoflife.init.ModItems;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class LootTableHandler {

	private static int weight = Config.rarity;

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onLootTableLoad(LootTableLoadEvent event) {
		if (Config.lootEnabled == true) {
			if (event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON)) {
				final LootPool pool2 = event.getTable().getPool("pool2");
				if (pool2 != null) {
					if (PendantOfLife.BAUBLE) {
						pool2.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						pool2.addEntry(new LootEntryItem(ModItems.PENDANT, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
			if (event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
				final LootPool pool2 = event.getTable().getPool("pool2");
				if (pool2 != null) {
					if (PendantOfLife.BAUBLE) {
						pool2.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						pool2.addEntry(new LootEntryItem(ModItems.PENDANT, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
			if (event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID)) {
				final LootPool pool1 = event.getTable().getPool("pool1");
				if (pool1 != null) {
					if (PendantOfLife.BAUBLE) {
						pool1.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						pool1.addEntry(new LootEntryItem(ModItems.PENDANT, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
			if (event.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE)) {
				final LootPool main = event.getTable().getPool("main");
				if (main != null) {
					if (PendantOfLife.BAUBLE) {
						main.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						main.addEntry(new LootEntryItem(ModItems.PENDANT, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
			if (event.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY)) {
				final LootPool main = event.getTable().getPool("main");
				if (main != null) {
					if (PendantOfLife.BAUBLE) {
						main.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						main.addEntry(new LootEntryItem(ModItems.PENDANT, weight, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
		}
	}
}
