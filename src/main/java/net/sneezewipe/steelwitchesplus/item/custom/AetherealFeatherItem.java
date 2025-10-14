package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;

import java.util.function.Consumer;

public class AetherealFeatherItem extends Item {
    public AetherealFeatherItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable(String.format("item.%s.aethereal_feather.tooltip.1", SteelWitchesPlus.MOD_ID)));
        textConsumer.accept(Text.translatable(String.format("item.%s.aethereal_feather.tooltip.2", SteelWitchesPlus.MOD_ID)));
        textConsumer.accept(Text.translatable(String.format("item.%s.aethereal_feather.tooltip.3", SteelWitchesPlus.MOD_ID)));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }
}
