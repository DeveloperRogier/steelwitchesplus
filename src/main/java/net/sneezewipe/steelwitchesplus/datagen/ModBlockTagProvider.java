package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.RUBY_BLOCK);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.DEEPSLATE_RUBY_ORE);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.RUBY_ORE);
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.TRIM_QUARTZ_BLOCK);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.RUBY_BLOCK);
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.DEEPSLATE_RUBY_ORE);
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.RUBY_ORE);

        valueLookupBuilder(BlockTags.AXE_MINEABLE).add(ModBlocks.PALE_PUMPKIN);

        valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.QUARTZ_WALL);

        valueLookupBuilder(ModTags.Blocks.DECAYABLE_BLOCKS)
                .add(Blocks.FERN)
                .forceAddTag(BlockTags.LEAVES)
                .forceAddTag(BlockTags.FLOWERS)
                .forceAddTag(BlockTags.SMALL_FLOWERS);
    }
}
