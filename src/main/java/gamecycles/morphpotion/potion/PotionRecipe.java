package gamecycles.morphpotion.potion;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.brewing.IBrewingRecipe;

public class PotionRecipe implements IBrewingRecipe{
	private ItemStack input;
	private ItemStack ingredient;
	private ItemStack output;
	
	public PotionRecipe(ItemStack input, ItemStack ingredient, ItemStack output) {
		this.input = input;
		this.ingredient = ingredient;
		this.output = output;
	}
	@Override
	public boolean isInput(ItemStack input) {
		if(input.getItem()==this.input.getItem()){
			//also check the meta
//			System.out.println("items match");
			if(input.getMetadata()==this.input.getMetadata()){
//				System.out.println("metas match");
				NBTTagCompound tag=input.getTagCompound();
				if(tag!=null){
					String potion=tag.getString("Potion");
					NBTTagCompound tag2=this.input.getTagCompound();
					String potion2=tag2.getString("Potion");
					if(potion.equalsIgnoreCase(potion2)){
//						System.out.println("potion types match");
						return true;
					}
				}
				
			}
		}
		return false;
	}

	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return this.ingredient.isItemEqual(ingredient);
		
	}

	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if(input!=null&&ingredient!=null&&isInput(input)&&isIngredient(ingredient)){
			return output.copy();
		}
		
		return ItemStack.EMPTY;
	}

}
