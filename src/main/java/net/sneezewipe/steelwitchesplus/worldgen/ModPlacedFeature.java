package net.sneezewipe.steelwitchesplus.worldgen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;

import java.util.List;

import static net.sneezewipe.steelwitchesplus.worldgen.ModPlacedFeature.Modifiers.modifiersCount;
import static net.sneezewipe.steelwitchesplus.worldgen.ModPlacedFeature.Modifiers.modifiersRarity;

public class ModPlacedFeature {
    public static final RegistryKey<PlacedFeature> ORE_RUBY_SMALL = registerKey("ore_ruby_small");
    public static final RegistryKey<PlacedFeature> ORE_RUBY_MEDIUM = registerKey("ore_ruby_medium");
    public static final RegistryKey<PlacedFeature> ORE_RUBY_LARGE = registerKey("ore_ruby_large");
    public static final RegistryKey<PlacedFeature> ORE_RUBY_BURIED = registerKey("ore_ruby_buried");

    public static final RegistryKey<PlacedFeature> PALE_PUMPKIN_PATCH_PLACED_KEY = registerKey("pale_pumpkin_patch_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(
                context,
                ORE_RUBY_SMALL,
                registryLookup.getOrThrow(ModConfiguredFeature.ORE_RUBY_SMALL),
                modifiersCount(7, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80)))
        );
        register(
                context,
                ORE_RUBY_MEDIUM,
                registryLookup.getOrThrow(ModConfiguredFeature.ORE_RUBY_MEDIUM),
                modifiersCount(2, HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-4)))
        );
        register(
                context,
                ORE_RUBY_LARGE,
                registryLookup.getOrThrow(ModConfiguredFeature.ORE_RUBY_LARGE),
                modifiersRarity(9, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80)))
        );
        register(
                context,
                ORE_RUBY_BURIED,
                registryLookup.getOrThrow(ModConfiguredFeature.ORE_RUBY_BURIED),
                modifiersCount(4, HeightRangePlacementModifier.trapezoid(YOffset.aboveBottom(-80), YOffset.aboveBottom(80)))
        );
    }

    private static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(SteelWitchesPlus.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(config, List.copyOf(modifiers)));
    }

    public static class Modifiers {
        public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
            return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
        }

        public static List<PlacementModifier> modifiersCount(int count, PlacementModifier heightModifier) {
            return modifiers(CountPlacementModifier.of(count), heightModifier);
        }

        public static List<PlacementModifier> modifiersRarity(int chance, PlacementModifier heightModifier) {
            return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
        }
    }
}
