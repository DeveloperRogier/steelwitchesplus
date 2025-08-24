package net.sneezewipe.steelwitchesplus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup STEELWITCHESPLUS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SteelWitchesPlus.MOD_ID, "amethyst_dust"),
            FabricItemGroup.builder().displayName(Text.translatable(String.format("itemgroup.%s", SteelWitchesPlus.MOD_ID)))
                    .icon(() -> new ItemStack(ModItems.AMETHYST_DUST)).entries((displayContext, entries) -> {
                        ItemConvertible[] items = {
                                /* Items */
                                ModItems.AETHEREAL_FEATHER,
                                ModItems.AETHEREAL_ELYTRA,
                                ModItems.AMETHYST_DUST,
                                ModItems.AMETHYST_GREATSWORD,
                                ModItems.ARTICHOKE,
                                ModItems.ARTICHOKE_SEEDS,
                                ModItems.ATTUNED_STONE_DARK,
                                ModItems.ATTUNED_STONE_LIGHT,
                                ModItems.BAKED_CLAY_JAR,
                                ModItems.BELLADONNA,
                                ModItems.BELLADONNA_SEEDS,
                                ModItems.CLAY_JAR,
                                ModItems.FOREST_ESSENCE,
                                ModItems.FROG_TOE,
                                ModItems.GARLIC,
                                ModItems.GARLIC_CLOVE,
                                ModItems.GLASS_JAR,
                                ModItems.SCULK_POWDER,
                                ModItems.WEEPING_POWDER,
                                ModItems.QUARTZ_SWORD,
                                ModItems.QUARTZ_HELMET,
                                ModItems.QUARTZ_CHESTPLATE,
                                ModItems.QUARTZ_LEGGINGS,
                                ModItems.QUARTZ_BOOTS,
                                ModItems.SOLANDRA,
                                ModItems.SOLANDRA_SEEDS,
                                ModItems.WICCAN_SANDS,
                                ModItems.WITHER_SWORD,
                                ModItems.WOLFSBANE,
                                ModItems.WOLFSBANE_SEEDS,

                                /* Blocks */
                                ModBlocks.BRAMBLE_EMBER_CROP,
                                ModBlocks.BRAMBLE_WILD_CROP,
                                ModBlocks.DISTILLERY_BLOCK,
                                ModBlocks.QUARTZ_WALL,
                                ModBlocks.SKYWORT_CROP,
                                ModBlocks.TRIM_QUARTZ_BLOCK,
                        };
                        for (ItemConvertible item : items) {
                            entries.add(item);
                        }
                    }).build());
    public static void registerItemGroups() {
        SteelWitchesPlus.LOGGER.info(String.format("Registering item groups for %s", SteelWitchesPlus.MOD_ID));
    }
}
