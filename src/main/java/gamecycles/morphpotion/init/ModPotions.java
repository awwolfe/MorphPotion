package gamecycles.morphpotion.init;


import gamecycles.morphpotion.MorphPotionMod;
import gamecycles.morphpotion.potion.PotionFreezeResistance;
import gamecycles.morphpotion.potion.PotionTransform;
import mchorse.metamorph.Metamorph;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ModPotions {
	
	public static final int POTION_DURATION	=1200;//3600;
	public static final int POTION_DURATION_EXTENDED=960;
	
	
	public static Potion freeze_resistance;
	public static Potion transform_polar_bear;
	public static Potion transform_chicken;
	public static Potion transform_cow;
	public static Potion transform_bat;
	public static Potion transform_cave_spider;
	public static Potion transform_spider;
	public static Potion transform_donkey;
	public static Potion transform_horse;
	public static Potion transform_ocelot;
	public static Potion transform_rabbit;
	public static Potion transform_sheep;
	public static Potion transform_squid;
	public static Potion transform_wolf;
	public static Potion transform_enderman;
	public static Potion transform_snowman;
	public static Potion transform_creeper;
	public static Potion transform_villager;
	public static Potion transform_villager_golem;
	public static Potion transform_blaze;
	public static Potion transform_ghast;
	public static Potion transform_skeleton;
	public static Potion transform_guardian;
	public static Potion transform_guardian_elder;
	public static Potion transform_magma_cube;
	public static Potion transform_slime;
	public static Potion transform_husk;
	public static Potion transform_zombie;
	public static Potion transform_pig;
	public static Potion transform_wither_skeleton;
	public static Potion transform_waddles;
	public static Potion transform_parrot;
	public static Potion transform_shulker;
	public static Potion demorphMOB;

    
    public static PotionType freeze_resistance_type;
    public static PotionType transform_type;
    public static PotionType transform_polar_bear_type;
    public static PotionType transform_chicken_type;
    public static PotionType transform_cow_type;
    public static PotionType transform_bat_type;
    public static PotionType transform_cave_spider_type;
    public static PotionType transform_spider_type;
    public static PotionType transform_donkey_type;
    public static PotionType transform_horse_type;
    public static PotionType transform_ocelot_type;
    public static PotionType transform_rabbit_type;
    public static PotionType transform_sheep_type;
    public static PotionType transform_squid_type;
    public static PotionType transform_wolf_type;
    public static PotionType transform_enderman_type;
    public static PotionType transform_snowman_type;
    public static PotionType transform_creeper_type;
    public static PotionType transform_villager_type;
    public static PotionType transform_villager_golem_type;
    public static PotionType transform_blaze_type;
    public static PotionType transform_ghast_type;
    public static PotionType transform_skeleton_type;
    public static PotionType transform_guardian_type;
    public static PotionType transform_guardian_elder_type;
    public static PotionType transform_magma_cube_type;
    public static PotionType transform_slime_type;
    public static PotionType transform_husk_type;
    public static PotionType transform_zombie_type;
    public static PotionType transform_pig_type;
    public static PotionType transform_wither_skeleton_type;
    public static PotionType transform_waddles_type;
    public static PotionType transform_parrot_type;
    public static PotionType transform_shulker_type;
    public static PotionType demorphMOB_type;


    public static ArrayList<PotionTypeEntry> list=new ArrayList<PotionTypeEntry>();
    
    public static void  init(){
    	boolean waddles=false;
		if(Loader.isModLoaded("waddles")){
			System.out.println("\nWaddles Mod is loaded\n");
			waddles=true;
		}
		else{
			System.out.println("\nWaddles MOD is NOT loaded\n");
		}
    	
    	
    	//freeze_resistance = registerPotion("freeze_resistance", new PotionFreezeResistance(24));
		freeze_resistance=new PotionFreezeResistance(24);
		freeze_resistance.setPotionName("freeze_resistance");
		freeze_resistance.setRegistryName(MorphPotionMod.modId,"potion.freeze_resistance");
		ForgeRegistries.POTIONS.register(freeze_resistance);
		 transform_polar_bear=registerPotion("transform_polar_bear",new PotionTransform("minecraft:polar_bear", 25, 1, 2, POTION_DURATION).setPotionName("potion.transform_polar_bear"));
		 transform_chicken=registerPotion("transform_chicken",new PotionTransform("minecraft:chicken", 26, 0, 2, POTION_DURATION).setPotionName("potion.transform_chicken"));
		 transform_cow=registerPotion("transform_cow",new PotionTransform("minecraft:cow", 27, 13, 1, POTION_DURATION).setPotionName("potion.transform_cow"));
		 transform_bat=registerPotion("transform_bat",new PotionTransform("minecraft:bat", 27, 1 , 0, POTION_DURATION).setPotionName("potion.transform_bat"));
		 transform_cave_spider=registerPotion("transform_cave_spider",new PotionTransform("minecraft:cave_spider", 27, 12 , 1, POTION_DURATION).setPotionName("potion.transform_cave_spider"));
		 transform_spider=registerPotion("transform_spider",new PotionTransform("minecraft:spider", 27, 11 , 1, POTION_DURATION).setPotionName("potion.transform_spider"));
		 transform_donkey=registerPotion("transform_donkey",new PotionTransform("minecraft:donkey", 27,  10, 1, POTION_DURATION).setPotionName("potion.transform_donkey"));
		 transform_horse=registerPotion("transform_horse",new PotionTransform("minecraft:horse", 27, 9 , 1, POTION_DURATION).setPotionName("potion.transform_horse"));
		 transform_ocelot=registerPotion("transform_ocelot",new PotionTransform("minecraft:ocelot", 25, 8 , 1, POTION_DURATION).setPotionName("potion.transform_ocelot"));
		 transform_sheep=registerPotion("transform_sheep",new PotionTransform("minecraft:sheep", 27, 7 , 1, POTION_DURATION).setPotionName("potion.transform_sheep"));
		 transform_wolf=registerPotion("transform_wolf",new PotionTransform("minecraft:wolf", 27, 6 , 1, POTION_DURATION).setPotionName("potion.transform_wolf"));
		 transform_enderman=registerPotion("transform_enderman",new PotionTransform("minecraft:enderman", 27, 5 , 1, POTION_DURATION).setPotionName("potion.transform_enderman"));
		 transform_snowman=registerPotion("transform_snowman",new PotionTransform("minecraft:snowman", 27, 4 , 1, POTION_DURATION).setPotionName("potion.transform_snowman"));
		 transform_creeper=registerPotion("transform_creeper",new PotionTransform("minecraft:creeper", 27, 3 , 1, POTION_DURATION).setPotionName("potion.transform_creeper"));
		 transform_villager=registerPotion("transform_villager",new PotionTransform("minecraft:villager", 27, 2 , 1, POTION_DURATION).setPotionName("potion.transform_villager"));
		 transform_villager_golem=registerPotion("transform_villager_golem",new PotionTransform("minecraft:villager_golem", 27, 1 , 1, POTION_DURATION).setPotionName("potion.transform_villager_golem"));
		 transform_blaze=registerPotion("transform_blaze",new PotionTransform("minecraft:blaze", 27, 0 , 1, POTION_DURATION).setPotionName("potion.transform_blaze"));
		 
		 transform_ghast=registerPotion("transform_ghast",new PotionTransform("minecraft:ghast", 27, 13 , 0, POTION_DURATION).setPotionName("potion.transform_ghast"));
		 transform_skeleton=registerPotion("transform_skeleton",new PotionTransform("minecraft:skeleton", 27,12 , 0, POTION_DURATION).setPotionName("potion.transform_skeleton"));
		 transform_guardian=registerPotion("transform_guardian",new PotionTransform("minecraft:guardian", 27, 11 , 0, POTION_DURATION).setPotionName("potion.transform_guardian"));
		 transform_guardian_elder=registerPotion("transform_guardian_elder",new PotionTransform("minecraft:guardian_elder", 27, 10 , 0, POTION_DURATION).setPotionName("potion.transform_guardian_elder"));
		 transform_magma_cube=registerPotion("transform_magma_cube",new PotionTransform("minecraft:magma_cube", 27, 9 , 0, POTION_DURATION).setPotionName("potion.transform_magma_cube"));
		 transform_slime=registerPotion("transform_slime",new PotionTransform("minecraft:slime", 27, 8 , 0, POTION_DURATION).setPotionName("potion.transform_slime"));
		 transform_husk=registerPotion("transform_husk",new PotionTransform("minecraft:husk", 27, 7 , 0, POTION_DURATION).setPotionName("potion.transform_husk"));
		 transform_zombie=registerPotion("transform_zombie",new PotionTransform("minecraft:zombie", 27, 6 , 0, POTION_DURATION).setPotionName("potion.transform_zombie"));
		 transform_pig=registerPotion("transform_pig",new PotionTransform("minecraft:pig", 27, 5 , 0, POTION_DURATION).setPotionName("potion.transform_pig"));
		 transform_squid=registerPotion("transform_squid",new PotionTransform("minecraft:squid", 27, 4 , 0, POTION_DURATION).setPotionName("potion.transform_squid"));
		 transform_rabbit=registerPotion("transform_rabbit",new PotionTransform("minecraft:rabbit", 27, 3 , 0, POTION_DURATION).setPotionName("potion.transform_rabbit"));
		 transform_wither_skeleton=registerPotion("transform_wither_skeleton",new PotionTransform("minecraft:wither_skeleton", 27, 2, 0, POTION_DURATION).setPotionName("potion.transform_wither_skeleton"));
		 if(waddles){
			 transform_waddles=registerPotion("transform_waddles",new PotionTransform("waddles:adelie_penguin", 27, 2, 0, POTION_DURATION).setPotionName("potion.transform_waddles"));
		 }
		 transform_parrot=registerPotion("transform_parrot",new PotionTransform("minecraft:parrot",27,2,2,POTION_DURATION).setPotionName("potion.transform_parrot"));
		 transform_shulker=registerPotion("transform_shulker",new PotionTransform("minecraft:shulker",27,3,2,POTION_DURATION).setPotionName("potion.transform_shulker"));
		 demorphMOB=registerPotion("demorph",new PotionTransform("",28,0,0,10).setPotionName("potion.demorph"));
		 //   hyperthermia = registerPotion("hyperthermia", new PotionHyperthermia(25).setPotionName("potion.hyperthermia"));
	      //  thirst = registerPotion("thirst", new PotionThirst(26).setPotionName("potion.thirst"));
	      //  cold_resistance = registerPotion("cold_resistance", new PotionColdResistance(27).setPotionName("potion.cold_resistance").setBeneficial());
	      //  heat_resistance = registerPotion("heat_resistance", new PotionHeatResistance(28).setPotionName("potion.heat_resistance").setBeneficial());
		 demorphMOB_type=registerPotionType("transform_demorph_type",new PotionType(new PotionEffect [] {new PotionEffect(demorphMOB,POTION_DURATION,0,true,true)}),1);
	     freeze_resistance_type = registerPotionType("freeze_resistance_type", new PotionType(new PotionEffect[] {new PotionEffect(freeze_resistance, POTION_DURATION,0,true,false)}),1);
	     transform_polar_bear_type=registerPotionType("transform_polar_bear_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_polar_bear,POTION_DURATION,0,true,true)}),3);
	     transform_chicken_type=registerPotionType("transform_chicken_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_chicken,POTION_DURATION,0,true,true)}),1);
	     transform_cow_type=registerPotionType("transform_cow_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_cow,POTION_DURATION,0,true,true)}),1);
	     transform_bat_type=registerPotionType("transform_bat_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_bat,POTION_DURATION,0,true,true)}),2);
	     transform_cave_spider_type=registerPotionType("transform_cave_spider_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_cave_spider,POTION_DURATION,0,true,true)}),3);
	     transform_spider_type=registerPotionType("transform_spider_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_spider,POTION_DURATION,0,true,true)}),2);
	     transform_donkey_type=registerPotionType("transform_donkey_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_donkey,POTION_DURATION,0,true,true)}),2);
	     transform_horse_type=registerPotionType("transform_horse_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_horse,POTION_DURATION,0,true,true)}),2);
	     transform_ocelot_type=registerPotionType("transform_ocelot_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_ocelot,POTION_DURATION,0,true,true)}),2);
	     transform_rabbit_type=registerPotionType("transform_rabbit_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_rabbit,POTION_DURATION,0,true,true)}),1);
	     transform_sheep_type=registerPotionType("transform_sheep_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_sheep,POTION_DURATION,0,true,true)}),1);
	     transform_squid_type=registerPotionType("transform_squid_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_squid,POTION_DURATION,0,true,true)}),3);
	     transform_wolf_type=registerPotionType("transform_wolf_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_wolf,POTION_DURATION,0,true,true)}),2);
	     transform_enderman_type=registerPotionType("transform_enderman_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_enderman,POTION_DURATION,0,true,true)}),3);
	     transform_snowman_type=registerPotionType("transform_snowman_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_snowman,POTION_DURATION,0,true,true)}),2);
	     transform_creeper_type=registerPotionType("transform_creeper_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_creeper,POTION_DURATION,0,true,true)}),2);
	     transform_villager_type=registerPotionType("transform_villager_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_villager,POTION_DURATION,0,true,true)}),1);
	     transform_villager_golem_type=registerPotionType("transform_villager_golem_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_villager_golem,POTION_DURATION,0,true,true)}),3);
	     transform_blaze_type=registerPotionType("transform_blaze_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_blaze,POTION_DURATION,0,true,true)}),3);
	     transform_ghast_type=registerPotionType("transform_ghast_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_ghast,POTION_DURATION,0,true,true)}),3);
	     transform_skeleton_type=registerPotionType("transform_skeleton_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_skeleton,POTION_DURATION,0,true,true)}),2);
	     transform_guardian_type=registerPotionType("transform_guardian_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_guardian,POTION_DURATION,0,true,true)}),3);
	     transform_guardian_elder_type=registerPotionType("transform_guardian_elder_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_guardian_elder,POTION_DURATION,0,true,true)}),3);
	     transform_magma_cube_type=registerPotionType("transform_magma_cube_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_magma_cube,POTION_DURATION,0,true,true)}),2);
	     transform_slime_type=registerPotionType("transform_slime_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_slime,POTION_DURATION,0,true,true)}),1);
	     transform_husk_type=registerPotionType("transform_husk_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_husk,POTION_DURATION,0,true,true)}),1);
	     transform_zombie_type=registerPotionType("transform_zombie_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_zombie,POTION_DURATION,0,true,true)}),1);
	     transform_pig_type=registerPotionType("transform_pig_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_pig,POTION_DURATION,0,true,true)}),1);
	     transform_wither_skeleton_type=registerPotionType("transform_wither_skeleton_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_wither_skeleton,POTION_DURATION,0,true,true)}),2);
	     if(waddles){
	    	   transform_waddles_type=registerPotionType("transform_waddles_type",new PotionType(new PotionEffect [] {new PotionEffect(transform_waddles,POTION_DURATION,0,true,true)}),1);
	       }
	     transform_parrot_type=registerPotionType("transform_parrot_type",new PotionType(new PotionEffect[]{new PotionEffect(transform_parrot,POTION_DURATION,0,true,true)}),1);
	     transform_shulker_type=registerPotionType("transform_shulker_type",new PotionType(new PotionEffect[]{new PotionEffect(transform_shulker,POTION_DURATION,0,true,true)}),3);
    }
    
    public static Potion registerPotion(String name, Potion potion)
    {
    	potion.setRegistryName(MorphPotionMod.modId,name);
    	potion.setPotionName("potion."+name);
    	ForgeRegistries.POTIONS.register(potion);
       
        return potion;
    }
    
    public static PotionType registerPotionType(String name, PotionType potionType,int level)
    {
    	potionType.setRegistryName(MorphPotionMod.modId,name);
    	ForgeRegistries.POTION_TYPES.register(potionType);

		list.add(new PotionTypeEntry(level,potionType));

        return potionType;
    }

    public static PotionType getRandomPotion(int level, Random random){
    	//build temp list
	    ArrayList<PotionType> temp=new ArrayList<PotionType>();
	    for (PotionTypeEntry entry:list) {
	    	if(entry.level==level){
	    		temp.add(entry.type);
		    }

	    }

	    if(temp.size()>0){
	    	int index=random.nextInt(temp.size());
	    	return temp.get(index);
	    }

	    return PotionTypes.AWKWARD;
    }


}

