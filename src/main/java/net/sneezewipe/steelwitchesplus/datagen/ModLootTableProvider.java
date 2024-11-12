package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.block.custom.ArtichokeCropBlock;
import net.sneezewipe.steelwitchesplus.block.custom.GarlicCropBlock;
import net.sneezewipe.steelwitchesplus.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        Block[] blocks = {
                ModBlocks.TRIM_QUARTZ_BLOCK,
                ModBlocks.QUARTZ_WALL,
        };
        for (Block block : blocks) {
            addDrop(block);
        }

        /* SPECIAL DROPS */
        BlockStatePropertyLootCondition.Builder builderArtichoke = BlockStatePropertyLootCondition.builder(ModBlocks.ARTICHOKE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(ArtichokeCropBlock.AGE, ArtichokeCropBlock.MAX_AGE));
        addDrop(ModBlocks.ARTICHOKE_CROP, cropDrops(ModBlocks.ARTICHOKE_CROP, ModItems.ARTICHOKE, ModItems.ARTICHOKE_SEEDS, builderArtichoke));

        BlockStatePropertyLootCondition.Builder builderGarlic = BlockStatePropertyLootCondition.builder(ModBlocks.GARLIC_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(GarlicCropBlock.AGE, GarlicCropBlock.MAX_AGE));
        addDrop(ModBlocks.GARLIC_CROP, cropDrops(ModBlocks.GARLIC_CROP, ModItems.GARLIC, ModItems.GARLIC_CLOVE, builderGarlic));
    }
}
