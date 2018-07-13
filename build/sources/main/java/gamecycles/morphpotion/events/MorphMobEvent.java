package gamecycles.morphpotion.events;

import mchorse.metamorph.api.events.MorphEvent;
import mchorse.metamorph.api.morphs.AbstractMorph;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

public abstract class MorphMobEvent extends Event{
	public EntityLiving entity;
	public String morph;
	public boolean force;
	
	public MorphMobEvent(EntityLiving entity,String morph,boolean force){
		this.entity=entity;
		this.morph=morph;
		this.force=force;
	}
	 /**
     * Whether given player is about to demorph
     */
    public boolean isDemorphing()
    {
        return this.morph == null;
    }

    /**
     * Fires before entity morphs. This event is {@link Cancelable}.
     * 
     * to be used for any magic resistance mobs or effects 
     */
    @Cancelable
    public static class Pre extends MorphMobEvent
    {
        public Pre(EntityLiving entity, String morph, boolean force)
        {
            super(entity, morph, force);
        }
    }

    /**
     * Fires after a entity successfully morphed
     * 
     * will not kill entity if cancelled....end up with morph creating new, but old one still existing 
     */
    public static class Post extends MorphMobEvent
    {
        public Post(EntityLiving entity, String old_mob, boolean force)
        {
            super(entity, old_mob, force);
        }
    }

}
