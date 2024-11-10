package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;

import java.util.List;

public class AetherealFeatherItem extends Item {
    public AetherealFeatherItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(String.format("item.%s.aethereal_feather.tooltip.1", SteelWitchesPlus.MOD_ID)));
        tooltip.add(Text.translatable(String.format("item.%s.aethereal_feather.tooltip.2", SteelWitchesPlus.MOD_ID)));
        tooltip.add(Text.translatable(String.format("item.%s.aethereal_feather.tooltip.3", SteelWitchesPlus.MOD_ID)));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
