package net.thedudemc.pendantoflife.util;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thedudemc.pendantoflife.PendantOfLife;
import net.thedudemc.pendantoflife.init.BaubleItems;
import net.thedudemc.pendantoflife.init.ModItems;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		if (PendantOfLife.BAUBLE) {
			event.getRegistry().registerAll(BaubleItems.ITEMS.toArray(new Item[0]));
		} else {
			event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		}
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		if (PendantOfLife.BAUBLE) {
			for (Item item : BaubleItems.ITEMS) {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
			}
		} else {
			for (Item item : ModItems.ITEMS) {
				ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
			}
		}
	}

}
