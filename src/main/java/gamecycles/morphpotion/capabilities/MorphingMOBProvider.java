package gamecycles.morphpotion.capabilities;


import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class MorphingMOBProvider  implements ICapabilitySerializable<NBTBase> {

	 @CapabilityInject(IMorphingMOB.class)
	    public static final Capability<IMorphingMOB> MORPHING_MOB_CAP = null;

	    private IMorphingMOB instance = MORPHING_MOB_CAP.getDefaultInstance();
	    
	    
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

		return capability==MORPHING_MOB_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

		return capability==MORPHING_MOB_CAP ?MORPHING_MOB_CAP.<T> cast (this.instance) :null;
	}

	@Override
	public NBTBase serializeNBT() {

		return MORPHING_MOB_CAP.getStorage().writeNBT(MORPHING_MOB_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		MORPHING_MOB_CAP.getStorage().readNBT(MORPHING_MOB_CAP, this.instance, null, nbt);
		
	}
	
	public static IMorphingMOB get(EntityLiving e){
		
				
	        return e.getCapability(MORPHING_MOB_CAP, null);
	    
	}

}
