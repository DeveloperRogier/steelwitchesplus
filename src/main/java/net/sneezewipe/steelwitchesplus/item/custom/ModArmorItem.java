package net.sneezewipe.steelwitchesplus.item.custom;

import com.google.common.collect.ImmutableMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.item.ModArmorMaterials;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ModArmorItem extends Item {
    private static final List<StatusEffectInstance> QUARTZ_EFFECTS = List.of(
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false, false)
    );
    private static final List<StatusEffectInstance> RUBINITE_EFFECTS = List.of(
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false, false),
            new StatusEffectInstance(StatusEffects.SLOWNESS, 200, 0, false, false, false)
    );
    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(ModArmorMaterials.QUARTZ_ARMOR_MATERIAL, QUARTZ_EFFECTS)
                    .put(ModArmorMaterials.RUBINITE_ARMOR_MATERIAL, RUBINITE_EFFECTS)
                    .build();

    public ModArmorItem(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(settings.armor(material, type));
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (isWearingFullArmor(player)) {
                evaluateArmorEffects(player);
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if(isWearingCorrectArmor(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(!hasPlayerEffect) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean isWearingFullArmor(PlayerEntity player) {
        ItemStack[] armor = getPlayerArmor(player);
        for (ItemStack armorPiece : armor) {
            if (armorPiece.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean isWearingCorrectArmor(ArmorMaterial material, PlayerEntity player) {
        ItemStack[] armor = getPlayerArmor(player);
        for (ItemStack armorPiece : armor) {
            EquippableComponent equippableComponent = armorPiece.getComponents().get(DataComponentTypes.EQUIPPABLE);
            if (equippableComponent == null || !equippableComponent.assetId().get().equals(material.assetId())) {
                return false;
            }
        }
        return true;
    }

    private ItemStack[] getPlayerArmor(PlayerEntity player) {
        return new ItemStack[]{
                player.getEquippedStack(EquipmentSlot.FEET),
                player.getEquippedStack(EquipmentSlot.LEGS),
                player.getEquippedStack(EquipmentSlot.CHEST),
                player.getEquippedStack(EquipmentSlot.HEAD)
        };
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable(String.format("item.%s.quartz_armor.tooltip.1", SteelWitchesPlus.MOD_ID)));
        textConsumer.accept(Text.translatable(String.format("item.%s.quartz_armor.tooltip.2", SteelWitchesPlus.MOD_ID)));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}
