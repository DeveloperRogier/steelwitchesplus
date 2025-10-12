package net.sneezewipe.steelwitchesplus.worldgen;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
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

    public static final RegistryKey<PlacedFeature> INKCAP_KEY = registerKey("inkcap");
    public static final RegistryKey<PlacedFeature> INKCAP_PATCH_KEY = registerKey("inkcap_patch");

    public static final RegistryKey<PlacedFeature> GHOST_LARKSPUR_PLACED_KEY = registerKey("ghost_larkspur_placed");
    public static final RegistryKey<PlacedFeature> GRASP_GRASS_PLACED_KEY = registerKey("grasp_grass_placed");

    public static final RegistryKey<PlacedFeature> BLEAK_BERRY_BUSH_PLACED_KEY = registerKey("bleak_berry_bush_placed");
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

        register(context, INKCAP_KEY,
                registryLookup.getOrThrow(ModConfiguredFeature.INKCAP_KEY),
                List.of(
                        BlockFilterPlacementModifier.of(
                                BlockPredicate.matchingBlocks(new BlockPos(0, -1, 0), Blocks.PALE_MOSS_BLOCK)),
                        RarityFilterPlacementModifier.of(6)
                )
        );
        register(context, INKCAP_PATCH_KEY,
                registryLookup.getOrThrow(ModConfiguredFeature.INKCAP_PATCH_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(4),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );

        register(context, GHOST_LARKSPUR_PLACED_KEY,
                registryLookup.getOrThrow(ModConfiguredFeature.GHOST_LARKSPUR_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(2),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );

        register(context, GRASP_GRASS_PLACED_KEY,
                registryLookup.getOrThrow(ModConfiguredFeature.GRASP_GRASS_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(2),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );

        register(context, BLEAK_BERRY_BUSH_PLACED_KEY,
                registryLookup.getOrThrow(ModConfiguredFeature.BLEAK_BERRY_BUSH_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(12),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
        );

        register(context, PALE_PUMPKIN_PATCH_PLACED_KEY,
                registryLookup.getOrThrow(ModConfiguredFeature.PALE_PUMPKIN_PATCH_KEY),
                List.of(
                        RarityFilterPlacementModifier.of(20),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()
                )
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
