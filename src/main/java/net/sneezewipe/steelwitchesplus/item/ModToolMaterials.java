package net.sneezewipe.steelwitchesplus.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.sneezewipe.steelwitchesplus.util.ModTags;

public class ModToolMaterials {
    public static ToolMaterial AMETHYST = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1200, // Durability
            6.0f, // Speed
            2.0f, // Attack damage bonus
            10, // Enchantment value
            ModTags.Items.AMETHYST_REPAIR);
    public static ToolMaterial QUARTZ = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 800, 5.0f, 2.0f, 14, ModTags.Items.QUARTZ_REPAIR);
    public static ToolMaterial RUBY = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 450, 13.0f, -1.0f, 12, ModTags.Items.RUBY_REPAIR);
}
