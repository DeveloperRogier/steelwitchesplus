package net.sneezewipe.steelwitchesplus.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class ModLootTableModifiers {

    private static final Identifier WITCH_LOOT_TABLE_ID
            = Identifier.of("minecraft", "entities/witch");
    public static final Identifier PALE_HANGING_MOSS_ID
            = Identifier.of("minecraft", "blocks/pale_hanging_moss");
    public static final Identifier PALE_LEAVES_ID
            = Identifier.of("minecraft", "blocks/pale_oak_leaves");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (PALE_HANGING_MOSS_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.PALE_PUMPKIN_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,2.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if (PALE_LEAVES_ID.equals(registryKey.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.PALLID_APPLE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if (LootTables.WOODLAND_MANSION_CHEST.equals(registryKey)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.PALE_PUMPKIN_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f,5.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if (LootTables.PILLAGER_OUTPOST_CHEST.equals(registryKey)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(3))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.PALE_PUMPKIN_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f,5.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if (WITCH_LOOT_TABLE_ID.equals(registryKey.getValue())){
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.WITCHCAP_SPORES))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f,1.0f)).build());

                builder.pool(poolBuilder.build());
            }
        }));
    }
}
