package net.thedudemc.pendantoflife.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thedudemc.pendantoflife.PendantOfLife;
import net.thedudemc.pendantoflife.item.EverlastingPendant;
import net.thedudemc.pendantoflife.item.EverlastingPendantBauble;
import net.thedudemc.pendantoflife.item.Pendant;
import net.thedudemc.pendantoflife.item.PendantBauble;
import net.thedudemc.pendantoflife.util.compat.BaublesCompat;

public class InventoryHandler {

	public static Map<UUID, InventoryPlayer> keepMap = new HashMap<>();
	public static Map<UUID, Integer> xpMap = new HashMap<>();
	public static Map<UUID, NonNullList<ItemStack>> keepBaublesMap = new HashMap<>();

	public static void handlePendant(EntityPlayer player) {
		if (!player.world.getGameRules().getBoolean("keepInventory")) {
			if (getPendant(player)) {
				InventoryPlayer inv = new InventoryPlayer(null);
				inv.copyInventory(player.inventory);
				int exp = player.experienceTotal;
				keepMap.put(player.getUniqueID(), inv);
				xpMap.put(player.getUniqueID(), exp);
				if (PendantOfLife.BAUBLE) {
					NonNullList<ItemStack> items = BaublesCompat.keepBaubles(player);
					keepBaublesMap.put(player.getUniqueID(), items);
				}
				player.inventory.clear();
				player.experienceTotal = 0;
			}
		}
	}

	public static boolean getPendant(EntityPlayer player) {
		if (PendantOfLife.BAUBLE) {
			if (BaublesCompat.getBauble(player, true)) {
				return true;
			}
			for (ItemStack stack : player.inventory.mainInventory) {
				if (stack.getItem() instanceof EverlastingPendantBauble) {
					return true;
				}
			}
			for (ItemStack stack : player.inventory.offHandInventory) {
				if (stack.getItem() instanceof EverlastingPendantBauble) {
					return true;
				}
			}
			if (BaublesCompat.getBauble(player, false)) {
				return true;
			}
			for (ItemStack stack : player.inventory.mainInventory) {
				if (stack.getItem() instanceof PendantBauble) {
					stack.shrink(1);
					return true;
				}
			}
			for (ItemStack stack : player.inventory.offHandInventory) {
				if (stack.getItem() instanceof PendantBauble) {
					stack.shrink(1);
					return true;
				}
			}

		} else {
			for (ItemStack stack : player.inventory.mainInventory) {
				if (stack.getItem() instanceof EverlastingPendant) {
					return true;
				}
			}
			for (ItemStack stack : player.inventory.offHandInventory) {
				if (stack.getItem() instanceof EverlastingPendant) {
					return true;
				}
			}
			for (ItemStack stack : player.inventory.mainInventory) {
				if (stack.getItem() instanceof Pendant) {
					stack.shrink(1);
					return true;
				}
			}
			for (ItemStack stack : player.inventory.offHandInventory) {
				if (stack.getItem() instanceof Pendant) {
					stack.shrink(1);
					return true;
				}
			}
		}
		return false;
	}
}
