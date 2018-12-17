package net.thedudemc.pendantoflife.util.compat;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.thedudemc.pendantoflife.item.EverlastingPendantBauble;
import net.thedudemc.pendantoflife.item.PendantBauble;

public class BaublesCompat {

	public static boolean getBauble(EntityPlayer player, boolean checkEverlasting) {
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
		int slots = baubles.getSlots();

		for (int i = 0; i < slots; i++) {
			ItemStack stack = baubles.getStackInSlot(i);
			if (checkEverlasting) {
				if (stack.getItem() instanceof EverlastingPendantBauble) {
					return true;
				}
			} else {
				if (stack.getItem() instanceof PendantBauble) {
					stack.shrink(1);
					return true;
				}
			}
		}
		return false;
	}

	public static int getSlotAmount(EntityPlayer player) {
		return BaublesApi.getBaublesHandler(player).getSlots();
	}

	public static NonNullList<ItemStack> keepBaubles(EntityPlayer player) {
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
		NonNullList<ItemStack> items = NonNullList.withSize(baubles.getSlots(), ItemStack.EMPTY);

		for (int i = 0; i < baubles.getSlots(); i++) {
			items.set(i, baubles.getStackInSlot(i));
			baubles.setStackInSlot(i, ItemStack.EMPTY);
		}
		return items;
	}

	public static void returnBaubles(EntityPlayer player, NonNullList<ItemStack> items) {
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);

		if (items.size() == baubles.getSlots()) {
			for (int i = 0; i < baubles.getSlots() && i < items.size(); i++) {
				baubles.setStackInSlot(i, items.get(i));
			}
		}

	}
}
