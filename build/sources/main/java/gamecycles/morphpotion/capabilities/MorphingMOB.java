package gamecycles.morphpotion.capabilities;

import gamecycles.morphpotion.events.MorphMobEvent;
import gamecycles.morphpotion.init.ModPotions;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

public class MorphingMOB implements IMorphingMOB{
	private int duration=1000;
	private boolean readyDemorph=false;
	private boolean permanent=false;
	private NBTTagCompound original=new NBTTagCompound();
	private boolean morphed=false;
	
	@Override
	public int getDuration() {
		
		return duration;
	}

	@Override
	public void setDuration(int duration) {
		this.duration=duration;
		
	}

	@Override
	public boolean isPermanent() {

		return permanent;
	}

	@Override
	public boolean isMorphed() {

		return morphed;
	}

	@Override
	public void copy(IMorphingMOB morphing, EntityLiving mob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setCurrentMorph(NBTTagCompound tag, EntityLiving mob,
			boolean force) {
		
		//this method would be used on a save/load to set the values back to their playing values
//		String mobStr=tag.getString("Name");
//		
//				//System.out.println("MOB not already morphed. Setting original to:"+fixName(mob.getName()));
//				NBTTagCompound old_tag=new NBTTagCompound();
//				old_tag.setString("Name", fixName(mob.getName()));
//				cap_new.setOriginalEntity(old_tag);
//			
//			
//			
//			cap_new.setDuration(duration);
//			//cap_new.setDuration(200);
//			cap_new.setMorphed(true);
//			
//			//get capabilities of new mob
//			
//		
//			return true;
		
		
		
		return false;
	}

	@Override 
	public void setMorphed(boolean morphed){
		this.morphed=morphed;
	}
	
	@Override
	public boolean setCurrentMorphPotion(NBTTagCompound tag,
			EntityLiving mob, int duration) {
		
		String mobStr=tag.getString("Name");
		
		MorphMobEvent event=new MorphMobEvent.Pre(mob,mobStr,true);
		if(MinecraftForge.EVENT_BUS.post(event)){
			return false;	//event was cancelled;
		}
		
		//if any changes were made, use the
		mobStr=event.morph;
		
		//System.out.println("set current morph potion:"+mobStr);
		float health=mob.getHealth();
		
		EntityLiving e=(EntityLiving)EntityList.createEntityByIDFromName(new ResourceLocation(mobStr), mob.world);
		if(e!=null&& mob!=null){
			
			//mob.getPi
			
			e.setPositionAndRotation(mob.posX,mob.posY,mob.posZ,
				mob.rotationYaw, mob.rotationPitch);//may need to reverse pitch and yaw
			
			e.setHealth(health);
			e.addPotionEffect(new PotionEffect(ModPotions.demorphMOB,duration,1,true,false));
			mob.world.spawnEntity(e);
			String old_name=mob.getName();
			//get capabilities of old mob to see if already morphed
			//IMorphingMOB cap_old=MorphingMOB.get(mob);
			IMorphingMOB cap_new=MorphingMOBProvider.get(e);
			if(this.isMorphed()){
				//System.out.println("MOB already morphed, copying over original:"+original.getString("Name"));
				cap_new.setOriginalEntity(original);
			}
			else{
				//System.out.println("MOB not already morphed. Setting original to:"+fixName(mob.getName()));
				NBTTagCompound old_tag=new NBTTagCompound();
				old_tag.setString("Name", fixName(mob.getName()));
				if(e instanceof EntityAgeable){
					old_tag.setInteger("Age",((EntityAgeable)e).getGrowingAge());
					
				}
				//old_tag.setInteger("Age", mob.getAge());
				cap_new.setOriginalEntity(old_tag);
				
			}
			
			
			cap_new.setDuration(duration);
			//cap_new.setDuration(200);
			cap_new.setMorphed(true);
			
			//get capabilities of new mob
			
			
			MorphMobEvent eventPost=new MorphMobEvent.Post(e,old_name,true);
			if(!MinecraftForge.EVENT_BUS.post(eventPost)){
				mob.setDead();//remove original entity
			}
			return true;
		}
		
		
		return false;
	}

	public String fixName(String mobName){
		String ret=mobName.toLowerCase();
		
		//now change all spaces to _
		ret=ret.replace(' ', '_');
		
		return ret;
	}
	
	@Override
	public void demorph(EntityLiving mob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void demorphPotion(EntityLiving mob) {
		IMorphingMOB capability=MorphingMOBProvider.get(mob);
		//turn back into original
		String morphString=capability.getOriginalEntity().getString("Name");
		int age=capability.getOriginalEntity().getInteger("Age");
		EntityLiving e=(EntityLiving)EntityList.createEntityByIDFromName(new ResourceLocation(morphString), mob.world);
		float health=mob.getHealth();
		if(e!=null){
			e.setPositionAndRotation(mob.posX,mob.posY,mob.posZ,
				mob.rotationYaw, mob.rotationPitch);//may need to reverse pitch and yaw
			e.setHealth(health);
			mob.world.spawnEntity(e);
			//get capabilities of old mob to see if already morphed
			//IMorphingMOB cap_old=MorphingMOB.get(mob);
			IMorphingMOB cap_new=MorphingMOBProvider.get(e);
			if(this.isMorphed()){
				cap_new.setOriginalEntity(original);
				cap_new.setMorphed(false);
			}
			
			mob.world.playEvent( 2006, mob.getPosition(), 10);
			mob.world.playEvent(2006, mob.getPosition().up(), 10);
			//cap_new.setDuration(duration);
			//cap_new.setDuration(200);
			cap_new.setMorphed(false);
			
			//get capabilities of new mob
			
			mob.setDead();//remove original entity
		}
		
	}
	
	

	@Override
	public NBTTagCompound getOriginalEntity() {

		return original;
	}

	@Override
	public void setOriginalEntity(NBTTagCompound origin) {
		this.original=origin;
		
	}

	@Override
	public boolean isReadyDemorph() {

		return this.readyDemorph;
	}

	@Override
	public void setReadyDemorph(boolean d) {
		this.readyDemorph=d;
		
	}

	@Override
	public void setPermanent(boolean perm) {
		this.permanent=perm;
		
	}
}
