package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.sneezewipe.steelwitchesplus.item.ModItems;
import net.sneezewipe.steelwitchesplus.item.ModItems.ArmorSet;
import net.sneezewipe.steelwitchesplus.item.ModItems.ToolSet;
import net.sneezewipe.steelwitchesplus.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        registerArmorTags(ModItems.QUARTZ_ARMOR_SET);
        registerArmorTags(ModItems.RUBINITE_ARMOR_SET);
        registerArmorTags(ModItems.RUBY_ARMOR_SET);

        registerToolTags(ModItems.RUBY_TOOL_SET);

        valueLookupBuilder(ModTags.Items.AMETHYST_REPAIR).add(Items.AMETHYST_SHARD);
        valueLookupBuilder(ModTags.Items.QUARTZ_REPAIR).add(Items.QUARTZ);
        valueLookupBuilder(ModTags.Items.RUBINITE_REPAIR).add(ModItems.RUBINITE_INGOT);
        valueLookupBuilder(ModTags.Items.RUBY_REPAIR).add(ModItems.RUBY);
    }

    private void registerArmorTags(ArmorSet armorSet) {
        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(armorSet.helmet())
                .add(armorSet.chestplate())
                .add(armorSet.leggings())
                .add(armorSet.boots());
        valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(armorSet.helmet())
                .add(armorSet.chestplate())
                .add(armorSet.leggings())
                .add(armorSet.boots());
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(armorSet.helmet());
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(armorSet.chestplate());
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(armorSet.leggings());
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(armorSet.boots());
    }

    private void registerToolTags(ToolSet toolSet) {
        valueLookupBuilder(ItemTags.AXES).add(toolSet.axe());
        valueLookupBuilder(ItemTags.HOES).add(toolSet.hoe());
        valueLookupBuilder(ItemTags.PICKAXES).add(toolSet.pickaxe());
        valueLookupBuilder(ItemTags.SHOVELS).add(toolSet.shovel());
        valueLookupBuilder(ItemTags.SWORDS).add(toolSet.sword());
    }
}
