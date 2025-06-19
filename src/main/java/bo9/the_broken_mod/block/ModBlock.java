package bo9.the_broken_mod.block;

import bo9.the_broken_mod.TheBrokenMod;
import bo9.the_broken_mod.block.modded.Computer_Decoder;
import bo9.the_broken_mod.block.modded.Rift_Block;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlock {

    public static final Block RIFT_BLOCK = registerBlock("rift_block",
            new Rift_Block(AbstractBlock.Settings.create()
                    .strength(100f).luminance(blockState -> blockState.get(Rift_Block.ACTVATED) ? 15:0 )));
    //public static final Block COMPUTER_DECODER = registerBlock("computer_decoder",
    //        new Computer_Decoder(AbstractBlock.Settings.create()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TheBrokenMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TheBrokenMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }



    public static void registerModBlocks()
    {

    }
}
