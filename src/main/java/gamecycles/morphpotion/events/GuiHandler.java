package gamecycles.morphpotion.events;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//thanks mchorse for suggesting simply canceling the gui, instead of changing config in metamorph

public class GuiHandler {
	 @SubscribeEvent
	    public void onGuiOpen(GuiOpenEvent event)
	    {
	        GuiScreen gui = event.getGui();
	        
	        if (gui != null && gui.getClass().getName().startsWith("mchorse.metamorph.client.gui"))
	        {
	            event.setCanceled(true);
	        }
	    }
}
