package net.thedudemc.pendantoflife.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.thedudemc.pendantoflife.item.EverlastingPendantBauble;
import net.thedudemc.pendantoflife.item.PendantBauble;

public class BaubleItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item PENDANT_BAUBLE = new PendantBauble("pendant");
	public static final Item EVERLASTING_PENDANT_BAUBLE = new EverlastingPendantBauble("everlasting_pendant");

}
