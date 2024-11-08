package net.sneezewipe.steelwitchesplus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup STEELWITCHESPLUS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(SteelWitchesPlus.MOD_ID, "amethyst_greatsword"),
            FabricItemGroup.builder().displayName(Text.translatable(String.format("itemgroup.%s", SteelWitchesPlus.MOD_ID)))
                    .icon(() -> new ItemStack(ModItems.AMETHYST_GREATSWORD)).entries((displayContext, entries) -> {
                        /* Items */
                        entries.add(ModItems.AETHEREAL_FEATHER);
                        entries.add(ModItems.AETHEREAL_ELYTRA);

                        entries.add(ModItems.AMETHYST_GREATSWORD);
                        entries.add(ModItems.QUARTZ_SWORD);
                        entries.add(ModItems.WITHER_SWORD);

                        entries.add(ModItems.QUARTZ_HELMET);
                        entries.add(ModItems.QUARTZ_CHESTPLATE);
                        entries.add(ModItems.QUARTZ_LEGGINGS);
                        entries.add(ModItems.QUARTZ_BOOTS);

                        /* Blocks */
                        entries.add(ModBlocks.TRIM_QUARTZ_BLOCK);
                        entries.add(ModBlocks.QUARTZ_WALL);
                    }).build());
    public static void registerItemGroups() {
        SteelWitchesPlus.LOGGER.info(String.format("Registering item groups for %s", SteelWitchesPlus.MOD_ID));
    }
}
