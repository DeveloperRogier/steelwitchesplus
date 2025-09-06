package net.sneezewipe.steelwitchesplus.worldgen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeature {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_SMALL = registerKey("ore_ruby_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_MEDIUM = registerKey("ore_ruby_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_LARGE = registerKey("ore_ruby_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_BURIED = registerKey("ore_ruby_buried");

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
}
