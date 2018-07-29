package gamecycles.morphpotion.init;

import gamecycles.morphpotion.entity.ai.EntityAIAttackRangedMorph;
import mchorse.metamorph.api.MorphAPI;
import mchorse.metamorph.api.MorphList;
import mchorse.metamorph.api.MorphManager;
import mchorse.metamorph.api.events.SpawnGhostEvent;
import mchorse.metamorph.capabilities.morphing.IMorphing;
import mchorse.metamorph.capabilities.morphing.Morphing;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.inventory.Slot;
import net.minecraft.item.*;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ModMetaMorph {

	public static String [] morphs_with_hands={"minecraft:witch","minecraft:wither_skeleton","minecraft:husk","minecraft:enderman","minecraft:vindication_illager","minecraft:evocation_illager","minecraft:vex","minecraft:skeleton","minecraft:zombie_pigman",
	"minecraft:illusion_illager","minecraft:villager","minecraft:stray","minecraft:zombie_villager"};

//	@SubscribeEvent
//	public  void onWorldLoad(WorldEvent.Load event){
//		System.out.println("world load event, fix morphs");
//		initMetamorph(event.getWorld());
//	}

	@SubscribeEvent
	public  void onPlayerTick(TickEvent.PlayerTickEvent event){
		//if(event.player.world.isRemote) return;
		if(event.phase== TickEvent.Phase.END) {

			IMorphing iMorphing = Morphing.get(event.player);
			if (iMorphing != null) {
				if (iMorphing.isMorphed()) {

					if (!hasHands(iMorphing.getCurrentMorph().name)) {
//						System.out.println("Current morph does not have hands, need to drop equipment");
						if(!event.player.world.isRemote) {
							for (int i = 0; i < event.player.inventory.armorInventory.size(); i++) {
								ItemStack stack = event.player.inventory.armorItemInSlot(i);
								if (!event.player.inventory.addItemStackToInventory(stack)) {
									//drop the item
									event.player.entityDropItem(stack, 0.5F);

								}
								event.player.inventory.armorInventory.set(i, ItemStack.EMPTY);
							}

							//now deal with any shields
							ItemStack shieldStack = event.player.inventory.offHandInventory.get(0);
							if (shieldStack != ItemStack.EMPTY) {
								if (!event.player.inventory.addItemStackToInventory(shieldStack)) {
									event.player.entityDropItem(shieldStack, 0.5F);
								}
							}
						}
						//now deal with weapons
						ItemStack weaponStack=event.player.inventory.getStackInSlot(event.player.inventory.currentItem);
						Item weaponItem=weaponStack.getItem();
						if(weaponItem instanceof ItemSword||weaponItem instanceof ItemBow||weaponItem instanceof ItemShield){
							if(event.player.world.isRemote){
								event.player.inventory.changeCurrentItem(1);
							}
						}
					}
				}
			}
		}
	}

//	public  void initMetamorph(World world){
//		MorphList morphList= MorphManager.INSTANCE.getMorphs(world);
//
//		for (Map.Entry<String, List<MorphList.MorphCell>> entry:morphList.morphs.entrySet() ) {
////			System.out.println("found morph:"+entry.getKey());
//			List<MorphList.MorphCell> morphCellList=entry.getValue();
//			boolean hands=false;
//			if(hasHands(entry.getKey())){
//				hands=true;
//			}
//			if(morphCellList!=null){
//				for (int i = 0; i < morphCellList.size(); i++) {
//					System.out.println("morph:"+entry.getKey()+", setting hands:"+hands);
//					morphCellList.get(i).morph.settings.hands=hands;
//				}
//			}
//		}
//
//	}

	public boolean hasHands(String name){
		for (String check:morphs_with_hands) {
			if(check.equalsIgnoreCase(name)){
				return true;
			}

		}

		return false;
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event){

		if(!event.getWorld().isRemote) {
			if (event.getEntity() instanceof EntityWitch) {
				EntityWitch witch = (EntityWitch) event.getEntity();

				Iterator<EntityAITasks.EntityAITaskEntry> iterator = witch.tasks.taskEntries.iterator();
				while (iterator.hasNext()) {
					EntityAITasks.EntityAITaskEntry entityaitasks$entityaitaskentry = iterator.next();
					EntityAIBase entityaibase = entityaitasks$entityaitaskentry.action;
					if (entityaibase instanceof EntityAIAttackRanged) {
						if (entityaitasks$entityaitaskentry.using) {
							entityaitasks$entityaitaskentry.using = false;
							entityaitasks$entityaitaskentry.action.resetTask();
							//witch.tasks.executingTaskEntries.remove(entityaitasks$entityaitaskentry);
						}

						iterator.remove();
//						System.out.println("Ranged attack removed");
						break;//return;
					}
				}
				//witch.tasks.removeTask(new EntityAIAttackRanged(witch, 1.0D, 60, 10.0F));
				//EntityAITasks.EntityAITaskEntry entityAITaskEntry=new witch.tasks.EntityAITaskEntry(2,new EntityAIAttackRangedMorph(witch,1,20,60,10));
				witch.tasks.addTask(2, new EntityAIAttackRangedMorph(witch, 1.0D, 20, 60, 10.0F));
//				System.out.println("Injecting morph ranged attack");
			}
		}
	}

	@SubscribeEvent
	public void onSpawnGhost(SpawnGhostEvent.Pre event){
		event.setCanceled(true);
	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event){

		if(!event.player.world.isRemote) {
//			System.out.println("Player respawn. ");
			IMorphing iMorphing = Morphing.get(event.player);
			if (iMorphing != null) {
				if (iMorphing.isMorphed()) {
//					System.out.println("Player is morphed, despawn");
					MorphAPI.demorph(event.player);

				}
			}
		}
	}

}
