package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool quartzPillarPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.QUARTZ_PILLAR);
        quartzPillarPool.wall(ModBlocks.QUARTZ_WALL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AETHEREAL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.AETHEREAL_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.WICCAN_SANDS, Models.GENERATED);

        itemModelGenerator.register(ModItems.QUARTZ_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_SWORD, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.QUARTZ_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.QUARTZ_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.QUARTZ_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.QUARTZ_BOOTS);
    }
}
