package net.sneezewipe.steelwitchesplus.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;

public class ModBiomeModification {
    public static void registerBiomeModifications() {
        for (RegistryKey<PlacedFeature> feature : List.of(
                ModPlacedFeature.ORE_RUBY_SMALL,
                ModPlacedFeature.ORE_RUBY_MEDIUM,
                ModPlacedFeature.ORE_RUBY_LARGE,
                ModPlacedFeature.ORE_RUBY_BURIED
        )) {
            BiomeModifications.addFeature(
                    BiomeSelectors.foundInOverworld(),
                    /* Alternatively, to target specific biomes:
                       Biomeselectors.tag(BiomeTags.XYZ)
                       or to exclude specific biomes:
                       BiomeSelectors.exclude(...) */
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    feature
            );
        }
    }
}
