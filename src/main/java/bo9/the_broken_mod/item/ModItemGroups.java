package bo9.the_broken_mod.item;

import bo9.the_broken_mod.TheBrokenMod;
import bo9.the_broken_mod.block.ModBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup MAIN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TheBrokenMod.MOD_ID, "main"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.main"))
                    .icon(()-> new ItemStack(ModItems.RIFT_ITEM)).entries(((displayContext, entries) -> {
                        entries.add(ModItems.TEST_ITEM);
                        entries.add(ModItems.RAW_IRON_INFESTED);
                        entries.add(ModItems.RAW_COPPER_INFESTED);
                        entries.add(ModItems.RAW_GOLD_INFESTED);
                        entries.add(ModItems.DIAMOND_INFESTED);
                        entries.add(ModItems.REDSTONE_INFESTED);
                        entries.add(ModItems.CORUPEM_INGIT);
                        entries.add(ModItems.CORUPEM_NUGET);





                        entries.add(ModBlock.RIFT_BLOCK);
                        entries.add(ModBlock.COMPUTER_DECODER);
                    })).build());


    public static void registerItemGroup(){

    }
}
