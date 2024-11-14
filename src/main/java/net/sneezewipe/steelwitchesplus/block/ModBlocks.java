package net.sneezewipe.steelwitchesplus.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.custom.*;

public class ModBlocks {
    public static final Block BRAMBLE_WILD_CROP = registerBlock("bramble_wild",
            new SugarCaneBlock(AbstractBlock.Settings.copy(Blocks.SUGAR_CANE)));
    public static final Block BRAMBLE_EMBER_CROP = registerBlock("bramble_ember",
            new SugarCaneBlock(AbstractBlock.Settings.copy(Blocks.SUGAR_CANE)));
    public static final Block QUARTZ_WALL = registerBlock("quartz_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK)));
    public static final Block SKYWORT_CROP = registerBlock("skywort",
            new SugarCaneBlock(AbstractBlock.Settings.copy(Blocks.SUGAR_CANE)));
    public static final Block TRIM_QUARTZ_BLOCK = registerBlock("trim_quartz_block",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.CHISELED_QUARTZ_BLOCK)));

    /* CROPS */
    public static final Block ARTICHOKE_CROP = Registry.register(Registries.BLOCK, Identifier.of(SteelWitchesPlus.MOD_ID,
            "artichoke"), new ArtichokeCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block GARLIC_CROP = Registry.register(Registries.BLOCK, Identifier.of(SteelWitchesPlus.MOD_ID,
            "garlic"), new GarlicCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block BELLADONNA_CROP = Registry.register(Registries.BLOCK, Identifier.of(SteelWitchesPlus.MOD_ID,
            "belladonna"), new BelladonnaCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));
    public static final Block WOLFSBANE_CROP = Registry.register(Registries.BLOCK, Identifier.of(SteelWitchesPlus.MOD_ID,
            "wolfsbane"), new WolfsbaneCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    /* HELPERS */
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SteelWitchesPlus.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(SteelWitchesPlus.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        SteelWitchesPlus.LOGGER.info(String.format("Registering blocks for %s", SteelWitchesPlus.MOD_ID));
    }
}
