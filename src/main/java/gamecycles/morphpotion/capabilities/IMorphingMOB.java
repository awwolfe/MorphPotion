package gamecycles.morphpotion.capabilities;


import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;

public interface IMorphingMOB {
	public int getDuration();
	public void setDuration(int duration);
	public boolean isPermanent();
	public boolean isReadyDemorph();
	public void setReadyDemorph(boolean d);
	public NBTTagCompound getOriginalEntity();
	public void setOriginalEntity(NBTTagCompound origin);
	
	 public boolean isMorphed();
	 /**
	     * Copy data from other morph 
	     */
	    public void copy(IMorphingMOB morphing, EntityLiving mob);
	    
	    public boolean setCurrentMorph(NBTTagCompound tag, EntityLiving mob, boolean force);
	    
	    /**
	     * Set current morph
	     */
	    public boolean setCurrentMorphPotion(NBTTagCompound tag, EntityLiving mob, int duration);

	    /**
	     * Demorph this capability 
	     */
	    public void demorph(EntityLiving mob);

	    public void demorphPotion(EntityLiving mob);
	    
	    public void setMorphed(boolean morphed);
		public void setPermanent(boolean boolean1);
}
