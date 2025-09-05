package net.sneezewipe.steelwitchesplus.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.util.ModTags;

import java.util.Map;

public class ModArmorMaterials {
    public static final int BASE_DURABILITY = 15; // Same as iron.
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> QUARTZ_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(SteelWitchesPlus.MOD_ID, "quartz"));

    public static final ArmorMaterial QUARTZ_ARMOR_MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 6,
                    EquipmentType.LEGGINGS, 4,
                    EquipmentType.BOOTS, 2
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0,
            0,
            ModTags.Items.QUARTZ_REPAIR,
            QUARTZ_KEY
    );
}
