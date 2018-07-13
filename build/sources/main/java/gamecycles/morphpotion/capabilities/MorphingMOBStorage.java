package gamecycles.morphpotion.capabilities;


import net.minecraft.entity.EntityAgeable;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class MorphingMOBStorage implements IStorage<IMorphingMOB> {

	@Override
	public NBTBase writeNBT(Capability<IMorphingMOB> capability,
			IMorphingMOB instance, EnumFacing side) {
		
		NBTTagCompound tag = new NBTTagCompound();
       

        if (instance.isMorphed())
        {
            NBTTagCompound morph = new NBTTagCompound();
            morph=instance.getOriginalEntity();//.getEntityData(); //.getCurrentMorph().toNBT(morph);
            tag.setBoolean("morphed", instance.isMorphed());
            tag.setInteger("duration", instance.getDuration());
            tag.setBoolean("ready", instance.isReadyDemorph());
            tag.setBoolean("permanent", instance.isPermanent());
            tag.setTag("Name", morph);
           
        }

      

       
        

        return tag;
		
	}

	@Override
	public void readNBT(Capability<IMorphingMOB> capability,
			IMorphingMOB instance, EnumFacing side, NBTBase nbt) {
		 
		if (nbt instanceof NBTTagCompound)
	        {
	            NBTTagCompound tag = (NBTTagCompound) nbt;
	           
	            NBTTagCompound morphTag = tag.getCompoundTag("Name");

	            if (!tag.hasNoTags())
	            {
	            	
	                instance.setCurrentMorph(morphTag, null, true);
	            }
	            instance.setDuration(tag.getInteger("duration"));
	            instance.setReadyDemorph(tag.getBoolean("ready"));
	            instance.setPermanent(tag.getBoolean("permanent"));
	            instance.setMorphed(tag.getBoolean("morphed"));
	            instance.setOriginalEntity(tag.getCompoundTag("Name"));
	            

	            
	        }
		
	}


}
