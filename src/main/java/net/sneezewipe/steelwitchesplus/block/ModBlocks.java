package net.sneezewipe.steelwitchesplus.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;

public class ModBlocks {
    public static final Block QUARTZ_WALL = registerBlock("quartz_wall",
            new WallBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK)));
    public static final Block TRIM_QUARTZ_BLOCK = registerBlock("trim_quartz_block",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.CHISELED_QUARTZ_BLOCK)));

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
