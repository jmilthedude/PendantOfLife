package net.thedudemc.pendantoflife.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.thedudemc.pendantoflife.item.EverlastingPendant;
import net.thedudemc.pendantoflife.item.Pendant;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();

	public static final Item PENDANT = new Pendant("pendant");
	public static final Item EVERLASTING_PENDANT = new EverlastingPendant("everlasting_pendant");

}
