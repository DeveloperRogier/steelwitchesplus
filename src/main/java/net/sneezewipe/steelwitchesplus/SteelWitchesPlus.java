package net.sneezewipe.steelwitchesplus;

import net.fabricmc.api.ModInitializer;
import net.sneezewipe.steelwitchesplus.item.ModItemGroups;
import net.sneezewipe.steelwitchesplus.item.ModItems;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SteelWitchesPlus implements ModInitializer {
	public static final String MOD_ID = "steelwitchesplus";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info(String.format("Initializing %s", MOD_ID));
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}