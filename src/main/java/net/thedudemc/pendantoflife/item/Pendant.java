package net.thedudemc.pendantoflife.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thedudemc.pendantoflife.Reference;
import net.thedudemc.pendantoflife.init.ModItems;

public class Pendant extends Item {

	public Pendant(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(1);

		ModItems.ITEMS.add(this);

	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(Reference.PENDANT_TOOLTIP);
	}

}
