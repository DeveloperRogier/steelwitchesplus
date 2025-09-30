package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.sneezewipe.steelwitchesplus.item.ModItems;
import net.sneezewipe.steelwitchesplus.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.QUARTZ_ARMOR_SET.toArray(new Item[0]))
                .add(ModItems.RUBINITE_ARMOR_SET.toArray(new Item[0]))
                .add(ModItems.RUBY_ARMOR_SET.toArray(new Item[0]));
        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.QUARTZ_ARMOR_SET.toArray(new Item[0]))
                .add(ModItems.RUBINITE_ARMOR_SET.toArray(new Item[0]))
                .add(ModItems.RUBY_ARMOR_SET.toArray(new Item[0]));
        getOrCreateTagBuilder(ModTags.Items.AMETHYST_REPAIR).add(Items.AMETHYST_SHARD);
        getOrCreateTagBuilder(ModTags.Items.QUARTZ_REPAIR).add(Items.QUARTZ);
        getOrCreateTagBuilder(ModTags.Items.RUBINITE_REPAIR).add(ModItems.RUBINITE_INGOT);
        getOrCreateTagBuilder(ModTags.Items.RUBY_REPAIR).add(ModItems.RUBY);
    }
}
