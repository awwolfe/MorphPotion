package gamecycles.morphpotion.entity.ai;

import gamecycles.morphpotion.capabilities.IMorphingMOB;
import gamecycles.morphpotion.capabilities.MorphingMOB;
import gamecycles.morphpotion.capabilities.MorphingMOBProvider;
import gamecycles.morphpotion.init.ModPotions;
import mchorse.metamorph.capabilities.morphing.IMorphing;
import mchorse.metamorph.capabilities.morphing.Morphing;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIAttackRanged;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.math.MathHelper;

public class EntityAIAttackRangedMorph extends EntityAIBase {

	/** The entity the AI instance has been applied to */
	private final EntityLiving entityHost;
	/** The entity (as a RangedAttackMob) the AI instance has been applied to. */
	private final IRangedAttackMob rangedAttackEntityHost;
	private EntityLivingBase attackTarget;
	/**
	 * A decrementing tick that spawns a ranged attack once this value reaches 0. It is then set back to the
	 * maxRangedAttackTime.
	 */
	private int rangedAttackTime;
	private final double entityMoveSpeed;
	private int seeTime;
	private final int attackIntervalMin;
	/** The maximum time the AI has to wait before peforming another ranged attack. */
	private final int maxRangedAttackTime;
	private final float attackRadius;
	private final float maxAttackDistance;

	public EntityAIAttackRangedMorph(IRangedAttackMob attacker, double movespeed, int attackInterval,int maxAttackTime, float maxAttackDistanceIn) {


		this.rangedAttackTime = -1;

		if (!(attacker instanceof EntityLivingBase))
		{
			throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
		}
		else
		{
			this.rangedAttackEntityHost = attacker;
			this.entityHost = (EntityLiving)attacker;
			this.entityMoveSpeed = movespeed;
			this.attackIntervalMin = attackInterval;
			this.maxRangedAttackTime = maxAttackTime;
			this.attackRadius = maxAttackDistanceIn;
			this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
			this.setMutexBits(3);
		}
	}


	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
//		System.out.println("should execute");
		EntityLivingBase entitylivingbase = this.entityHost.getAttackTarget();

		if (entitylivingbase == null)
		{
			return false;
		}
		else
		{
			this.attackTarget = entitylivingbase;
			return true;
		}
	}

	/**
	 * Returns whether an in-progress EntityAIBase should continue executing
	 */
	public boolean shouldContinueExecuting()
	{
		return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
	}

	/**
	 * Reset the task's internal state. Called when this task is interrupted by another one
	 */
	public void resetTask()
	{
		this.attackTarget = null;
		this.seeTime = 0;
		this.rangedAttackTime = -1;
	}

	/**
	 * Keep ticking a continuous task that has already been started
	 */
	@Override
	public void updateTask()
	{
		double d0 = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.getEntityBoundingBox().minY, this.attackTarget.posZ);
		boolean flag = this.entityHost.getEntitySenses().canSee(this.attackTarget);

		if (flag)
		{
			++this.seeTime;
		}
		else
		{
			this.seeTime = 0;
		}

		if (d0 <= (double)this.maxAttackDistance && this.seeTime >= 20)
		{
			this.entityHost.getNavigator().clearPath();
		}
		else
		{
			this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
		}

		this.entityHost.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0F, 30.0F);

		if (--this.rangedAttackTime == 0)
		{
			if (!flag)
			{
				return;
			}

			float f = MathHelper.sqrt(d0) / this.attackRadius;
			float lvt_5_1_ = MathHelper.clamp(f, 0.1F, 1.0F);
			this.attackEntityWithRangedAttack(this.attackTarget, lvt_5_1_);
			this.rangedAttackTime = MathHelper.floor(f * (float)(this.maxRangedAttackTime - this.attackIntervalMin) + (float)this.attackIntervalMin);
		}
		else if (this.rangedAttackTime < 0)
		{
			float f2 = MathHelper.sqrt(d0) / this.attackRadius;
			this.rangedAttackTime = MathHelper.floor(f2 * (float)(this.maxRangedAttackTime - this.attackIntervalMin) + (float)this.attackIntervalMin);
		}
	}


	/**
	 * Attack the specified entity using a ranged attack.
	 */
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor)
	{
		System.out.println("doing morph ranged attack");
//		if (!entityHost.isDrinkingPotion())
//		{
			double d0 = target.posY + (double)target.getEyeHeight() - 1.100000023841858D;
			double d1 = target.posX + target.motionX - entityHost.posX;
			double d2 = d0 - entityHost.posY;
			double d3 = target.posZ + target.motionZ - entityHost.posZ;
			float f = MathHelper.sqrt(d1 * d1 + d3 * d3);
			PotionType potiontype = ModPotions.transform_chicken_type;

			boolean use_morph=true;
			if(target instanceof EntityPlayer){
				System.out.println("is player");
				IMorphing iMorphing= Morphing.get((EntityPlayer)target);
				if(iMorphing!=null){
					if(iMorphing.isMorphed())
					{
						System.out.println("is morphed:"+iMorphing.getCurrentMorph().name);
						if(iMorphing.getCurrentMorph().name.equalsIgnoreCase("minecraft:chicken")){
							System.out.println("is chicken, do not throw another morph potion");
							use_morph=false;
						}
					}
				}
			}else{
				IMorphingMOB iMorphingMOB= MorphingMOBProvider.get((EntityLiving) target);
				if(iMorphingMOB!=null){
					if(iMorphingMOB.isMorphed()){
						if(target.getName().equalsIgnoreCase("minecraft:chicken"))
						{
							use_morph=false;
						}
					}
				}
			}


			if(!use_morph) {
				System.out.println("not using morph potion, normal attack");

				potiontype = PotionTypes.HARMING;

	            if (f >= 8.0F && !target.isPotionActive(MobEffects.SLOWNESS))
	            {
	                potiontype = PotionTypes.SLOWNESS;
	            }
	            else if (target.getHealth() >= 8.0F && !target.isPotionActive(MobEffects.POISON))
	            {
	                potiontype = PotionTypes.POISON;
	            }
	            else if (f <= 3.0F && !target.isPotionActive(MobEffects.WEAKNESS) && entityHost.world.rand.nextFloat() < 0.25F)
	            {
	                potiontype = PotionTypes.WEAKNESS;
	            }
			}
			EntityPotion entitypotion = new EntityPotion(entityHost.world, entityHost, PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potiontype));
			entitypotion.rotationPitch -= -20.0F;
			entitypotion.shoot(d1, d2 + (double)(f * 0.2F), d3, 0.75F, 8.0F);
			entityHost.world.playSound((EntityPlayer)null, entityHost.posX, entityHost.posY, entityHost.posZ, SoundEvents.ENTITY_WITCH_THROW, entityHost.getSoundCategory(), 1.0F, 0.8F + entityHost.world.rand.nextFloat() * 0.4F);
			entityHost.world.spawnEntity(entitypotion);
//		}
	}
}
