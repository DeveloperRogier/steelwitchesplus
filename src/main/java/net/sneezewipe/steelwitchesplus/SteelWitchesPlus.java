package net.sneezewipe.steelwitchesplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.block.ModBlockEntityTypes;
import net.sneezewipe.steelwitchesplus.item.ModItemGroups;
import net.sneezewipe.steelwitchesplus.item.ModItems;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.potion.ModPotions;
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
		ModBlockEntityTypes.registerBlockEntityTypes();
		ModPotions.registerPotions();

		registerLootTableListener(EntityType.FROG, ModItems.FROG_TOE);
	}

	private void registerLootTableListener(EntityType entity, Item newDrop) {
		LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
			if (lootTableSource.isBuiltin() && registryKey.equals(entity.getLootTableId())) {
				LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(newDrop));
				builder.pool(poolBuilder);
			}
		}));
	}
}