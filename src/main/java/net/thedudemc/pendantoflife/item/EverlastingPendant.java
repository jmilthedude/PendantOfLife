package net.thedudemc.pendantoflife.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thedudemc.pendantoflife.Reference;
import net.thedudemc.pendantoflife.init.ModItems;

public class EverlastingPendant extends Item {

	public EverlastingPendant(String name) {
		this.setTranslationKey(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(1);

		ModItems.ITEMS.add(this);
	}

	@Override
	public boolean hasEffect(ItemStack itemstack) {
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(Reference.EVERLASTING_PENDANT_TOOLTIP);
	}

}
