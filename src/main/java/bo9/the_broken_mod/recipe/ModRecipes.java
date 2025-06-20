package bo9.the_broken_mod.recipe;

import bo9.the_broken_mod.TheBrokenMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registries.RECIPE_SERIALIZER,new Identifier(TheBrokenMod.MOD_ID, Computer_decoder_Recipes.Serializer.ID),
                Computer_decoder_Recipes.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE,new Identifier(TheBrokenMod.MOD_ID, Computer_decoder_Recipes.Type.ID),
                Computer_decoder_Recipes.Type.INSTANCE);
    }
}
