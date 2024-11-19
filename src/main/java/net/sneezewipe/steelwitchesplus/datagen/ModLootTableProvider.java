package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.block.custom.ArtichokeCropBlock;
import net.sneezewipe.steelwitchesplus.block.custom.GarlicCropBlock;
import net.sneezewipe.steelwitchesplus.block.custom.SolandraCropBlock;
import net.sneezewipe.steelwitchesplus.block.custom.WolfsbaneCropBlock;
import net.sneezewipe.steelwitchesplus.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        Block[] blocks = {
                ModBlocks.BRAMBLE_EMBER_CROP,
                ModBlocks.BRAMBLE_WILD_CROP,
                ModBlocks.TRIM_QUARTZ_BLOCK,
                ModBlocks.SKYWORT_CROP,
                ModBlocks.QUARTZ_WALL,
        };
        for (Block block : blocks) {
            addDrop(block);
        }

        /* SPECIAL DROPS */
        BlockStatePropertyLootCondition.Builder builderArtichoke = BlockStatePropertyLootCondition.builder(ModBlocks.ARTICHOKE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(ArtichokeCropBlock.AGE, ArtichokeCropBlock.MAX_AGE));
        addDrop(ModBlocks.ARTICHOKE_CROP, cropDrops(ModBlocks.ARTICHOKE_CROP, ModItems.ARTICHOKE, ModItems.ARTICHOKE_SEEDS, builderArtichoke));

        BlockStatePropertyLootCondition.Builder builderBelladonna = BlockStatePropertyLootCondition.builder(ModBlocks.BELLADONNA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GarlicCropBlock.AGE, GarlicCropBlock.MAX_AGE));
        addDrop(ModBlocks.BELLADONNA_CROP, cropDrops(ModBlocks.BELLADONNA_CROP, ModItems.BELLADONNA, ModItems.BELLADONNA_SEEDS, builderBelladonna));

        BlockStatePropertyLootCondition.Builder builderGarlic = BlockStatePropertyLootCondition.builder(ModBlocks.GARLIC_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GarlicCropBlock.AGE, GarlicCropBlock.MAX_AGE));
        addDrop(ModBlocks.GARLIC_CROP, cropDrops(ModBlocks.GARLIC_CROP, ModItems.GARLIC, ModItems.GARLIC_CLOVE, builderGarlic));

        BlockStatePropertyLootCondition.Builder builderSolandra = BlockStatePropertyLootCondition.builder(ModBlocks.SOLANDRA_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(SolandraCropBlock.AGE, SolandraCropBlock.MAX_AGE));
        addDrop(ModBlocks.SOLANDRA_CROP, cropDrops(ModBlocks.SOLANDRA_CROP, ModItems.SOLANDRA, ModItems.SOLANDRA_SEEDS, builderSolandra));

        BlockStatePropertyLootCondition.Builder builderWolfsbane = BlockStatePropertyLootCondition.builder(ModBlocks.WOLFSBANE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(WolfsbaneCropBlock.AGE, WolfsbaneCropBlock.MAX_AGE));
        addDrop(ModBlocks.WOLFSBANE_CROP, cropDrops(ModBlocks.WOLFSBANE_CROP, ModItems.WOLFSBANE, ModItems.WOLFSBANE_SEEDS, builderWolfsbane));
    }
}
