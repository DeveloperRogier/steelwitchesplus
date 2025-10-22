package net.sneezewipe.steelwitchesplus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.equipment.EquipmentType;
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
    public static final Item BELLADONNA = register("belladonna", Item::new, new Item.Settings());
    public static final Item BELLADONNA_SEEDS = register("belladonna_seeds", settings -> new BlockItem(ModBlocks.BELLADONNA_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item CLAY_JAR = register("clay_jar", ClayJarItem::new, new Item.Settings().maxCount(16)); // Custom class necessary?
    public static final Item CLEANED_FLESH = register("cleaned_flesh", Item::new, new Item.Settings());
    public static final Item DAINTY_SLIPPERS = register("dainty_slippers", Item::new, new Item.Settings());
    public static final Item DISINFECTANT = register("disinfectant", Item::new, new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(16));
    public static final Item DISINFECTANT_BASE = register("disinfectant_base", Item::new, new Item.Settings().maxCount(16));
    public static final Item FOREST_ESSENCE = register("forest_essence", Item::new, new Item.Settings());
    public static final Item FROG_TOE = register("frog_toe", Item::new, new Item.Settings());
    public static final Item GARLIC = register("garlic", Item::new, new Item.Settings());
    public static final Item GARLIC_CLOVE = register("garlic_clove", settings -> new BlockItem(ModBlocks.GARLIC_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item GLASS_JAR = register("glass_jar", Item::new, new Item.Settings());
    public static final Item INFERNAL_BLADE = register("infernal_blade",
            settings -> new InfernalBladeItem(ToolMaterial.DIAMOND, 3, -2.4f, settings), new Item.Settings());
    public static final Item INKCAP = register("inkcap", settings -> new BlockItem(ModBlocks.INKCAP_FLOWER, settings), new Item.Settings());
    public static final Item INKCAP_SPORES = register("inkcap_spores", settings -> new BlockItem(ModBlocks.INKCAP_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item PALE_PUMPKIN_SEEDS = register("pale_pumpkin_seeds",
            settings -> new BlockItem(ModBlocks.PALE_PUMPKIN_STEM, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item POTION_ESSENCE_BERRY_MIX = register("potion_essence_berry_mix", Item::new, new Item.Settings());
    public static final Item QUARTZ_SWORD = register("quartz_sword",
            settings -> new QuartzSwordItem(ModToolMaterials.QUARTZ, 3, -2.2f, settings), new Item.Settings());
    public static final Item RUBINITE_INGOT = register("rubinite_ingot", Item::new, new Item.Settings());
    public static final Item RUBY = register("ruby", Item::new, new Item.Settings());
    public static final Item RUBY_AXE = register("ruby_axe", Item::new, new Item.Settings().axe(ModToolMaterials.RUBY, 9, -2.7f));
    public static final Item RUBY_HOE = register("ruby_hoe", Item::new, new Item.Settings().hoe(ModToolMaterials.RUBY, 1, 0.3f));
    public static final Item RUBY_PICKAXE = register("ruby_pickaxe", Item::new, new Item.Settings().pickaxe(ModToolMaterials.RUBY, 5, -2.5f));
    public static final Item RUBY_SHOVEL = register("ruby_shovel", Item::new, new Item.Settings().shovel(ModToolMaterials.RUBY, 5.5f, -2.7f));
    public static final Item RUBY_SWORD = register("ruby_sword", Item::new, new Item.Settings().sword(ModToolMaterials.RUBY, 7, -2.1f));
    public static final List<Item> RUBY_TOOL_SET = List.of(RUBY_AXE, RUBY_HOE, RUBY_PICKAXE, RUBY_SHOVEL, RUBY_SWORD);
    public static final Item SCULK_POWDER = register("sculk_powder", Item::new, new Item.Settings());
    public static final Item SOLANDRA = register("solandra", SolandraItem::new, new Item.Settings());
    public static final Item SOLANDRA_SEEDS = register("solandra_seeds", settings -> new BlockItem(ModBlocks.SOLANDRA_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item WEEPING_POWDER = register("weeping_powder", Item::new, new Item.Settings());
    public static final Item WICCAN_SANDS = register("wiccan_sands", WiccanSandsItem::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    public static final Item WITCHCAP = register("witchcap", Item::new, new Item.Settings());
    public static final Item WITCHCAP_SPORES = register("witchcap_spores", settings -> new BlockItem(ModBlocks.WITCHCAP_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
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

    public static final Item RUBINITE_HELMET = register("rubinite_helmet",
            settings -> new ModArmorItem(ModArmorMaterials.RUBINITE_ARMOR_MATERIAL, EquipmentType.HELMET, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.RUBINITE_DURABILITY)));
    public static final Item RUBINITE_CHESTPLATE = register("rubinite_chestplate",
            settings -> new ModArmorItem(ModArmorMaterials.RUBINITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, settings),
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.RUBINITE_DURABILITY)));
    public static final Item RUBINITE_LEGGINGS = register("rubinite_leggings",
            settings -> new ModArmorItem(ModArmorMaterials.RUBINITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS, settings),
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.RUBINITE_DURABILITY)));
    public static final Item RUBINITE_BOOTS = register("rubinite_boots",
            settings -> new ModArmorItem(ModArmorMaterials.RUBINITE_ARMOR_MATERIAL, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.RUBINITE_DURABILITY)));
    public static final List<Item> RUBINITE_ARMOR_SET = List.of(RUBINITE_HELMET, RUBINITE_CHESTPLATE, RUBINITE_LEGGINGS, RUBINITE_BOOTS);

    public static final Item RUBY_HELMET = register("ruby_helmet", Item::new,
            new Item.Settings().armor(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.RUBY_DURABILITY)));
    public static final Item RUBY_CHESTPLATE = register("ruby_chestplate", Item::new,
            new Item.Settings().armor(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.RUBY_DURABILITY)));
    public static final Item RUBY_LEGGINGS = register("ruby_leggings", Item::new,
            new Item.Settings().armor(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.RUBY_DURABILITY)));
    public static final Item RUBY_BOOTS = register("ruby_boots", Item::new,
            new Item.Settings().armor(ModArmorMaterials.RUBY_ARMOR_MATERIAL, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.RUBY_DURABILITY)));
    public static final List<Item> RUBY_ARMOR_SET = List.of(RUBY_HELMET, RUBY_CHESTPLATE, RUBY_LEGGINGS, RUBY_BOOTS);

    /*
     * FOOD
     */
    public static final ConsumableComponent WEAKNESS_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 10*20,0),0.7F))
            .build();
    public static final FoodComponent WEAKNESS_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(0.2F)
            .build();
    public static final Item PALLID_APPLE = register(
            "pallid_apple",
            Item::new,
            new Item.Settings().food(WEAKNESS_FOOD_COMPONENT,WEAKNESS_FOOD_CONSUMABLE_COMPONENT)
    );

    public static final FoodComponent WEAKNESS_BERRY_COMPONENT = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.05F)
            .alwaysEdible()
            .build();
    public static final Item BLEAK_BERRIES = register(
            "bleak_berries",
            settings -> new BlockItem(ModBlocks.BLEAK_BERRY_BUSH, settings),
            new Item.Settings().food(WEAKNESS_BERRY_COMPONENT,WEAKNESS_FOOD_CONSUMABLE_COMPONENT)
    );

    public static final FoodComponent PALE_PUMPKIN_PIE_COMPONENT = new FoodComponent.Builder()
            .nutrition(9)
            .saturationModifier(0.3F)
            .build();
    public static final Item PALE_PUMPKIN_PIE = register(
            "pale_pumpkin_pie",
            Item::new,
            new Item.Settings().food(PALE_PUMPKIN_PIE_COMPONENT,WEAKNESS_FOOD_CONSUMABLE_COMPONENT)
    );

    public static final FoodComponent INKCAP_STEW_COMPONENT = new FoodComponent.Builder()
            .nutrition(5)
            .saturationModifier(0.3F)
            .build();
    public static final Item INKCAP_STEW = register(
            "inkcap_stew",
            Item::new,
            new Item.Settings().maxCount(1).food(INKCAP_STEW_COMPONENT).useRemainder(Items.BOWL)
    );

    public static final FoodComponent TURNIP_COMPONENT = new FoodComponent.Builder()
            .nutrition(7)
            .saturationModifier(0.0F)
            .build();
    public static final Item TURNIP = register(
            "turnip",
            settings -> new BlockItem(ModBlocks.TURNIP_CROP, settings),
            new Item.Settings().food(TURNIP_COMPONENT)
    );

    public static final FoodComponent COOKED_TURNIP_COMPONENT = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.6F)
            .build();
    public static final Item COOKED_TURNIP = register("cooked_turnip", Item::new, new Item.Settings().food(COOKED_TURNIP_COMPONENT)
    );

    public static final ConsumableComponent IRON_TURNIP_EFFECT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20*20,0),1F))
            .build();
    public static final FoodComponent IRON_TURNIP_COMPONENT = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(1.2f)
            .build();
    public static final Item IRON_TURNIP = register("iron_turnip", Item::new, new Item.Settings().food(IRON_TURNIP_COMPONENT, IRON_TURNIP_EFFECT));


    /* Add an item to the item group indicated by one of the following functions' names. */
    /* To be clear, since these are vanilla groups, these are not handled in ModItemGroups.java. */
    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
//                AETHEREAL_ELYTRA,
                RUBY_AXE,
                RUBY_HOE,
                RUBY_PICKAXE,
                RUBY_SHOVEL,
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
                BLEAK_BERRIES,
                CLAY_JAR,
                CLEANED_FLESH,
                DISINFECTANT,
                DISINFECTANT_BASE,
                FOREST_ESSENCE,
                FROG_TOE,
                GARLIC,
                GLASS_JAR,
                ModBlocks.PALE_PUMPKIN.asItem(),
                PALLID_APPLE,
                POTION_ESSENCE_BERRY_MIX,
                RUBINITE_INGOT,
                RUBY,
                SCULK_POWDER,
                SOLANDRA,
                TURNIP,
                WEEPING_POWDER,
                WITCHCAP,
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
                ModBlocks.GHOST_LARKSPUR.asItem(),
                ModBlocks.GRASP_GRASS.asItem(),
                ModBlocks.GYPSOPHILA.asItem(),
                INKCAP_SPORES,
                ModBlocks.PALE_PUMPKIN.asItem(),
                PALE_PUMPKIN_SEEDS,
                SOLANDRA_SEEDS,
                WITCHCAP_SPORES,
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
                INFERNAL_BLADE,
                QUARTZ_BOOTS,
                QUARTZ_CHESTPLATE,
                QUARTZ_HELMET,
                QUARTZ_LEGGINGS,
                QUARTZ_SWORD,
                RUBINITE_HELMET,
                RUBINITE_CHESTPLATE,
                RUBINITE_LEGGINGS,
                RUBINITE_BOOTS,
                RUBY_BOOTS,
                RUBY_CHESTPLATE,
                RUBY_HELMET,
                RUBY_LEGGINGS,
                RUBY_SWORD,
                WITHER_SWORD,
        };
        for (Item item : items) {
            entries.add(item);
        }
    }

    private static void addItemsToFoodDrinkItemGroup(FabricItemGroupEntries entries) {
        Item[] items = {
                BLEAK_BERRIES,
                INKCAP_STEW,
                PALE_PUMPKIN_PIE,
                PALLID_APPLE,
                TURNIP,
                COOKED_TURNIP,
                IRON_TURNIP,
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodDrinkItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItems::addItemsToBuildingBlocksItemGroup);
    }
}
