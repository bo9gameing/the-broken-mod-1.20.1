package bo9.the_broken_mod.item;

import bo9.the_broken_mod.TheBrokenMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModItems {

    public  static final Item TEST_ITEM = registerItem("test_item", new Item(new FabricItemSettings()));
    public  static final Item RIFT_ITEM = registerItem("rift_item", new Item(new FabricItemSettings()));
    public  static final Item CORUPEM_INGIT = registerItem("corupem_ingit", new Item(new FabricItemSettings()));
    public  static final Item CORUPEM_NUGET = registerItem("corupem_nuget", new Item(new FabricItemSettings()));
    public  static final Item RAW_COPPER_INFESTED = registerItem("raw_copper_infested", new Item(new FabricItemSettings()));
    public  static final Item RAW_IRON_INFESTED = registerItem("raw_iron_infested", new Item(new FabricItemSettings()));
    public  static final Item RAW_GOLD_INFESTED = registerItem("raw_gold_infested", new Item(new FabricItemSettings()));
    public  static final Item REDSTONE_INFESTED = registerItem("redstone_infested", new Item(new FabricItemSettings()));
    public  static final Item DIAMOND_INFESTED = registerItem("diamond_infested", new Item(new FabricItemSettings()));






    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TheBrokenMod.MOD_ID, name), item);
    }

    public static void registerModItems(){

    }
}
