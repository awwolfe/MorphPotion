package gamecycles.morphpotion.potion;


import gamecycles.morphpotion.MorphPotionMod;
import gamecycles.morphpotion.util.Vec2i;
import mchorse.metamorph.Metamorph;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetamorphPotion extends Potion{
	
	 protected static final ResourceLocation POTIONS_LOCATION = new ResourceLocation(MorphPotionMod.modId,"textures/gui/morph_potion_nfx.png");
	private Vec2i icon_index;
	protected MetamorphPotion(boolean isBadEffectIn, int liquidColorIn,int x, int y) {
		super(isBadEffectIn, liquidColorIn);
		this.setIconIndex(x, y);
		this.icon_index=new Vec2i(x,y);
	}
	 @Override
	    @SideOnly(Side.CLIENT)
	    public boolean hasStatusIcon()
	    {
	        Minecraft.getMinecraft().getTextureManager().bindTexture(POTIONS_LOCATION);
	        //return super.hasStatusIcon();
	        return false; //do not draw the minecraft potion textures
	    }
	 
	 
	
	public Vec2i getIconIndex(){
		 return icon_index;
	 }

}
