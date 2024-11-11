package net.sneezewipe.steelwitchesplus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.item.custom.*;

public class ModItems {
    /*
     * ITEMS
     */
    public static final Item AETHEREAL_ELYTRA = registerItem("aethereal_elytra", new AetherealElytraItem(new Item.Settings().rarity(Rarity.RARE).maxDamage(100000)));
    public static final Item AETHEREAL_FEATHER = registerItem("aethereal_feather", new AetherealFeatherItem(new Item.Settings().maxCount(64)));
    public static final Item AMETHYST_DUST = registerItem("amethyst_dust", new AmethystDustItem(new Item.Settings().maxCount(64)));
    public static final Item ARTICHOKE = registerItem("artichoke", new ArtichokeItem(new Item.Settings().maxCount(64)));
    public static final Item ATTUNED_STONE_DARK = registerItem("attuned_stone_dark", new AttunedStoneDarkItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(64)));
    public static final Item ATTUNED_STONE_LIGHT = registerItem("attuned_stone_light", new AttunedStoneLightItem(new Item.Settings().rarity(Rarity.UNCOMMON).maxCount(64)));
    public static final Item AMETHYST_GREATSWORD = registerItem("amethyst_greatsword", new AmethystGreatswordItem(ModToolMaterials.AMETHYST, 1, 8.0f,-3.0f, new Item.Settings()));
    public static final Item BAKED_CLAY_JAR = registerItem("baked_clay_jar", new BakedClayJarItem(new Item.Settings().maxCount(16)));
    public static final Item CLAY_JAR = registerItem("clay_jar", new ClayJarItem(new Item.Settings().maxCount(16)));
    public static final Item GLASS_JAR = registerItem("glass_jar", new GlassJarItem(new Item.Settings().maxCount(64)));
    public static final Item QUARTZ_SWORD = registerItem("quartz_sword",
            new QuartzSwordItem(ModToolMaterials.QUARTZ,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.QUARTZ, 3, -2.2f))));
    public static final Item SCULK_POWDER = registerItem("sculk_powder", new SculkPowderItem(new Item.Settings().maxCount(64)));
    public static final Item WEEPING_POWDER = registerItem("weeping_powder", new WeepingPowderItem(new Item.Settings().maxCount(64)));
    public static final Item WICCAN_SANDS = registerItem("wiccan_sands", new WiccanSandsItem(new Item.Settings().rarity(Rarity.UNCOMMON)));
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
                CLAY_JAR,
                GLASS_JAR,
                SCULK_POWDER,
                WEEPING_POWDER,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
