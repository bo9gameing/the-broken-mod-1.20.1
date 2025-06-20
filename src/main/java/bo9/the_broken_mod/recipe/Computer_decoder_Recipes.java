package bo9.the_broken_mod.recipe;

import com.google.gson.JsonObject;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import java.util.List;

public class Computer_decoder_Recipes implements Recipe<SimpleInventory> {

    private final ItemStack output;

    private final List<Ingredient> recipeItems;

    public Computer_decoder_Recipes(List<Ingredient> ingredients, ItemStack itemStack){
        this.output = itemStack;
        this.recipeItems = ingredients;
    }




    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if(world.isClient()){
            return false;
        }
        return recipeItems.get(0).test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(SimpleInventory inventory, DynamicRegistryManager registryManager) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return output;
    }


    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.ofSize(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }




    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<Computer_decoder_Recipes> {
        public static Type INSTANCE = new Type();
        public static String ID = "computer_decoding";
    }

    public static class Serializer implements RecipeSerializer<Computer_decoder_Recipes> {
        public static Serializer INSTANCE = new Serializer();
        public static String ID = "computer_decoding";

        public static final Codec<Computer_decoder_Recipes> CODEC = RecordCodecBuilder.create(in -> in.group(
                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients").forGetter(Computer_decoder_Recipes::getIngredients),
                RecipeCodecs.CRAFTING_RESULT.fieldOf("output").forGetter(r -> r.output)
        ).apply(in, Computer_decoder_Recipes::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return Codecs.validate(Codecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }

        @Override
        public Codec<Computer_decoder_Recipes> codec() {
            return CODEC;
        }

        @Override
        public Computer_decoder_Recipes read(PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(), Ingredient.EMPTY);

            for(int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromPacket(buf));
            }


            ItemStack output = buf.readItemStack();

            return new Computer_decoder_Recipes(inputs, output);
        }


        @Override
        public void write(PacketByteBuf buf, Computer_decoder_Recipes recipe) {
            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buf);
            }

            buf.writeItemStack(recipe.getResult(null));

        }
    }
}
