package net.sneezewipe.steelwitchesplus.item;

import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.util.ModTags;

import java.util.EnumMap;

public class ModArmorMaterials {
//    public static EquipmentModel QUARTZ = EquipmentModel.builder().addHumanoidLayers(Identifier.of(Items.QUARTZ.toString())).build();
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> QUARTZ_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(SteelWitchesPlus.MOD_ID, "quartz"));

    public static final ArmorMaterial QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(800, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 6);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 2);
        map.put(EquipmentType.BODY, 6);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0, 0, ModTags.Items.QUARTZ_REPAIR, QUARTZ_KEY);
}
