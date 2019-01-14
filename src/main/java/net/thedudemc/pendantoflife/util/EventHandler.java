package net.thedudemc.pendantoflife.util;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingExperienceDropEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import net.thedudemc.pendantoflife.PendantOfLife;
import net.thedudemc.pendantoflife.Reference;
import net.thedudemc.pendantoflife.config.Config;
import net.thedudemc.pendantoflife.util.compat.BaublesCompat;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventHandler {

	@SubscribeEvent
	public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
		if (!Config.everlastingRecipeEnabled) {
			ResourceLocation recipe = new ResourceLocation("jmilpol:pendant_recipe");
			IForgeRegistryModifiable<IRecipe> modRegistry = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();
			modRegistry.remove(recipe);
		}
		if (!Config.pendantRecipeEnabled) {
			ResourceLocation recipe = new ResourceLocation("jmilpol:normal_pendant_recipe");
			IForgeRegistryModifiable<IRecipe> modRegistry = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();
			modRegistry.remove(recipe);
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void onDeath(LivingDeathEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
			if (!hasTotem((EntityPlayer) event.getEntity())) {
				EntityPlayer player = (EntityPlayer) event.getEntity();
				InventoryHandler.handlePendant(player);
			}
		}
	}

	public static boolean hasTotem(EntityPlayer player) {
		for (ItemStack stack : player.inventory.offHandInventory) {
			if (stack.getItem().getTranslationKey().equals("totem")) {
				return true;
			}
		}
		return false;
	}

	@SubscribeEvent
	public static void onXPDrop(LivingExperienceDropEvent event) {
		UUID playerUUID = event.getEntity().getUniqueID();
		if (InventoryHandler.xpMap.containsKey(playerUUID)) {
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public static void onPlayerRespawn(PlayerRespawnEvent event) {
		EntityPlayer player = event.player;
		UUID playerUUID = player.getUniqueID();
		if (InventoryHandler.keepMap.containsKey(playerUUID) && InventoryHandler.xpMap.containsKey(playerUUID)) {
			InventoryPlayer inventory = InventoryHandler.keepMap.remove(playerUUID);
			int exp = InventoryHandler.xpMap.remove(playerUUID);
			if (inventory != null) {
				player.addExperience(exp);
				player.inventory.copyInventory(inventory);
				if (PendantOfLife.BAUBLE) {
					if (InventoryHandler.keepBaublesMap.containsKey(playerUUID)) {
						NonNullList<ItemStack> baubles = InventoryHandler.keepBaublesMap.remove(player.getUniqueID());
						BaublesCompat.returnBaubles(player, baubles);
					}
				}
			}
		}
	}
}
