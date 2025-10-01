package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.block.custom.*;
import net.sneezewipe.steelwitchesplus.item.ModArmorMaterials;
import net.sneezewipe.steelwitchesplus.item.ModItems;

@Environment(EnvType.CLIENT)
public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool quartzPillarPool = blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.QUARTZ_PILLAR);
        quartzPillarPool.wall(ModBlocks.QUARTZ_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DISTILLERY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSingleton(ModBlocks.PALE_PUMPKIN, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_ORE);

        blockStateModelGenerator.registerCrop(ModBlocks.ARTICHOKE_CROP, ArtichokeCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.BELLADONNA_CROP, BelladonnaCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.GARLIC_CROP, GarlicCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.SOLANDRA_CROP, SolandraCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.WITCHCAP_CROP, WitchcapCropBlock.AGE, 0, 1, 2, 3, 4);
        blockStateModelGenerator.registerCrop(ModBlocks.WOLFSBANE_CROP, WolfsbaneCropBlock.AGE, 0, 1, 2, 3, 4, 5);

        blockStateModelGenerator.registerTintableCross(ModBlocks.BRAMBLE_EMBER_CROP, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.BRAMBLE_WILD_CROP, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.SKYWORT_CROP, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.INKCAP, Blocks.POTTED_AZALEA_BUSH, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerDoubleBlock(ModBlocks.GHOST_LARKSPUR, BlockStateModelGenerator.CrossType.NOT_TINTED);
        blockStateModelGenerator.registerDoubleBlock(ModBlocks.GRASP_GRASS, BlockStateModelGenerator.CrossType.NOT_TINTED);

        blockStateModelGenerator.registerFlowerbed(ModBlocks.GYPSOPHILA);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
//        itemModelGenerator.register(ModItems.AETHEREAL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.AETHEREAL_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARTICHOKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ATTUNED_STONE_DARK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ATTUNED_STONE_LIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAKED_CLAY_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BELLADONNA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLEAK_BERRIES, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLAY_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.FOREST_ESSENCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROG_TOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GARLIC, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.GHOST_LARKSPUR.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.GLASS_JAR, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.GRASP_GRASS.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.INKCAP.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.INKCAP_STEW, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALE_PUMPKIN_PIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALE_PUMPKIN_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.PALLID_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOLANDRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.WEEPING_POWDER, Models.GENERATED);
        itemModelGenerator.register(ModItems.WITCHCAP, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOLFSBANE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WICCAN_SANDS, Models.GENERATED);

        itemModelGenerator.register(ModItems.DAINTY_SLIPPERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.INFERNAL_BLADE, Models.GENERATED);

        itemModelGenerator.register(ModItems.QUARTZ_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WITHER_SWORD, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModItems.QUARTZ_HELMET, ModArmorMaterials.QUARTZ_KEY,
                ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.QUARTZ_CHESTPLATE, ModArmorMaterials.QUARTZ_KEY,
                ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.QUARTZ_LEGGINGS, ModArmorMaterials.QUARTZ_KEY,
                ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.QUARTZ_BOOTS, ModArmorMaterials.QUARTZ_KEY,
                ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

        itemModelGenerator.registerArmor(ModItems.RUBY_HELMET, ModArmorMaterials.RUBY_KEY,
                ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.RUBY_CHESTPLATE, ModArmorMaterials.RUBY_KEY,
                ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.RUBY_LEGGINGS, ModArmorMaterials.RUBY_KEY,
                ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModItems.RUBY_BOOTS, ModArmorMaterials.RUBY_KEY,
                ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }
}
