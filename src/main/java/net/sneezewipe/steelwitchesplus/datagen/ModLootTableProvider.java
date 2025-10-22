package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.block.custom.*;
import net.sneezewipe.steelwitchesplus.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        Block[] blocks = {
                ModBlocks.BRAMBLE_EMBER_CROP,
                ModBlocks.BRAMBLE_WILD_CROP,
                ModBlocks.DISTILLERY_BLOCK,
                ModBlocks.GHOST_LARKSPUR,
                ModBlocks.GRASP_GRASS,
                ModBlocks.GYPSOPHILA,
                ModBlocks.PALE_PUMPKIN,
                ModBlocks.RUBY_BLOCK,
                ModBlocks.TRIM_QUARTZ_BLOCK,
                ModBlocks.SKYWORT_CROP,
                ModBlocks.QUARTZ_WALL,
        };
        for (Block block : blocks) {
            addDrop(block);
        }

        /* ORE DROPS */
        addDrop(ModBlocks.RUBY_ORE, multipleOreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY, 1, 1));
        addDrop(ModBlocks.DEEPSLATE_RUBY_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RUBY, 1, 1));

        /* OTHER DROPS */
        addDrop(ModBlocks.INKCAP_FLOWER, ModItems.INKCAP_SPORES);

        /* SPECIAL DROPS */
        BlockStatePropertyLootCondition.Builder builderArtichoke = BlockStatePropertyLootCondition.builder(ModBlocks.ARTICHOKE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(ArtichokeCropBlock.AGE, ArtichokeCropBlock.MAX_AGE));
        addDrop(ModBlocks.ARTICHOKE_CROP, cropDrops(ModBlocks.ARTICHOKE_CROP, ModItems.ARTICHOKE, ModItems.ARTICHOKE_SEEDS, builderArtichoke));

        BlockStatePropertyLootCondition.Builder builderBelladonna = BlockStatePropertyLootCondition.builder(ModBlocks.BELLADONNA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GarlicCropBlock.AGE, GarlicCropBlock.MAX_AGE));
        addDrop(ModBlocks.BELLADONNA_CROP, cropDrops(ModBlocks.BELLADONNA_CROP, ModItems.BELLADONNA, ModItems.BELLADONNA_SEEDS, builderBelladonna));

        this.addDrop(ModBlocks.BLEAK_BERRY_BUSH,
                block -> this.applyExplosionDecay(block, LootTable.builder()
                        .pool(LootPool.builder()
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.BLEAK_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BleakBerryBushBlock.AGE, 3)))
                                .with(ItemEntry.builder(ModItems.BLEAK_BERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                        .pool(LootPool.builder()
                                .conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.BLEAK_BERRY_BUSH).properties(StatePredicate.Builder.create().exactMatch(BleakBerryBushBlock.AGE, 2)))
                                .with(ItemEntry.builder(ModItems.BLEAK_BERRIES))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                        )));
        BlockStatePropertyLootCondition.Builder builderGarlic = BlockStatePropertyLootCondition.builder(ModBlocks.GARLIC_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GarlicCropBlock.AGE, GarlicCropBlock.MAX_AGE));
        addDrop(ModBlocks.GARLIC_CROP, cropDrops(ModBlocks.GARLIC_CROP, ModItems.GARLIC, ModItems.GARLIC_CLOVE, builderGarlic));

        BlockStatePropertyLootCondition.Builder builderInkcap = BlockStatePropertyLootCondition.builder(ModBlocks.INKCAP_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(InkcapCropBlock.AGE, InkcapCropBlock.MAX_AGE));
        addDrop(ModBlocks.INKCAP_CROP, cropDrops(ModBlocks.INKCAP_CROP, ModItems.INKCAP_SPORES, ModItems.INKCAP, builderInkcap));

        BlockStatePropertyLootCondition.Builder builderSolandra = BlockStatePropertyLootCondition.builder(ModBlocks.SOLANDRA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(SolandraCropBlock.AGE, SolandraCropBlock.MAX_AGE));
        addDrop(ModBlocks.SOLANDRA_CROP, cropDrops(ModBlocks.SOLANDRA_CROP, ModItems.SOLANDRA, ModItems.SOLANDRA_SEEDS, builderSolandra));

        BlockStatePropertyLootCondition.Builder builderTurnip = BlockStatePropertyLootCondition.builder(ModBlocks.TURNIP_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(TurnipCropBlock.AGE, TurnipCropBlock.MAX_AGE));
        addDrop(ModBlocks.TURNIP_CROP, cropDrops(ModBlocks.TURNIP_CROP, ModItems.TURNIP, ModItems.TURNIP, builderTurnip));

        BlockStatePropertyLootCondition.Builder builderWitchcap = BlockStatePropertyLootCondition.builder(ModBlocks.WITCHCAP_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(WitchcapCropBlock.AGE, WitchcapCropBlock.MAX_AGE));
        addDrop(ModBlocks.WITCHCAP_CROP, cropDrops(ModBlocks.WITCHCAP_CROP, ModItems.WITCHCAP_SPORES, ModItems.WITCHCAP, builderWitchcap));

        BlockStatePropertyLootCondition.Builder builderWolfsbane = BlockStatePropertyLootCondition.builder(ModBlocks.WOLFSBANE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(WolfsbaneCropBlock.AGE, WolfsbaneCropBlock.MAX_AGE));
        addDrop(ModBlocks.WOLFSBANE_CROP, cropDrops(ModBlocks.WOLFSBANE_CROP, ModItems.WOLFSBANE, ModItems.WOLFSBANE_SEEDS, builderWolfsbane));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
