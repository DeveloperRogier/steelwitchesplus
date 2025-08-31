package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;

import java.util.function.Consumer;

public class AmethystGreatswordItem extends Item {
    private final float magicDamage;

//    public AmethystGreatswordItem(ToolMaterial toolMaterial, int attackDamage, float magicDamage, float attackSpeed, Settings settings) {
public AmethystGreatswordItem(ToolMaterial toolMaterial, int attackDamage, float magicDamage, float attackSpeed, Settings settings) {
//        super(toolMaterial, attackDamage, attackSpeed, settings);
//        super(toolMaterial, settings.attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.AMETHYST, attackDamage, attackSpeed)));
        super(settings.sword(toolMaterial, attackDamage, attackSpeed));
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
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld world = (ServerWorld)target.getWorld();
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        target.damage(world, world.getDamageSources().magic(), this.magicDamage);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable(String.format("item.%s.amethyst_greatsword.tooltip.1", SteelWitchesPlus.MOD_ID)));
        textConsumer.accept(Text.translatable(String.format("item.%s.amethyst_greatsword.tooltip.2", SteelWitchesPlus.MOD_ID)));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}
