package gamecycles.morphpotion.events;


import gamecycles.morphpotion.capabilities.IMorphingMOB;
import gamecycles.morphpotion.capabilities.MorphingMOB;
import gamecycles.morphpotion.capabilities.MorphingMOBProvider;
import mchorse.metamorph.Metamorph;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
	 public static final ResourceLocation MORPHING_MOB_CAP = new ResourceLocation(Metamorph.MODID, "morphing_mob_capability");

	    /**
	     * Attach capabilities (well, only one, right now)
	     */
	    @SuppressWarnings("deprecation")
		@SubscribeEvent
	    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	    {
	    	if(event.getObject() instanceof EntityPlayer)
	    		return;	//do not want the player, has it's own capability 
	    	
	        if (!(event.getObject() instanceof EntityLiving)) return;
	    	

	        //System.out.println("Capability attached");
	        event.addCapability(MORPHING_MOB_CAP, new MorphingMOBProvider());
	        IMorphingMOB capability=MorphingMOBProvider.get((EntityLiving)event.getObject());
	        if(capability!=null){
	        	//System.out.println("Capability created, setting original tag");
	        	NBTTagCompound tag=new NBTTagCompound();
	        	tag.setString("Name", event.getObject().getName());
	        	
	        	capability.setOriginalEntity(tag);
	        }
	    }
	    
	    
//	   
	    
	    @SubscribeEvent
	    public void mobConstructed(EntityEvent.EntityConstructing event)
	    {
	    	if(event.getEntity() instanceof EntityLiving){
		        EntityLiving mob=(EntityLiving) event.getEntity();
		        IMorphingMOB cap = MorphingMOBProvider.get(mob);
	
		        if (cap != null)
		        {
		        	NBTTagCompound tag=new NBTTagCompound();
		        	tag.setString("Name", mob.getName());
		        	cap.setOriginalEntity(tag);
//		        	System.out.println("Mob constructed, setting original entity:"+mob.getName());
		            //this.sendAcquiredMorphs(cap, player);
		        	
//		            /* Ensure that player was morphed */
//		            if (cap.isMorphed())
//		            {
//		                cap.getCurrentMorph().morph(player);
//		            }
	
		            /* Send data */
		           // Dispatcher.sendTo(new PacketBlacklist(MorphManager.INSTANCE.blacklist), (EntityPlayerMP) player);
		           // Dispatcher.sendTo(new PacketSettings(MorphManager.INSTANCE.settings), (EntityPlayerMP) player);
		        }
	    	}
	    }
}
