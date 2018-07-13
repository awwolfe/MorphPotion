package gamecycles.morphpotion;

import net.minecraftforge.common.config.Config;

@Config(modid=MorphPotionMod.modId)
@Config.LangKey("morphpotion.config.title")
public class MorphPotionConfig {
	@Config.Comment("Determines if potions can affect Mobs")
	@Config.Name("Allow Mob Potion Morphing")
	public static boolean allow_mob_morph=true;
}
