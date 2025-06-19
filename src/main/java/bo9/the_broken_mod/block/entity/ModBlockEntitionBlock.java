package bo9.the_broken_mod.block.entity;

import bo9.the_broken_mod.TheBrokenMod;
import bo9.the_broken_mod.block.ModBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntitionBlock {
    public static final BlockEntityType<Computer_Decoder_Entity> COMPUTER_DECODER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(TheBrokenMod.MOD_ID,"computer_decoder_be"),
                 FabricBlockEntityTypeBuilder.create(Computer_Decoder_Entity::new,
                        ModBlock.COMPUTER_DECODER).build());



    public static void registerBlockEnitity(){

    }
}
