package gamecycles.morphpotion.items;

import java.util.ArrayList;

import gamecycles.morphpotion.MorphPotionMod;
import mchorse.metamorph.Metamorph;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModItem extends Item{
private String name;
	
	public ModItem(String name){
		super();
		this.name=name;
		this.setUnlocalizedName(name);
		this.setRegistryName(MorphPotionMod.modId, name);
		
		ForgeRegistries.ITEMS.register(this);
		this.setCreativeTab(MorphPotionMod.tabMorphPotion);
	}
	
	public void initModel(){
		if(this.hasSubtypes){
			NonNullList<ItemStack> stack=NonNullList.create();
			this.getSubItems(this.getCreativeTab(), stack);
			for(ItemStack itemStack:stack){
				String subItemName = this.getUnlocalizedName(itemStack);
                subItemName =  subItemName.substring(subItemName.indexOf(".") + 1); // remove 'item.' from the front

                ResourceLocation loc=new ResourceLocation(MorphPotionMod.modId,subItemName);
            
                ModelResourceLocation mrl=new ModelResourceLocation(loc,"inventory");
                ModelLoader.setCustomModelResourceLocation(this, itemStack.getMetadata(), new ModelResourceLocation(MorphPotionMod.modId + ":" + subItemName, "inventory"));
			}
		}
		else{
			
			ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(),"inventory"));
		}
	}
	
	
}
