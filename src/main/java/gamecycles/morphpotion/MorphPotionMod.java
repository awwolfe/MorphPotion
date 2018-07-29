package gamecycles.morphpotion;

import gamecycles.morphpotion.init.ModMetaMorph;
import gamecycles.morphpotion.init.TabMorphPotion;
import gamecycles.morphpotion.proxy.CommonProxy;
import gamecycles.morphpotion.village.VillageTradeMagicMorphPotion1;
import gamecycles.morphpotion.village.VillageTradeMagicMorphPotion2;
import gamecycles.morphpotion.village.VillageTradeMagicMorphPotion3;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;


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
		 MinecraftForge.EVENT_BUS.register(new ModMetaMorph());
		 proxy.init(event);
		 
		 
		
	 }


	 @EventHandler
	 public void postInit(FMLPostInitializationEvent event){
		 //trying to add morph potions to a magic profession
		 VillagerRegistry.VillagerProfession vp= ForgeRegistries.VILLAGER_PROFESSIONS.getValue(new ResourceLocation("structuresmod:magic_profession"));
		 if(vp!=null){
			 System.out.println("found magic profession");
			 vp.getCareer(0).addTrade(1,new VillageTradeMagicMorphPotion1());
			 vp.getCareer(0).addTrade(2,new VillageTradeMagicMorphPotion2());
			 vp.getCareer(0).addTrade(3,new VillageTradeMagicMorphPotion3());
		 }
		 else{
			 System.out.println("could not find magic profession");
		 }
	 }
	 @Mod.EventHandler
		public void serverLoad(FMLServerStartingEvent event){
		
		 
	 }
	 


}
