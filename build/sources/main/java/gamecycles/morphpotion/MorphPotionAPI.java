package gamecycles.morphpotion;

import mchorse.metamorph.api.events.MorphEvent;
import mchorse.metamorph.api.morphs.AbstractMorph;
import mchorse.metamorph.capabilities.morphing.IMorphing;
import mchorse.metamorph.capabilities.morphing.Morphing;
import mchorse.metamorph.network.Dispatcher;
import mchorse.metamorph.network.common.PacketMorph;
import mchorse.metamorph.network.common.PacketMorphPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;

public class MorphPotionAPI {
	//gamecycles
    /**
     * Morph a player into given morph with given force flag. 
     * 
     * @return true, if player was morphed successfully
     */
    public static boolean morphPotion(EntityPlayer player, AbstractMorph morph, int duration)
    {
        IMorphing morphing = Morphing.get(player);

        if (morphing == null)
        {
            return false;
        }

        MorphEvent event = new MorphEvent.Pre(player, morph, true);

        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        
        
        boolean morphed = morphing.setCurrentMorph(event.morph, player, true);

        if (!player.world.isRemote && morphed)
        {
            Dispatcher.sendTo(new PacketMorph(morph), (EntityPlayerMP) player);
            Dispatcher.updateTrackers(player, new PacketMorphPlayer(player.getEntityId(), morph));
        }

        return morphed;
    }
    ///////
}
