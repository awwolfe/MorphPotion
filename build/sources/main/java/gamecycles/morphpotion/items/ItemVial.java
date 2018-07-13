package gamecycles.morphpotion.items;


import gamecycles.morphpotion.init.ModItems;
import mchorse.metamorph.Metamorph;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class ItemVial extends ModItem{

	public ItemVial(String name) {
		super(name);
		setHasSubtypes(true);
		this.setMaxStackSize(1);
		
	}

	@Override
	public boolean showDurabilityBar(ItemStack stack){
		return false;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack){
		return EnumAction.DRINK;
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.setActiveHand(handIn);
        return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

	
	@Override
	public int getMaxItemUseDuration(ItemStack stack){
		return 32;
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn,
			EntityLivingBase entityLiving) {
		//empty vial
		if(stack.getMetadata()==0){
			
			//play sound
			//reduce health
			if(entityLiving instanceof EntityPlayer){
				EntityPlayer player=(EntityPlayer) entityLiving;
				float health=player.getHealth();
				if(health==player.getMaxHealth()){
					player.setHealth(0.5F);
					//turn into full vial
					return new ItemStack(ModItems.itemVial,1,1);
				}
				
			}
			
			
			
		}
		else{
			//already full, give some health and turn into empty
			if(entityLiving instanceof EntityPlayer){
				EntityPlayer player=(EntityPlayer) entityLiving;
				float health=player.getHealth();
				if(health<player.getMaxHealth()-2){
					player.setHealth(health+2F);
				}
				else{
					player.setHealth(player.getMaxHealth());
				}
				
			}
			
			
		}
		return new ItemStack(ModItems.itemVial,1,0);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		
		if(this.isInCreativeTab(tab)){
			items.add(new ItemStack(this,1,0));
			items.add(new ItemStack(this,1,1));
		}
		
		
	}
	@Override
	public int getMetadata(int metadata){
		return metadata;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack){
		if(stack.getMetadata()==1){
			return super.getUnlocalizedName()+"_full";
		}

		
		return super.getUnlocalizedName()+"_empty";
	}

//	
	
	
}
