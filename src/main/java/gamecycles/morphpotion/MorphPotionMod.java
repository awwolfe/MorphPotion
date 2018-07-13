package gamecycles.morphpotion;

import gamecycles.morphpotion.init.TabMorphPotion;
import gamecycles.morphpotion.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;


@Mod(modid = MorphPotionMod.modId, name=MorphPotionMod.name, version=MorphPotionMod.version,dependencies=MorphPotionMod.DEPENDENCIES)
public class MorphPotionMod {





	
	@SidedProxy(serverSide="gamecyles.morphpotion.proxy.CommonProxy",clientSide="gamecycles.morphpotion.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	public static final String modId ="morphpotion";
	public static final String name="Morph Potion Mod";
	public static final String version ="1.12.2.1";
	public static final String DEPENDENCIES="after:metamorph";
	
	@Mod.Instance(modId)
	public static MorphPotionMod instance;
	
	public static final TabMorphPotion tabMorphPotion=new TabMorphPotion(modId);
	
	
	
	 @EventHandler
	 public void preInit(FMLPreInitializationEvent event){
		
	    	proxy.preInit(event);
	    
	    	
	    }
	 
	 @EventHandler
	 public void init(FMLInitializationEvent event){
		 proxy.init(event);
		 
		 
		
	 }
	 
	 @Mod.EventHandler
		public void serverLoad(FMLServerStartingEvent event){
		
		 
	 }
	 


}
