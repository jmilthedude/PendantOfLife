package net.thedudemc.pendantoflife.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thedudemc.pendantoflife.init.BaubleItems;
import net.thedudemc.pendantoflife.init.ModBlocks;
import net.thedudemc.pendantoflife.init.ModItems;
import net.thedudemc.pendantoflife.util.IHasModel;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onBaubleItemRegister(RegistryEvent.Register<Item> event) {
		if (Loader.isModLoaded("baubles")) {
			event.getRegistry().registerAll(BaubleItems.ITEMS.toArray(new Item[0]));
		}
	}
	

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		if (!Loader.isModLoaded("baubles")) {
			event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		}
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		if (Loader.isModLoaded("baubles")) {
			for (Item item : BaubleItems.ITEMS) {
				if (item instanceof IHasModel) {
					((IHasModel) item).registerModels();
				}
			}
		} else {

			for (Item item : ModItems.ITEMS) {
				if (item instanceof IHasModel) {
					((IHasModel) item).registerModels();
				}
			}
		}

		for (Block block : ModBlocks.BLOCKS) {
			if (block instanceof IHasModel) {
				((IHasModel) block).registerModels();
			}
		}

	}
	

}
