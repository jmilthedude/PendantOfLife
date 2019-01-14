package net.thedudemc.pendantoflife.item;

import java.util.List;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thedudemc.pendantoflife.Reference;
import net.thedudemc.pendantoflife.init.BaubleItems;

public class PendantBauble extends Item implements IBauble {

	public PendantBauble(String name) {
		this.setTranslationKey(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(1);

		BaubleItems.ITEMS.add(this);

	}

	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.AMULET;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(Reference.PENDANT_TOOLTIP);
	}

}
