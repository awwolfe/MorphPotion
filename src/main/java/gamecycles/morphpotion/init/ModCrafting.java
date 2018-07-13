package gamecycles.morphpotion.init;

import java.util.Iterator;
import java.util.Set;

import gamecycles.morphpotion.potion.PotionRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {
public static void init(){
		
		//GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemVialEmpty), new Object[]{Blocks.GLASS});
		
		
		
		BrewingRecipeRegistry.addRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), PotionTypes.AWKWARD),
				new ItemStack(ModItems.itemVial,1,1),PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.demorphMOB_type));
//		
		//pig
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.PORKCHOP),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_pig_type)));
		
		
		//System.out.println("Dump Items");
		Set<ResourceLocation> keys=Item.REGISTRY.getKeys();
		Iterator<ResourceLocation> it=keys.iterator();
		while(it.hasNext()){
			ResourceLocation r=(ResourceLocation)it.next();
			//System.out.println(r.getResourceDomain()+":"+r.getResourcePath());
			if(r.getResourcePath().contains("bat")){
				System.out.println("\nBAT FOUND\n");
			}
		}
		
		
		
		if(ModItems.itemBatWing!=null){
			//bat
//			BrewingRecipeRegistry.addRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(ModItems.itemBatWing),
//					PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_bat_type));
			BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(ModItems.itemBatWing),
					PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_bat_type)));
				
			
//		
		}	
		//sheep
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.MUTTON),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_sheep_type)));
//		
		
		//chicken
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.FEATHER),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_chicken_type)));
//		
		
		//cave spider
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.transform_spider_type),new ItemStack(Items.POISONOUS_POTATO),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_cave_spider_type)));
//		
		
		//spider
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.SPIDER_EYE),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_spider_type)));
//		
		
		//cow
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.LEATHER),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_cow_type)));
//		
		
		//donkey
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(ModItems.itemDonkeyHide),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_donkey_type)));
//		

		//horse
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(ModItems.itemHorseHide),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_horse_type)));
//		
//		
		
		//ocelot
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(ModItems.itemOcelotHide),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_ocelot_type)));
//		
		
		//polar bear
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(ModItems.itemPolarBearHide),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_polar_bear_type)));
//		
		
		
		//rabbit
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.RABBIT_HIDE),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_rabbit_type)));
//		
		
		
		//squid
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.DYE),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_squid_type)));
//		
		
		//wolf
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(ModItems.itemWolfHide),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_wolf_type)));
//		

		
		//enderman
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.ENDER_PEARL),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_enderman_type)));
//		
		
		//snowman
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Blocks.SNOW),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_snowman_type)));
//		
		
		//creeper
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.GUNPOWDER),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_creeper_type)));
//		
		
		//villager
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.EMERALD),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_villager_type)));
//		
		
		//villager_golem
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Blocks.IRON_BLOCK),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_villager_golem_type)));
//		
		
		//blaze
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.BLAZE_ROD),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_blaze_type)));
//		
		
		//ghast
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.GHAST_TEAR),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_ghast_type)));
//		
		
		//skeleton
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.BONE),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_skeleton_type)));
//		
		
		//wither skeleton
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.transform_skeleton_type),new ItemStack(Blocks.SOUL_SAND),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_wither_skeleton_type)));
		
		//guardian
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.PRISMARINE_SHARD),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_guardian_type)));
//		
		
		//guardian_elder
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.PRISMARINE_CRYSTALS),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_guardian_elder_type)));
//		
		
		//magma_cube
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Blocks.MAGMA),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_magma_cube_type)));
//		
		
		//slime
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.SLIME_BALL),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_slime_type)));
//		
		
		//husk
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Blocks.SAND),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_husk_type)));
//		
		
		//zombie
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.ROTTEN_FLESH),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_zombie_type)));
		
		//parrot
		BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(ModItems.itemParrotFeather),
				PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_parrot_type)));
		
		
		//shulker
				BrewingRecipeRegistry.addRecipe(new PotionRecipe(PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM),ModPotions.demorphMOB_type),new ItemStack(Items.SHULKER_SHELL),
						PotionUtils.addPotionToItemStack(new ItemStack(Items.POTIONITEM), ModPotions.transform_shulker_type)));
//		
		
	}
}
