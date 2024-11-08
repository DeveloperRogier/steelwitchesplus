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
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).add(ModBlocks.TRIM_QUARTZ_BLOCK);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.QUARTZ_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.DECAYABLE_BLOCKS)
                .add(Blocks.FERN)
                .forceAddTag(BlockTags.LEAVES)
                .forceAddTag(BlockTags.FLOWERS)
                .forceAddTag(BlockTags.SMALL_FLOWERS)
                .forceAddTag(BlockTags.TALL_FLOWERS);
    }
}
