package gamecycles.morphpotion.proxy;

import gamecycles.morphpotion.init.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		
		super.preInit(event);
		
		ModItems.initModels();
		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
		super.init(event);
	}

}
