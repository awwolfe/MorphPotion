package gamecycles.morphpotion.potion;

import net.minecraft.entity.EntityLivingBase;

public class PotionFreezeResistance extends MetamorphPotion{

	public PotionFreezeResistance(int id) {
		super(false, 10, 2,1);
		
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int p_76394_2_) {
		// TODO Auto-generated method stub
		super.performEffect(entityLivingBaseIn, p_76394_2_);
		
		//System.out.println("Potion freeze, perform effect");
	}

}
