package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.block.custom.*;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool quartzPillarPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.QUARTZ_PILLAR);
        quartzPillarPool.wall(ModBlocks.QUARTZ_WALL);

        blockStateModelGenerator.registerCrop(ModBlocks.ARTICHOKE_CROP, ArtichokeCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.BELLADONNA_CROP, BelladonnaCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.GARLIC_CROP, GarlicCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.WOLFSBANE_CROP, WolfsbaneCropBlock.AGE, 0, 1, 2, 3, 4);

        blockStateModelGenerator.registerTintableCross(ModBlocks.BRAMBLE_EMBER_CROP, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.BRAMBLE_WILD_CROP, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SKYWORT_CROP, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.AETHEREAL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.AETHEREAL_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARTICHOKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ATTUNED_STONE_DARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ATTUNED_STONE_LIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAKED_CLAY_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BELLADONNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GARLIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLASS_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEEPING_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOLFSBANE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WICCAN_SANDS, Models.GENERATED);

        itemModelGenerator.register(ModItems.QUARTZ_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_SWORD, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.QUARTZ_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.QUARTZ_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.QUARTZ_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.QUARTZ_BOOTS);
    }
}
