package gamecycles.morphpotion.potion;


import java.util.Iterator;

import gamecycles.morphpotion.MorphPotionAPI;
import gamecycles.morphpotion.MorphPotionConfig;
import gamecycles.morphpotion.capabilities.IMorphingMOB;
import gamecycles.morphpotion.capabilities.MorphingMOB;
import gamecycles.morphpotion.capabilities.MorphingMOBProvider;
import mchorse.metamorph.Metamorph;
import mchorse.metamorph.api.MorphAPI;
import mchorse.metamorph.api.MorphManager;
import mchorse.metamorph.capabilities.morphing.IMorphing;
import mchorse.metamorph.capabilities.morphing.Morphing;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class PotionTransform extends MetamorphPotion{
	public String morphString="";
	public int duration=0;
	private EntityLivingBase	entity;
	public PotionTransform(String morph, int liquidColorIn,int x, int y,int duration) {
		super(false, liquidColorIn,x,y);
		this.morphString=morph;
		this.duration=duration;

		
		
	}
	

	


	@Override
	public void removeAttributesModifiersFromEntity(EntityLivingBase entityLivingBaseIn,
			AbstractAttributeMap attributeMapIn, int amplifier) {
		super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);
		
//		System.out.println("Remove attribute modifiers");
		if(entityLivingBaseIn instanceof EntityPlayer){
			//check to see if there are any other potionTransforms
			EntityPlayer player=(EntityPlayer)entityLivingBaseIn;
			int count=0;
			for(Potion p:player.getActivePotionMap().keySet()){
				if(p instanceof PotionTransform){
					count++;
//					System.out.println("potion on:"+p.getName());
				}
			}
			
			if(count==0){
				MorphAPI.demorph((EntityPlayer)entityLivingBaseIn);
			}
		}
		else{
			IMorphingMOB capability=MorphingMOBProvider.get((EntityLiving) entityLivingBaseIn);
	    	if(capability !=null)
	    	{
	    		if(capability.isMorphed())
	    		{
	    		//	
	    				//System.out.println("Time to demorph:"+mob.getName());
	    				capability.demorphPotion((EntityLiving) entityLivingBaseIn);
	    				
	    			
	    		}
	    	}
		}

	}

	@Override
	public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn,
			AbstractAttributeMap attributeMapIn, int amplifier) {
		
		
			
			entity=entityLivingBaseIn;
//			System.out.println("applyAttributesModifiers");
			if(morphString!=""){
				
			if(entityLivingBaseIn instanceof EntityPlayer){
				EntityPlayer player=(EntityPlayer) entityLivingBaseIn;
				//remove any previous potionTransforms
//				Iterator<Potion> iterator=player.getActivePotionMap().keySet().iterator();
//				while(iterator.hasNext()){
//					Potion potion=iterator.next();
//					if(potion instanceof PotionTransform ){
//						PotionTransform tp=(PotionTransform)potion;
//						if(!tp.morphString.equals(this.morphString)){
//							System.out.println("removing potion:"+potion.getName());
//							player.removePotionEffect(potion);
//						}
//					}
//				}
				
				
				
				NBTTagCompound tag=new NBTTagCompound();
				tag.setString("Name", morphString);
				MorphPotionAPI.morphPotion(player, MorphManager.INSTANCE.morphFromNBT(tag), duration);
			
			}
			else if(entityLivingBaseIn instanceof EntityLiving){
				if(MorphPotionConfig.allow_mob_morph){
					EntityLiving mob=(EntityLiving)entityLivingBaseIn;
	//				System.out.println("apply to mob:"+mob.getName());
					if(!mob.isNonBoss()) return ; //can't use potion on boss
					
					if(!mob.getEntityWorld().isRemote){
						//only do on the server
						IMorphingMOB capability=MorphingMOBProvider.get(mob);//mob.getCapability(capability, facing)
	//					System.out.println("Entity hit MOB. amplifier:"+amplifier);
						if(capability!=null){
						//	System.out.println("MOB capability found");
							NBTTagCompound tag=new NBTTagCompound();
							tag.setString("Name", morphString);
							
							if(capability.setCurrentMorphPotion(tag, mob, duration)){
								//mob.setDead();
							//	System.out.println("Succesfully morphed MOB");
								
							}
						}
					}
				}
			}
		}
		else
		{
//			System.out.println("apply demorph");
			if(entityLivingBaseIn instanceof EntityPlayer){
				EntityPlayer player=(EntityPlayer) entityLivingBaseIn;
				MorphAPI.demorph(player);
			}else{
//				System.out.println("demorph mob");
				IMorphingMOB morph=MorphingMOBProvider.get((EntityLiving) entityLivingBaseIn);
				morph.demorphPotion((EntityLiving) entityLivingBaseIn);
			}
		}
			super.applyAttributesModifiersToEntity(entityLivingBaseIn, attributeMapIn, amplifier);
	}
	@Override
	public boolean shouldRenderHUD(PotionEffect effect) {
		//System.out.println("shouldRenderHUD:"+effect.getDuration());
		if(effect.getDuration()<1)return false;
		if(effect.getDuration()<=200){
			if(effect.getDuration()<=60)
			{
				int check=effect.getDuration()/5;
				if(check%2==0){
					//System.out.println("shouldRenderHUD false");
					return false;
				}
			}
			else{
				int check=effect.getDuration()/10;
				if(check%2==0){
					//System.out.println("shouldRenderHUD false");
					return false;
				}
			}
			//System.out.println("shouldRenderHUD true");
		}
		return true;
	//	return true;//super.shouldRenderHUD(effect);
	}
	
	
	
	/* (non-Javadoc)
	 * @see net.minecraft.potion.Potion#renderInventoryEffect(int, int, net.minecraft.potion.PotionEffect, net.minecraft.client.Minecraft)
	 */
	@Override
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {

		if(effect.getDuration()<1)return;
		PotionTransform p=(PotionTransform)effect.getPotion();
		if(p!=null){
			
			Minecraft.getMinecraft().getTextureManager().bindTexture(POTIONS_LOCATION);
			

			if(mc.currentScreen!=null){
				mc.currentScreen.drawTexturedModalRect(x+3,y+3,p.getIconIndex().x*18,p.getIconIndex().y*18,18,18);
			}

		}
	}
	/* (non-Javadoc)
	 * @see net.minecraft.potion.Potion#renderHUDEffect(int, int, net.minecraft.potion.PotionEffect, net.minecraft.client.Minecraft, float)
	 */
	@Override
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		if(effect.getDuration()<1)return;
		
		PotionTransform p=(PotionTransform)effect.getPotion();
		if(p!=null){
			Minecraft.getMinecraft().getTextureManager().bindTexture(POTIONS_LOCATION);

			mc.ingameGUI.drawTexturedModalRect(x+3,y+3,p.getIconIndex().x*18,p.getIconIndex().y*18,18,18);

		}
		

	}

}
