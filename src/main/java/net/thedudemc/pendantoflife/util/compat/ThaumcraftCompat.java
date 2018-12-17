package net.thedudemc.pendantoflife.util.compat;

import net.minecraft.item.ItemStack;
import net.thedudemc.pendantoflife.init.BaubleItems;
import net.thedudemc.pendantoflife.init.ModItems;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ThaumcraftCompat {

	public static void registerAspects() {

		// victus,LIFE, mortus,DEATH, vitreus,CRYSTAL, praecantatio,MAGIC
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.PENDANT), new AspectList().add(Aspect.LIFE, 10).add(Aspect.DEATH, 2).add(Aspect.CRYSTAL, 3).add(Aspect.MAGIC, 5));
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.EVERLASTING_PENDANT), new AspectList().add(Aspect.LIFE, 25).add(Aspect.DEATH, 10).add(Aspect.CRYSTAL, 9).add(Aspect.MAGIC, 20));
		ThaumcraftApi.registerObjectTag(new ItemStack(BaubleItems.PENDANT_BAUBLE), new AspectList().add(Aspect.LIFE, 10).add(Aspect.DEATH, 2).add(Aspect.CRYSTAL, 3).add(Aspect.MAGIC, 5));
		ThaumcraftApi.registerObjectTag(new ItemStack(BaubleItems.EVERLASTING_PENDANT_BAUBLE), new AspectList().add(Aspect.LIFE, 25).add(Aspect.DEATH, 10).add(Aspect.CRYSTAL, 9).add(Aspect.MAGIC, 20));

	}

}
