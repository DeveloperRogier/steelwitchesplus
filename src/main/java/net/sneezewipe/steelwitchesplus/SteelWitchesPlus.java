package net.sneezewipe.steelwitchesplus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.potion.Potions;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.sneezewipe.steelwitchesplus.block.ModBlockEntityTypes;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.datagen.ModCompostableProvider;
import net.sneezewipe.steelwitchesplus.effect.ModEffects;
import net.sneezewipe.steelwitchesplus.item.ModItemGroups;
import net.sneezewipe.steelwitchesplus.item.ModItems;
import net.sneezewipe.steelwitchesplus.potion.ModPotions;
import net.sneezewipe.steelwitchesplus.util.ModLootTableModifiers;
import net.sneezewipe.steelwitchesplus.worldgen.ModBiomeModification;
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
		ModBiomeModification.registerBiomeModifications();
		ModEffects.registerEffects();
		ModLootTableModifiers.modifyLootTables();
        ModCompostableProvider.registerCompostables();

		registerBrewingRecipes();
		registerLootTableListener(EntityType.FROG, ModItems.FROG_TOE);
		registerTradeOffers();
	}

	private void registerLootTableListener(EntityType entity, Item newDrop) {
		LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
			if (lootTableSource.isBuiltin() && registryKey.equals(entity.getLootTableKey())) {
				LootPool.Builder poolBuilder = LootPool.builder().with(ItemEntry.builder(newDrop));
				builder.pool(poolBuilder);
			}
		}));
	}

	private void registerBrewingRecipes() {
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.WATER, ModItems.INKCAP, ModPotions.DELIRIUM_POTION);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.WATER, ModItems.WITCHCAP, ModPotions.BEWITCHED_POTION);
		});
	}

	private void registerTradeOffers() {
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(ModItems.TURNIP, 1), 7, 2, 0.04f
			));
		});
	}
}