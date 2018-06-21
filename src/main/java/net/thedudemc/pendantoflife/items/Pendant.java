package net.thedudemc.pendantoflife.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.thedudemc.pendantoflife.PendantOfLife;
import net.thedudemc.pendantoflife.init.ModItems;
import net.thedudemc.pendantoflife.util.IHasModel;
import net.thedudemc.pendantoflife.util.Reference;

public class Pendant extends Item implements IHasModel {

	public Pendant(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(1);

		ModItems.ITEMS.add(this);

	}

	@Override
	public void registerModels() {
		PendantOfLife.proxy.registerItemRenderer(this, 0, "inventory");

	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(Reference.PENDANT_TOOLTIP);
	}


}
