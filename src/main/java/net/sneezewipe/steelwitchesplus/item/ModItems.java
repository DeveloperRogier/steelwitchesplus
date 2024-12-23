package net.sneezewipe.steelwitchesplus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.item.custom.*;

public class ModItems {
    /*
     * ITEMS
     */
    // TODO: check if custom item classes are necessary for the crop items like ArtichokeItem
    public static final Item AETHEREAL_ELYTRA = registerItem("aethereal_elytra", new AetherealElytraItem(new Item.Settings().rarity(Rarity.RARE).maxDamage(100000)));
    public static final Item AETHEREAL_FEATHER = registerItem("aethereal_feather", new AetherealFeatherItem(new Item.Settings()));
    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new Item(new Item.Settings()));
    public static final Item ARTICHOKE = registerItem("artichoke", new ArtichokeItem(new Item.Settings()));
    public static final Item ARTICHOKE_SEEDS = registerItem("artichoke_seeds", new AliasedBlockItem(ModBlocks.ARTICHOKE_CROP, new Item.Settings()));
    public static final Item ATTUNED_STONE_DARK = registerItem("attuned_stone_dark", new AttunedStoneDarkItem(new Item.Settings().rarity(Rarity.UNCOMMON)));
    public static final Item ATTUNED_STONE_LIGHT = registerItem("attuned_stone_light", new AttunedStoneLightItem(new Item.Settings().rarity(Rarity.UNCOMMON)));
    public static final Item AMETHYST_GREATSWORD = registerItem("amethyst_greatsword", new AmethystGreatswordItem(ModToolMaterials.AMETHYST, 1, 8.0f,-3.0f, new Item.Settings()));
    public static final Item BAKED_CLAY_JAR = registerItem("baked_clay_jar", new BakedClayJarItem(new Item.Settings().maxCount(16))); // Custom class necessary?
    public static final Item BELLADONNA = registerItem("belladonna", new BelladonnaItem(new Item.Settings()));
    public static final Item BELLADONNA_SEEDS = registerItem("belladonna_seeds", new AliasedBlockItem(ModBlocks.BELLADONNA_CROP, new Item.Settings()));
    public static final Item CLAY_JAR = registerItem("clay_jar", new ClayJarItem(new Item.Settings().maxCount(16)));
    public static final Item FOREST_ESSENCE = registerItem("forest_essence", new Item(new Item.Settings()));
    public static final Item FROG_TOE = registerItem("frog_toe", new Item(new Item.Settings()));
    public static final Item GARLIC = registerItem("garlic", new Item(new Item.Settings()));
    public static final Item GARLIC_CLOVE = registerItem("garlic_clove", new AliasedBlockItem(ModBlocks.GARLIC_CROP, new Item.Settings()));
    public static final Item GLASS_JAR = registerItem("glass_jar", new Item(new Item.Settings()));
    public static final Item POTION_ESSENCE_BERRY_MIX = registerItem("potion_essence_berry_mix", new Item(new Item.Settings()));
    public static final Item QUARTZ_SWORD = registerItem("quartz_sword",
            new QuartzSwordItem(ModToolMaterials.QUARTZ,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.QUARTZ, 3, -2.2f))));
    public static final Item SCULK_POWDER = registerItem("sculk_powder", new Item(new Item.Settings()));
    public static final Item SOLANDRA = registerItem("solandra", new SolandraItem(new Item.Settings()));
    public static final Item SOLANDRA_SEEDS = registerItem("solandra_seeds", new AliasedBlockItem(ModBlocks.SOLANDRA_CROP, new Item.Settings()));
    public static final Item WEEPING_POWDER = registerItem("weeping_powder", new Item(new Item.Settings()));
    public static final Item WICCAN_SANDS = registerItem("wiccan_sands", new WiccanSandsItem(new Item.Settings().rarity(Rarity.UNCOMMON)));
    public static final Item WOLFSBANE = registerItem("wolfsbane", new WolfsbaneItem(new Item.Settings()));
    public static final Item WOLFSBANE_SEEDS = registerItem("wolfsbane_seeds", new AliasedBlockItem(ModBlocks.WOLFSBANE_CROP, new Item.Settings()));
    public static final Item WITHER_SWORD = registerItem("wither_sword",
            new WitherSwordItem(ToolMaterials.NETHERITE,
                    new Item.Settings().rarity(Rarity.UNCOMMON).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, -3, -2.4f))));

    /*
     * ARMOR
     */
    /* Only one armor item in the set needs to be a ModArmorItem, because a player needs to wear the full set
     * to receive the status effect anyway. This way, we can save computing resources. */
    public static final Item QUARTZ_HELMET = registerItem("quartz_helmet",
            new ModArmorItem(ModArmorMaterials.QUARTZ, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(12)));
    public static final Item QUARTZ_CHESTPLATE = registerItem("quartz_chestplate",
            new ArmorItem(ModArmorMaterials.QUARTZ, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(12)));
    public static final Item QUARTZ_LEGGINGS = registerItem("quartz_leggings",
            new ArmorItem(ModArmorMaterials.QUARTZ, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(12)));
    public static final Item QUARTZ_BOOTS = registerItem("quartz_boots",
            new ArmorItem(ModArmorMaterials.QUARTZ, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(12)));

    /* Add an item to the item group indicated by one of the following functions' names. */
    /* To be clear, since these are vanilla groups, these are not handled in ModItemGroups.java. */
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
                AETHEREAL_ELYTRA,
                WICCAN_SANDS,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
                AETHEREAL_FEATHER,
                ARTICHOKE,
                AMETHYST_DUST,
                BAKED_CLAY_JAR,
                BELLADONNA,
                CLAY_JAR,
                FOREST_ESSENCE,
                FROG_TOE,
                GARLIC,
                GLASS_JAR,
                POTION_ESSENCE_BERRY_MIX,
                SCULK_POWDER,
                SOLANDRA,
                WEEPING_POWDER,
                WOLFSBANE,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }

    private static void addItemsToNaturalItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
                ARTICHOKE_SEEDS,
                BELLADONNA_SEEDS,
                GARLIC_CLOVE,
                SOLANDRA_SEEDS,
                WOLFSBANE_SEEDS,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
                AMETHYST_GREATSWORD,
                QUARTZ_BOOTS,
                QUARTZ_CHESTPLATE,
                QUARTZ_HELMET,
                QUARTZ_LEGGINGS,
                QUARTZ_SWORD,
                WITHER_SWORD,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SteelWitchesPlus.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SteelWitchesPlus.LOGGER.info(String.format("Registering items for %s", SteelWitchesPlus.MOD_ID));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
