package net.thedudemc.pendantoflife.items;

import java.util.List;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.thedudemc.pendantoflife.PendantOfLife;
import net.thedudemc.pendantoflife.init.BaubleItems;
import net.thedudemc.pendantoflife.util.IHasModel;
import net.thedudemc.pendantoflife.util.Reference;

public class PendantBauble extends Item implements IHasModel, IBauble {

	public PendantBauble(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MISC);
		this.setMaxStackSize(1);

		BaubleItems.ITEMS.add(this);

	}

	public void registerModels() {
		if (Loader.isModLoaded("baubles")) {
			PendantOfLife.proxy.registerItemRenderer(this, 0, "inventory");
		}
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
