package net.sneezewipe.steelwitchesplus.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeature {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_SMALL = registerKey("ore_ruby_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_MEDIUM = registerKey("ore_ruby_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_LARGE = registerKey("ore_ruby_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_BURIED = registerKey("ore_ruby_buried");

    public static final RegistryKey<ConfiguredFeature<?, ?>> INKCAP_KEY = registerKey("inkcap");
    public static final RegistryKey<ConfiguredFeature<?, ?>> INKCAP_PATCH_KEY = registerKey("inkcap_patch");

    public static final RegistryKey<ConfiguredFeature<?, ?>> GHOST_LARKSPUR_KEY = registerKey("ghost_larkspur");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRASP_GRASS_KEY = registerKey("grasp_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GYPSOPHILA_KEY = registerKey("gypsophila");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BLEAK_BERRY_BUSH_KEY = registerKey("bleak_berry_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_PUMPKIN_PATCH_KEY = registerKey("pale_pumpkin_patch");

        public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneOreReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateOreReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

                List<OreFeatureConfig.Target> overworldRubyTargets = List.of(
                OreFeatureConfig.createTarget(stoneOreReplaceables, ModBlocks.RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateOreReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState())
        );

        register(context, ORE_RUBY_SMALL, Feature.ORE, new OreFeatureConfig(overworldRubyTargets, 4, 0.5F));
        register(context, ORE_RUBY_MEDIUM, Feature.ORE, new OreFeatureConfig(overworldRubyTargets, 8, 0.5F));
        register(context, ORE_RUBY_LARGE, Feature.ORE, new OreFeatureConfig(overworldRubyTargets, 12, 0.7F));
        register(context, ORE_RUBY_BURIED, Feature.ORE, new OreFeatureConfig(overworldRubyTargets, 8, 1.0F));

        RegistryEntryLookup<PlacedFeature> registryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        register(context, INKCAP_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(ModBlocks.INKCAP)));

        register(context, INKCAP_PATCH_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        48,
                        4,
                        4,
                        registryLookup.getOrThrow(ModPlacedFeature.INKCAP_KEY)
                ));

        register(context, BLEAK_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLEAK_BERRY_BUSH
                                .getDefaultState().with(SweetBerryBushBlock.AGE, 3))),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PALE_MOSS_BLOCK)
                ));

        register(context, PALE_PUMPKIN_PATCH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PALE_PUMPKIN)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PALE_MOSS_BLOCK)
                ));

        register(context, GHOST_LARKSPUR_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GHOST_LARKSPUR)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PALE_MOSS_BLOCK)
                ));

        register(context, GRASP_GRASS_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GRASP_GRASS)),
                        List.of(Blocks.GRASS_BLOCK, Blocks.PALE_MOSS_BLOCK)
                ));

        register(context, GYPSOPHILA_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        96,
                        6,
                        2,
                        PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(
                                        flowerbed(ModBlocks.GYPSOPHILA)))
                ));

     }

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(SteelWitchesPlus.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context,
            RegistryKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC featureConfig) {
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }

    private static WeightedBlockStateProvider flowerbed(Block... blocks) {
        Pool.Builder<BlockState> builder = Pool.builder();
        for (Block b : blocks) {
            builder.add(b.getDefaultState(), 1);
        }
        return new WeightedBlockStateProvider(builder.build());
    }
}
