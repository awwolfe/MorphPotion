package gamecycles.morphpotion.proxy;

import gamecycles.morphpotion.capabilities.IMorphingMOB;
import gamecycles.morphpotion.capabilities.MorphingMOB;
import gamecycles.morphpotion.capabilities.MorphingMOBStorage;
import gamecycles.morphpotion.events.GuiHandler;
import gamecycles.morphpotion.init.ModCrafting;
import gamecycles.morphpotion.init.ModItems;
import gamecycles.morphpotion.init.ModMetaMorph;
import gamecycles.morphpotion.init.ModPotions;

import gamecycles.morphpotion.village.VillageTradeMagicMorphPotion1;
import gamecycles.morphpotion.village.VillageTradeMagicMorphPotion2;
import gamecycles.morphpotion.village.VillageTradeMagicMorphPotion3;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		        
        ModItems.init();
        ModPotions.init();
        ModCrafting.init();

	}
	
	public void init(FMLInitializationEvent event) {
		 //gamecycles
        MinecraftForge.EVENT_BUS.register(new gamecycles.morphpotion.events.CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new gamecycles.morphpotion.events.EntityDropHandler());
        MinecraftForge.EVENT_BUS.register(new GuiHandler());


        CapabilityManager.INSTANCE.register(IMorphingMOB.class, new MorphingMOBStorage(), MorphingMOB.class);



	}
}
