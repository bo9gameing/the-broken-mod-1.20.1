package bo9.the_broken_mod.datagen;


import bo9.the_broken_mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter){

        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.CORUPEM_NUGET, RecipeCategory.MISC, ModItems.CORUPEM_INGIT);

    }
}
