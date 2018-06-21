package net.thedudemc.pendantoflife.util.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import net.thedudemc.pendantoflife.init.BaubleItems;
import net.thedudemc.pendantoflife.init.ModItems;
import net.thedudemc.pendantoflife.util.BaublesCompat;
import net.thedudemc.pendantoflife.util.Config;

@EventBusSubscriber
public class EventHandler {

	private static Map<UUID, InventoryPlayer> keepMap = new HashMap<>();
	private static Map<UUID, Integer> xpMap = new HashMap<>();
	private static Map<UUID, NonNullList<ItemStack>> keepBaublesMap = new HashMap<>();

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onLootTableLoad(LootTableLoadEvent event) {
		if (Config.lootEnabled == true) {
			if (event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON)) {
				final LootPool pool2 = event.getTable().getPool("pool2");
				if (pool2 != null) {
					if (Loader.isModLoaded("baubles")) {
						pool2.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						pool2.addEntry(new LootEntryItem(ModItems.PENDANT, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
			if (event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT)) {
				final LootPool pool2 = event.getTable().getPool("pool2");
				if (pool2 != null) {
					if (Loader.isModLoaded("baubles")) {
						pool2.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						pool2.addEntry(new LootEntryItem(ModItems.PENDANT, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
			if (event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID)) {
				final LootPool pool1 = event.getTable().getPool("pool1");
				if (pool1 != null) {
					if (Loader.isModLoaded("baubles")) {
						pool1.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						pool1.addEntry(new LootEntryItem(ModItems.PENDANT, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
			if (event.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE)) {
				final LootPool main = event.getTable().getPool("main");
				if (main != null) {
					if (Loader.isModLoaded("baubles")) {
						main.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						main.addEntry(new LootEntryItem(ModItems.PENDANT, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
			if (event.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY)) {
				final LootPool main = event.getTable().getPool("main");
				if (main != null) {
					if (Loader.isModLoaded("baubles")) {
						main.addEntry(new LootEntryItem(BaubleItems.PENDANT_BAUBLE, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					} else {
						main.addEntry(new LootEntryItem(ModItems.PENDANT, 10, 0, new LootFunction[0], new LootCondition[0], "jmilpol:pendant"));
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		ResourceLocation recipe = new ResourceLocation("jmilpol:pendant_recipe");
		IForgeRegistryModifiable<IRecipe> modRegistry = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();
		if(Config.recipeEnabled==false) {
			modRegistry.remove(recipe);
			System.out.println("***Everlasting Pendant Disabled***");
		} else {
		System.out.println("***Everlasting Pendant Enabled***");
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onDeath(LivingDeathEvent event) {
		EntityLivingBase living = event.getEntityLiving();
		pendantoflife(living);
		everlastingPendant(living);

	}

	@SubscribeEvent
	public static void XPDrop(LivingExperienceDropEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		UUID playerUUID = entity.getUniqueID();
		Integer xp = xpMap.remove(playerUUID);
		if (entity instanceof EntityPlayer) {
			if (xp != null) {
				event.setCanceled(true);
				xpMap.put(playerUUID, xp);
			} else {
			}
		} else {
		}
	}

	private static void pendantoflife(EntityLivingBase living) {

		// If the entity dying is a player and keep inventory is false...
		if (living instanceof EntityPlayer && !living.world.getGameRules().getBoolean("keepInventory")) {

			// Convert EntityBaseLiving living into an instance of EntityPlayer named player
			EntityPlayer player = (EntityPlayer) living;

			// Sets true or false depending if a pendant was consumed in the inventory..
			boolean hasPendant = false;

			if (consumeInventoryItem(player, s -> s.getItem() == ModItems.PENDANT, 1) == true) {
				hasPendant = true;
			} else if (Loader.isModLoaded("baubles")) {
				if (consumeInventoryItem(player, s -> s.getItem() == BaubleItems.PENDANT_BAUBLE, 1) == true) {
					hasPendant = true;
				} else if (BaublesCompat.consumeBaubleItem(player, s -> s.getItem() == BaubleItems.PENDANT_BAUBLE, 1) == true) {
					hasPendant = true;
				}

			} else {
			}

			// if the above boolean is true..
			if (hasPendant) {

				// Create an instance of InventoryPlayer object named keepInventory
				InventoryPlayer keepInventory = new InventoryPlayer(null);
				// Create an instance of UUID called playerUUID based on the dying player's
				// UUID.
				UUID playerUUID = player.getUniqueID();

				// call the keepAllArmor method, passing player that is dying and the inventory
				// object.
				keepAllArmor(player, keepInventory);
				keepOffHand(player, keepInventory);
				int saveXP = player.experienceTotal;
				Integer xpToMap = new Integer(saveXP);

				for (int i = 0; i < player.inventory.mainInventory.size(); i++) {
					keepInventory.mainInventory.set(i, player.inventory.mainInventory.get(i).copy());
					player.inventory.mainInventory.set(i, ItemStack.EMPTY);
				}

				keepMap.put(playerUUID, keepInventory);
				xpMap.put(playerUUID, xpToMap);

				if (Loader.isModLoaded("baubles")) {
					NonNullList<ItemStack> items = NonNullList.withSize(BaublesCompat.getSlotAmount(player), ItemStack.EMPTY);
					BaublesCompat.keepBaubles(player, items);

					keepBaublesMap.put(playerUUID, items);

				}

			}
		}
	}
	
	private static void everlastingPendant(EntityLivingBase living) {

		// If the entity dying is a player and keep inventory is false...
		if (living instanceof EntityPlayer && !living.world.getGameRules().getBoolean("keepInventory")) {

			// Convert EntityBaseLiving living into an instance of EntityPlayer named player
			EntityPlayer player = (EntityPlayer) living;

			// Sets true or false depending if a pendant was consumed in the inventory..
			boolean hasPendant = false;

			if (findEverlastingPendant(player, s -> s.getItem() == ModItems.EVERLASTING_PENDANT, 1) == true) {
				hasPendant = true;
			} else if (Loader.isModLoaded("baubles")) {
				if (findEverlastingPendant(player, s -> s.getItem() == BaubleItems.EVERLASTING_PENDANT_BAUBLE, 1) == true) {
					hasPendant = true;
				} else if (BaublesCompat.findBaubleItem(player, s -> s.getItem() == BaubleItems.EVERLASTING_PENDANT_BAUBLE, 1) == true) {
					hasPendant = true;
				}

			} else {
			}

			// if the above boolean is true..
			if (hasPendant) {

				// Create an instance of InventoryPlayer object named keepInventory
				InventoryPlayer keepInventory = new InventoryPlayer(null);
				// Create an instance of UUID called playerUUID based on the dying player's
				// UUID.
				UUID playerUUID = player.getUniqueID();

				// call the keepAllArmor method, passing player that is dying and the inventory
				// object.
				keepAllArmor(player, keepInventory);
				keepOffHand(player, keepInventory);
				int saveXP = player.experienceTotal;
				Integer xpToMap = new Integer(saveXP);

				for (int i = 0; i < player.inventory.mainInventory.size(); i++) {
					keepInventory.mainInventory.set(i, player.inventory.mainInventory.get(i).copy());
					player.inventory.mainInventory.set(i, ItemStack.EMPTY);
				}

				keepMap.put(playerUUID, keepInventory);
				xpMap.put(playerUUID, xpToMap);

				if (Loader.isModLoaded("baubles")) {
					NonNullList<ItemStack> items = NonNullList.withSize(BaublesCompat.getSlotAmount(player), ItemStack.EMPTY);
					BaublesCompat.keepBaubles(player, items);

					keepBaublesMap.put(playerUUID, items);

				}

			}
		}
	}

	private static void keepAllArmor(EntityPlayer player, InventoryPlayer keepInventory) {
		for (int i = 0; i < player.inventory.armorInventory.size(); i++) {
			keepInventory.armorInventory.set(i, player.inventory.armorInventory.get(i).copy());
			player.inventory.armorInventory.set(i, ItemStack.EMPTY);
		}
	}

	private static void keepOffHand(EntityPlayer player, InventoryPlayer keepInventory) {
		for (int i = 0; i < player.inventory.offHandInventory.size(); i++) {
			keepInventory.offHandInventory.set(i, player.inventory.offHandInventory.get(i).copy());
			player.inventory.offHandInventory.set(i, ItemStack.EMPTY);
		}
	}

	public static boolean consumeInventoryItem(EntityLivingBase living, Predicate<ItemStack> matcher, int count) {
		boolean consumedSome = false;
		IItemHandler inv = living.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < inv.getSlots() && count > 0; i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if (matcher.test(stack)) {
				int consume = Math.min(count, stack.getCount());
				stack.shrink(consume);
				count -= consume;
				consumedSome = true;
			}

		}

		return consumedSome;
	}
	
	public static boolean findEverlastingPendant(EntityLivingBase living, Predicate<ItemStack> matcher, int count) {
		boolean consumedSome = false;
		IItemHandler inv = living.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

		for (int i = 0; i < inv.getSlots() && count > 0; i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if (matcher.test(stack)) {
				consumedSome = true;
			}

		}

		return consumedSome;
	}

	@SubscribeEvent
	public static void onPlayerRespawn(PlayerRespawnEvent event) {
		EntityPlayer player = event.player;
		UUID playerUUID = player.getUniqueID();
		InventoryPlayer keepInventory = keepMap.remove(playerUUID);

		if (keepInventory != null) {

			Integer xpFromMap = xpMap.remove(playerUUID);
			int xpTotal = (Integer) xpFromMap;
			player.addExperience(xpTotal);

			NonNullList<ItemStack> displaced = NonNullList.create();
			for (int i = 0; i < player.inventory.armorInventory.size(); i++) {
				ItemStack kept = keepInventory.armorInventory.get(i);
				if (!kept.isEmpty()) {
					ItemStack existing = player.inventory.armorInventory.set(i, kept);
					if (!existing.isEmpty()) {
						displaced.add(existing);
					}
				}
			}

			for (int i = 0; i < player.inventory.offHandInventory.size(); i++) {
				ItemStack kept = keepInventory.offHandInventory.get(i);
				if (!kept.isEmpty()) {
					ItemStack existing = player.inventory.offHandInventory.set(i, kept);
					if (!existing.isEmpty()) {
						displaced.add(existing);
					}
				}
			}
			for (int i = 0; i < player.inventory.mainInventory.size(); i++) {
				ItemStack kept = keepInventory.mainInventory.get(i);
				if (!kept.isEmpty()) {
					ItemStack existing = player.inventory.mainInventory.set(i, kept);
					if (!existing.isEmpty()) {
						displaced.add(existing);
					}
				}
			}
			for (ItemStack extra : displaced) {
				ItemHandlerHelper.giveItemToPlayer(player, extra);
			}
		}

		if (Loader.isModLoaded("baubles")) {
			NonNullList<ItemStack> baubles = keepBaublesMap.remove(player.getUniqueID());
			if (baubles != null) {
				BaublesCompat.returnBaubles(player, baubles);
			}
		}

	}

}
