package net.thedudemc.pendantoflife.util;

import java.util.function.Predicate;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BaublesCompat {

	public static void keepBaubles(EntityPlayer player, NonNullList<ItemStack> items) {
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);

		for (int i = 0; i < baubles.getSlots() && i < items.size(); i++) {
			items.set(i, baubles.getStackInSlot(i));
			baubles.setStackInSlot(i, ItemStack.EMPTY);
		}
	}

	public static boolean consumeBaubleItem(EntityLivingBase living, Predicate<ItemStack> matcher, int count) {
		
		
		boolean consumedSome = false;
		EntityPlayer player = (EntityPlayer) living;
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
		int slots = baubles.getSlots();

		for (int i = 0; i < slots && count > 0; i++) {
			ItemStack stack = baubles.getStackInSlot(i);
			if (matcher.test(stack)) {
				int consume = Math.min(count, stack.getCount());
				stack.shrink(consume);
				count -= consume;
				consumedSome = true;
			}
		}

		return consumedSome;
	}
	
	public static boolean findBaubleItem(EntityLivingBase living, Predicate<ItemStack> matcher, int count) {
		
		
		boolean consumedSome = false;
		EntityPlayer player = (EntityPlayer) living;
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
		int slots = baubles.getSlots();

		for (int i = 0; i < slots && count > 0; i++) {
			ItemStack stack = baubles.getStackInSlot(i);
			if (matcher.test(stack)) {
				consumedSome = true;
			}
		}

		return consumedSome;
	}

	public static int getSlotAmount(EntityPlayer player) {
		return BaublesApi.getBaublesHandler(player).getSlots();
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
