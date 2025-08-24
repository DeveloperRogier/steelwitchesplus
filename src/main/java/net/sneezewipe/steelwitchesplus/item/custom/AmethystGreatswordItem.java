package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.item.ModToolMaterials;

import java.util.List;

public class AmethystGreatswordItem extends SwordItem {
    private final float magicDamage;

//    public AmethystGreatswordItem(ToolMaterial toolMaterial, int attackDamage, float magicDamage, float attackSpeed, Settings settings) {
public AmethystGreatswordItem(ToolMaterial toolMaterial, int attackDamage, float magicDamage, float attackSpeed, Settings settings) {
//        super(toolMaterial, attackDamage, attackSpeed, settings);
//        super(toolMaterial, settings.attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, attackDamage, attackSpeed)));
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.magicDamage = magicDamage;
    }

//    @Override
//    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
//        if (slot == EquipmentSlot.MAINHAND) {
//            return this.attributeModifiers;
//        }
//        return super.getAttributeModifiers(slot);
//    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld world = (ServerWorld)target.getWorld();
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        target.damage(world, world.getDamageSources().magic(), this.magicDamage);
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(String.format("item.%s.amethyst_greatsword.tooltip.1", SteelWitchesPlus.MOD_ID)));
        tooltip.add(Text.translatable(String.format("item.%s.amethyst_greatsword.tooltip.2", SteelWitchesPlus.MOD_ID)));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
