package gamecycles.morphpotion.init;


import gamecycles.morphpotion.MorphPotionMod;
import gamecycles.morphpotion.items.ItemVial;
import gamecycles.morphpotion.items.ModItem;
import mchorse.metamorph.Metamorph;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ModItems {

	public static Item	itemBatWing;
	public static boolean needBatWingDrop=false;
	public static ModItem itemPolarBearHide;
	public static ModItem itemHorseHide;
	public static ModItem itemDonkeyHide;
	public static ModItem itemOcelotHide;
	public static ModItem itemWolfHide;
	public static ModItem itemParrotFeather;
	public static ItemVial itemVial;
	
	
	public static void init(){

		itemVial=new ItemVial("item_vial");
	
		//want to see if we can get a reference to foodexpansion:itembatwing , otherwise create our own
		itemBatWing=Item.getByNameOrId("foodexpansion:itembatwing");
		if(itemBatWing==null){
			//create our own
			itemBatWing=new ModItem("item_bat_wing");
			itemBatWing.setCreativeTab(MorphPotionMod.tabMorphPotion);
			
			needBatWingDrop=true;
		}

		itemPolarBearHide=new ModItem("item_polar_bear_hide");
		itemPolarBearHide.setCreativeTab(CreativeTabs.MISC);
		
		itemHorseHide=new ModItem("item_horse_hide");
		itemHorseHide.setCreativeTab(CreativeTabs.MISC);
		
		
		itemDonkeyHide =new ModItem("item_donkey_hide");
		itemDonkeyHide.setCreativeTab(CreativeTabs.MISC);
		
		itemOcelotHide=new ModItem("item_ocelot_hide");
		itemOcelotHide.setCreativeTab(CreativeTabs.MISC);
		
		itemWolfHide=new ModItem("item_wolf_hide");
		itemWolfHide.setCreativeTab(CreativeTabs.MISC);
		
		itemParrotFeather=new ModItem("item_parrot_feather");
		itemParrotFeather.setCreativeTab(CreativeTabs.MISC);
		
	}

	
	
	
	public static void initModels(){

			itemPolarBearHide.initModel();
			itemHorseHide.initModel();
			itemDonkeyHide.initModel();
			itemOcelotHide.initModel();
			itemWolfHide.initModel();
			itemParrotFeather.initModel();
			if(needBatWingDrop){
				ModelLoader.setCustomModelResourceLocation(itemBatWing, 0, new ModelResourceLocation(MorphPotionMod.modId+":item_bat_wing","inventory"));

			}
			itemVial.initModel();
			
	}
}
