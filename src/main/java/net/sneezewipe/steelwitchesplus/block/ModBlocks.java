package net.sneezewipe.steelwitchesplus.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.custom.*;

import java.util.function.Function;

public class ModBlocks {
    public static final Block BRAMBLE_WILD_CROP = register("bramble_wild", SugarCaneBlock::new,
            AbstractBlock.Settings.copy(Blocks.SUGAR_CANE), true);
    public static final Block BRAMBLE_EMBER_CROP = register("bramble_ember", SugarCaneBlock::new,
            AbstractBlock.Settings.copy(Blocks.SUGAR_CANE), true);
    public static final Block DISTILLERY_BLOCK = register("distillery_block", // TODO: recipe & texture
            DistilleryBlock::new, AbstractBlock.Settings.create().strength(1.5F, 6.0F).requiresTool(), true);
    public static final Block QUARTZ_WALL = register("quartz_wall",
            WallBlock::new, AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK), true);
    public static final Block RUBY_BLOCK = register("ruby_block",
            Block::new,
            AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_RED).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL),
            true
    );
    public static final Block BLEAK_VINE_HEAD = register("bleak_vine_head", CaveVinesHeadBlock::new,
            AbstractBlock.Settings.copy(Blocks.CAVE_VINES), true);
    public static final Block BLEAK_VINE_BODY = register("bleak_vine_body", CaveVinesBodyBlock::new,
            AbstractBlock.Settings.copy(Blocks.CAVE_VINES_PLANT), true);


    public static final Block RUBY_ORE = register("ruby_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings),
            AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).requiresTool().strength(5.0F, 6.0F),
            true
    );
    public static final Block DEEPSLATE_RUBY_ORE = register("deepslate_ruby_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings),
            AbstractBlock.Settings.copy(RUBY_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE),
            true
    );
    public static final Block SKYWORT_CROP = register("skywort",
            SugarCaneBlock::new, AbstractBlock.Settings.copy(Blocks.SUGAR_CANE), true);
    public static final Block TRIM_QUARTZ_BLOCK = register("trim_quartz_block",
            PillarBlock::new, AbstractBlock.Settings.copy(Blocks.CHISELED_QUARTZ_BLOCK), true);

    public static final Block PALE_PUMPKIN = register("pale_pumpkin",
            PumpkinBlock::new, AbstractBlock.Settings.copy(Blocks.PUMPKIN), true);

    /* CROPS */
    public static final Block ARTICHOKE_CROP = register("artichoke", ArtichokeCropBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHEAT), false);
    public static final Block BELLADONNA_CROP = register("belladonna", BelladonnaCropBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHEAT), false);
    public static final Block GARLIC_CROP = register("garlic", GarlicCropBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHEAT), false);
    public static final Block SOLANDRA_CROP = register("solandra", SolandraCropBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHEAT), false);
    public static final Block WOLFSBANE_CROP = register("wolfsbane", WolfsbaneCropBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHEAT), false);

    /* HELPERS */
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SteelWitchesPlus.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SteelWitchesPlus.MOD_ID, name));
    }

    public static void registerModBlocks() {
        SteelWitchesPlus.LOGGER.info(String.format("Registering blocks for %s", SteelWitchesPlus.MOD_ID));
    }
}
