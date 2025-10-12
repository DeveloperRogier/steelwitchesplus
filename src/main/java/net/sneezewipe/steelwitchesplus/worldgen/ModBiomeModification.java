package net.sneezewipe.steelwitchesplus.worldgen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.List;

public class ModBiomeModification {
    public static void registerBiomeModifications() {
        for (RegistryKey<PlacedFeature> feature : List.of(
                ModPlacedFeature.ORE_RUBY_SMALL,
                ModPlacedFeature.ORE_RUBY_MEDIUM,
                ModPlacedFeature.ORE_RUBY_LARGE,
                ModPlacedFeature.ORE_RUBY_BURIED,
                ModPlacedFeature.INKCAP_KEY,
                ModPlacedFeature.INKCAP_PATCH_KEY
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

            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.PALE_GARDEN),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeature.INKCAP_PATCH_KEY
            );

            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.PALE_GARDEN),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeature.BLEAK_BERRY_BUSH_PLACED_KEY
            );

            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.PALE_GARDEN),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeature.PALE_PUMPKIN_PATCH_PLACED_KEY
            );

            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.PALE_GARDEN),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeature.GHOST_LARKSPUR_PLACED_KEY
            );

            BiomeModifications.addFeature(
                    BiomeSelectors.includeByKey(BiomeKeys.PALE_GARDEN),
                    GenerationStep.Feature.VEGETAL_DECORATION,
                    ModPlacedFeature.GRASP_GRASS_PLACED_KEY
            );
        }
    }
}
