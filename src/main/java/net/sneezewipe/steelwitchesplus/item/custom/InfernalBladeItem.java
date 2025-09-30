package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class InfernalBladeItem extends Item {
    public InfernalBladeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings.sword(material, attackDamage, attackSpeed));
    }
}