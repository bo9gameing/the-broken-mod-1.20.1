package bo9.the_broken_mod;

import bo9.the_broken_mod.block.ModBlock;
import bo9.the_broken_mod.block.entity.ModBlockEntitionBlock;
import bo9.the_broken_mod.item.ModItemGroups;
import bo9.the_broken_mod.item.ModItems;
import bo9.the_broken_mod.screen.ModScreenhandlers;
import bo9.the_broken_mod.tools.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheBrokenMod implements ModInitializer {
	public static final String MOD_ID = "the-broken-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
		ModBlock.registerModBlocks();
		ModItemGroups.registerItemGroup();


		ModBlockEntitionBlock.registerBlockEnitity();

		ModScreenhandlers.registerScreenHandlers();

		ModLootTableModifiers.modLootTables();
	}
}