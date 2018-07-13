package gamecycles.morphpotion.events;

import java.util.Random;

import gamecycles.morphpotion.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityDropHandler {
	@SubscribeEvent void onLivingDrop(LivingDropsEvent event){
		Random rand=new Random();
		EntityLivingBase entity=event.getEntityLiving();

		
		//put into loot tables?
		
		if(entity instanceof EntityWolf){
			if(rand.nextInt(4)==0){	//1 in 4 chance
				event.getDrops().add(new EntityItem(entity.world,entity.posX,
						entity.posY,entity.posZ,new ItemStack(ModItems.itemWolfHide)));
			}
		}
		else if(entity instanceof EntityBat){
			//see if we need to drop batwings or not
			if(ModItems.needBatWingDrop){
				if(rand.nextInt(4)==0){	//1 in 4 chance
					event.getDrops().add(new EntityItem(entity.world,entity.posX,
							entity.posY,entity.posZ,new ItemStack(ModItems.itemBatWing)));
				}
			}
		}
		else if(event.getEntityLiving() instanceof EntityPolarBear){
			if(rand.nextInt(4)==0){	//1 in 4 chance
				event.getDrops().add(new EntityItem(entity.world,entity.posX,
						entity.posY,entity.posZ,new ItemStack(ModItems.itemPolarBearHide)));
			}
		}
		
		else if(event.getEntityLiving() instanceof EntityDonkey){
			if(rand.nextInt(4)==0){	//1 in 4 chance
				event.getDrops().add(new EntityItem(entity.world,entity.posX,
						entity.posY,entity.posZ,new ItemStack(ModItems.itemDonkeyHide)));
			}
		}
		else if(event.getEntityLiving() instanceof EntityHorse){
			if(rand.nextInt(4)==0){	//1 in 4 chance
				event.getDrops().add(new EntityItem(entity.world,entity.posX,
						entity.posY,entity.posZ,new ItemStack(ModItems.itemHorseHide)));
			}
		}
		else if(event.getEntityLiving() instanceof EntityOcelot){
			if(rand.nextInt(4)==0){	//1 in 4 chance
				event.getDrops().add(new EntityItem(entity.world,entity.posX,
						entity.posY,entity.posZ,new ItemStack(ModItems.itemOcelotHide)));
			}
		}
		else if(event.getEntityLiving() instanceof EntityParrot){
			if(rand.nextInt(4)==0){	//1 in 4 chance
				event.getDrops().add(new EntityItem(entity.world,entity.posX,
						entity.posY,entity.posZ,new ItemStack(ModItems.itemParrotFeather)));
			}
		}
		
		
	}
}
