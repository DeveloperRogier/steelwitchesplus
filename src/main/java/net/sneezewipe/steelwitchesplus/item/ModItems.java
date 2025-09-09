package net.sneezewipe.steelwitchesplus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.item.custom.*;

import java.util.List;
import java.util.function.Function;

public class ModItems {
    /*
     * ITEMS
     */
    // TODO: check if custom item classes are necessary for the crop items like ArtichokeItem
//    public static final Item AETHEREAL_ELYTRA = registerItem("aethereal_elytra", new AetherealElytraItem(new Item.Settings().rarity(Rarity.RARE).maxDamage(100000)));
    public static final Item AETHEREAL_FEATHER = register("aethereal_feather", AetherealFeatherItem::new, new Item.Settings());
    public static final Item AMETHYST_DUST = register("amethyst_dust", Item::new, new Item.Settings());
    public static final Item ARTICHOKE = register("artichoke", Item::new, new Item.Settings()); // TODO: delete artichoke class
    public static final Item ARTICHOKE_SEEDS = register("artichoke_seeds", settings -> new BlockItem(ModBlocks.ARTICHOKE_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item ATTUNED_STONE_DARK = register("attuned_stone_dark", AttunedStoneDarkItem::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item ATTUNED_STONE_LIGHT = register("attuned_stone_light", AttunedStoneLightItem::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item AMETHYST_GREATSWORD = register("amethyst_greatsword",
            settings -> new AmethystGreatswordItem(ModToolMaterials.AMETHYST, 1, 8.0f,-3.0f, settings), new Item.Settings());
    public static final Item BAKED_CLAY_JAR = register("baked_clay_jar", BakedClayJarItem::new, new Item.Settings().maxCount(16)); // Custom class necessary?
    public static final Item BELLADONNA = register("belladonna", Item::new, new Item.Settings()); // TODO: delete artichoke class
    public static final Item BELLADONNA_SEEDS = register("belladonna_seeds", settings -> new BlockItem(ModBlocks.BELLADONNA_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item CLAY_JAR = register("clay_jar", ClayJarItem::new, new Item.Settings().maxCount(16)); // Custom class necessary?
    public static final Item FOREST_ESSENCE = register("forest_essence", Item::new, new Item.Settings());
    public static final Item FROG_TOE = register("frog_toe", Item::new, new Item.Settings());
    public static final Item GARLIC = register("garlic", Item::new, new Item.Settings());
    public static final Item GARLIC_CLOVE = register("garlic_clove", settings -> new BlockItem(ModBlocks.GARLIC_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item GLASS_JAR = register("glass_jar", Item::new, new Item.Settings());
    public static final Item POTION_ESSENCE_BERRY_MIX = register("potion_essence_berry_mix", Item::new, new Item.Settings());
    public static final Item QUARTZ_SWORD = register("quartz_sword",
            settings -> new QuartzSwordItem(ModToolMaterials.QUARTZ, 3, -2.2f, settings), new Item.Settings());
    public static final Item RUBY = register("ruby", Item::new, new Item.Settings());
    public static final Item SCULK_POWDER = register("sculk_powder", Item::new, new Item.Settings());
    public static final Item SOLANDRA = register("solandra", SolandraItem::new, new Item.Settings());
    public static final Item SOLANDRA_SEEDS = register("solandra_seeds", settings -> new BlockItem(ModBlocks.SOLANDRA_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item WEEPING_POWDER = register("weeping_powder", Item::new, new Item.Settings());
    public static final Item WICCAN_SANDS = register("wiccan_sands", WiccanSandsItem::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item WOLFSBANE = register("wolfsbane", WolfsbaneItem::new, new Item.Settings());
    public static final Item WOLFSBANE_SEEDS = register("wolfsbane_seeds", settings -> new BlockItem(ModBlocks.WOLFSBANE_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item WITHER_SWORD = register("wither_sword",
            settings -> new WitherSwordItem(ToolMaterial.NETHERITE, -3, -2.4f, settings.rarity(Rarity.UNCOMMON)), new Item.Settings());

    /*
     * ARMOR
     */
    public static final Item QUARTZ_HELMET = register("quartz_helmet",
            settings -> new ModArmorItem(ModArmorMaterials.QUARTZ_ARMOR_MATERIAL, EquipmentType.HELMET, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)));
    public static final Item QUARTZ_CHESTPLATE = register("quartz_chestplate",
            settings -> new ModArmorItem(ModArmorMaterials.QUARTZ_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)));
    public static final Item QUARTZ_LEGGINGS = register("quartz_leggings",
            settings -> new ModArmorItem(ModArmorMaterials.QUARTZ_ARMOR_MATERIAL, EquipmentType.LEGGINGS, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)));
    public static final Item QUARTZ_BOOTS = register("quartz_boots",
            settings -> new ModArmorItem(ModArmorMaterials.QUARTZ_ARMOR_MATERIAL, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY)));
    public static final List<Item> QUARTZ_ARMOR_SET = List.of(QUARTZ_HELMET, QUARTZ_CHESTPLATE, QUARTZ_LEGGINGS, QUARTZ_BOOTS);

    public static final Item RUBY_HELMET = register("ruby_helmet", Item::new,
            new Item.Settings().armor(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.RUBY_DURABILITY)));
    public static final Item RUBY_CHESTPLATE = register("ruby_chestplate", Item::new,
            new Item.Settings().armor(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.RUBY_DURABILITY)));
    public static final Item RUBY_LEGGINGS = register("ruby_leggings", Item::new,
            new Item.Settings().armor(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.RUBY_DURABILITY)));
    public static final Item RUBY_BOOTS = register("ruby_boots", Item::new,
            new Item.Settings().armor(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.RUBY_DURABILITY)));
    public static final List<Item> RUBY_ARMOR_SET = List.of(RUBY_HELMET, RUBY_CHESTPLATE, RUBY_LEGGINGS, RUBY_BOOTS);

    /* Add an item to the item group indicated by one of the following functions' names. */
    /* To be clear, since these are vanilla groups, these are not handled in ModItemGroups.java. */
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
//                AETHEREAL_ELYTRA,
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
                RUBY,
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

                ModBlocks.DEEPSLATE_RUBY_ORE.asItem(),
                ModBlocks.RUBY_ORE.asItem(),
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
                RUBY_BOOTS,
                RUBY_CHESTPLATE,
                RUBY_HELMET,
                RUBY_LEGGINGS,
                WITHER_SWORD,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }

    private static void addItemsToBuildingBlocksItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
                ModBlocks.RUBY_BLOCK.asItem(),
        };
        for (Item item : items) {
            entries.add(item);
        }
    }

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SteelWitchesPlus.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        SteelWitchesPlus.LOGGER.info(String.format("Registering items for %s", SteelWitchesPlus.MOD_ID));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addItemsToNaturalItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlocksItemGroup);
    }
}
