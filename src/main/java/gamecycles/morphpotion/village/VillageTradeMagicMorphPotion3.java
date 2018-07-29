package gamecycles.morphpotion.village;

import gamecycles.morphpotion.init.ModPotions;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

import java.util.Random;

public class VillageTradeMagicMorphPotion3 implements EntityVillager.ITradeList {
	@Override
	public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {


		ItemStack stack= PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), ModPotions.getRandomPotion(3,random));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD,16),ItemStack.EMPTY,stack,0,10));
	}
}
