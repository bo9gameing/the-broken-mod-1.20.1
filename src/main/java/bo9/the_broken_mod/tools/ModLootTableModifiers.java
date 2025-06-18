package bo9.the_broken_mod.tools;

import bo9.the_broken_mod.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    public static final Identifier COPPER_ORE_ID = new Identifier("minecraft", "blocks/copper_ore");
    public static final Identifier DIAMOND_ORE_ID = new Identifier("minecraft", "blocks/diamond_ore");
    public static final Identifier GOLD_ORE_ID = new Identifier("minecraft", "blocks/gold_ore");
    public static final Identifier IRON_ORE_ID = new Identifier("minecraft", "blocks/iron_ore");
    public static final Identifier REDSTONE_ORE_ID = new Identifier("minecraft", "blocks/redstone_ore");





    public static void modLootTables(){
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tablebuilder, source) -> {
                if(COPPER_ORE_ID.equals(id)){
                    LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.5f))
                        .with(ItemEntry.builder(ModItems.RAW_COPPER_INFESTED))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 0.5f)).build());
                    tablebuilder.pool(poolBuilder.build());
                }
                if(IRON_ORE_ID.equals(id)){
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.5f))
                            .with(ItemEntry.builder(ModItems.RAW_IRON_INFESTED))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 0.5f)).build());
                    tablebuilder.pool(poolBuilder.build());
                }

                if(REDSTONE_ORE_ID.equals(id)){
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.5f))
                            .with(ItemEntry.builder(ModItems.REDSTONE_INFESTED))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 0.5f)).build());
                    tablebuilder.pool(poolBuilder.build());
                }

                if(GOLD_ORE_ID.equals(id)){
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.5f))
                            .with(ItemEntry.builder(ModItems.RAW_GOLD_INFESTED))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 0.5f)).build());
                    tablebuilder.pool(poolBuilder.build());
                }
                if(DIAMOND_ORE_ID.equals(id)){
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.5f))
                            .with(ItemEntry.builder(ModItems.DIAMOND_INFESTED))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 0.5f)).build());
                    tablebuilder.pool(poolBuilder.build());
                }
        }));

    }
}
