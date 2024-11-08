package net.sneezewipe.steelwitchesplus.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> DECAYABLE_BLOCKS = createTag("decayable_blocks");
        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SteelWitchesPlus.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SteelWitchesPlus.MOD_ID, name));
        }
    }
}
