package bo9.the_broken_mod.datagen;

import bo9.the_broken_mod.block.ModBlock;
import bo9.the_broken_mod.block.modded.Rift_Block;
import bo9.the_broken_mod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleState();

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    itemModelGenerator.register(ModItems.TEST_ITEM, Models.GENERATED);
    itemModelGenerator.register(ModItems.RIFT_ITEM, Models.GENERATED);
    itemModelGenerator.register(ModItems.CORUPEM_INGIT, Models.GENERATED);
    itemModelGenerator.register(ModItems.CORUPEM_NUGET, Models.GENERATED);
    itemModelGenerator.register(ModItems.DIAMOND_INFESTED, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_COPPER_INFESTED, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_GOLD_INFESTED, Models.GENERATED);
    itemModelGenerator.register(ModItems.RAW_IRON_INFESTED, Models.GENERATED);
    itemModelGenerator.register(ModItems.REDSTONE_INFESTED, Models.GENERATED);
    }
}
