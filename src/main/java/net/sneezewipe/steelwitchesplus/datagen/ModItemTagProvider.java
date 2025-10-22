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

        getOrCreateTagBuilder(ModTags.Items.AMETHYST_REPAIR).add(Items.AMETHYST_SHARD);
        getOrCreateTagBuilder(ModTags.Items.QUARTZ_REPAIR).add(Items.QUARTZ);
        getOrCreateTagBuilder(ModTags.Items.RUBINITE_REPAIR).add(ModItems.RUBINITE_INGOT);
        getOrCreateTagBuilder(ModTags.Items.RUBY_REPAIR).add(ModItems.RUBY);
    }

    private void registerArmorTags(ArmorSet armorSet) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(armorSet.helmet())
                .add(armorSet.chestplate())
                .add(armorSet.leggings())
                .add(armorSet.boots());
        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(armorSet.helmet())
                .add(armorSet.chestplate())
                .add(armorSet.leggings())
                .add(armorSet.boots());
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(armorSet.helmet());
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(armorSet.chestplate());
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(armorSet.leggings());
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(armorSet.boots());
    }

    private void registerToolTags(ToolSet toolSet) {
        getOrCreateTagBuilder(ItemTags.AXES).add(toolSet.axe());
        getOrCreateTagBuilder(ItemTags.HOES).add(toolSet.hoe());
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(toolSet.pickaxe());
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(toolSet.shovel());
        getOrCreateTagBuilder(ItemTags.SWORDS).add(toolSet.sword());
    }
}
