package gamecycles.morphpotion.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMorphPotion extends CreativeTabs{

	public TabMorphPotion( String label) {
		super( label);
		
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.itemVial);
	}

}
