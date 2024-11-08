package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        /* Shaped recipes items */
        generateRecipeAetherealElytra(exporter);
        generateRecipeAmethystGreatsword(exporter);
        generateRecipeQuartzArmor(exporter);
        generateRecipeQuartzSword(exporter);

        /* Shaped recipes blocks */
        generateRecipeQuartzWall(exporter);

        /* Shapeless recipes items*/
        generateRecipeAetherFeather(exporter);
        generateRecipeWitherSword(exporter);

        /* Shapeless recipes blocks */
        generateStonecutterRecipeQuartzTrimBlock(exporter);
        generateStonecutterRecipeQuartzWall(exporter);
    }

    /* Shaped recipes */
    private void generateRecipeAetherealElytra(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.AETHEREAL_ELYTRA, 1)
                .pattern("F F")
                .pattern("FEF")
                .pattern("F F")
                .input('E', Items.ELYTRA).input('F', ModItems.AETHEREAL_FEATHER)
                .criterion(hasItem(Items.ELYTRA), conditionsFromItem(Items.ELYTRA))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.AETHEREAL_ELYTRA)));
    }

    private void generateRecipeAmethystGreatsword(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.AMETHYST_GREATSWORD, 1)
                .pattern(" AA")
                .pattern("AAA")
                .pattern("SA ")
                .input('A', Items.AMETHYST_SHARD).input('S', Items.STICK)
                .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.AMETHYST_GREATSWORD)));
    }

    private void generateRecipeQuartzArmor(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.QUARTZ_HELMET, 1)
                .pattern("QQQ")
                .pattern("Q Q")
                .input('Q', Items.QUARTZ)
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.QUARTZ_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.QUARTZ_CHESTPLATE, 1)
                .pattern("Q Q")
                .pattern("QQQ")
                .pattern("QQQ")
                .input('Q', Items.QUARTZ)
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.QUARTZ_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.QUARTZ_LEGGINGS, 1)
                .pattern("QQQ")
                .pattern("Q Q")
                .pattern("Q Q")
                .input('Q', Items.QUARTZ)
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.QUARTZ_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.QUARTZ_BOOTS, 1)
                .pattern("Q Q")
                .pattern("Q Q")
                .input('Q', Items.QUARTZ)
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.QUARTZ_BOOTS)));
    }

    private void generateRecipeQuartzSword(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.QUARTZ_SWORD, 1)
                .pattern(" Q ")
                .pattern(" Q ")
                .pattern(" S ")
                .input('Q', Items.QUARTZ).input('S', Items.STICK)
                .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.QUARTZ_SWORD)));
    }

    private void generateRecipeQuartzWall(RecipeExporter exporter) {
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_WALL, Blocks.QUARTZ_PILLAR);
    }


    /* Shapeless recipes */
    private void generateRecipeAetherFeather(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AETHEREAL_FEATHER, 1)
                .input(Items.FEATHER).input(Items.BLAZE_POWDER)
                .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.AETHEREAL_FEATHER)));}

    private void generateRecipeWitherSword(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WITHER_SWORD, 1)
                .input(Items.WITHER_ROSE).input(Items.WITHER_SKELETON_SKULL).input(Items.NETHERITE_SWORD)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.WITHER_SWORD)));
    }

    private void generateStonecutterRecipeQuartzTrimBlock(RecipeExporter exporter) {
        StonecuttingRecipeJsonBuilder.createStonecutting(
                    Ingredient.ofItems(Blocks.QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TRIM_QUARTZ_BLOCK, 1)
                .criterion(hasItem(Blocks.QUARTZ_BLOCK), conditionsFromItem(Blocks.QUARTZ_BLOCK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.TRIM_QUARTZ_BLOCK)+"from_quartz_stonecutting"));
    }
    private void generateStonecutterRecipeQuartzWall(RecipeExporter exporter) {
        offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_WALL, Blocks.QUARTZ_PILLAR);
    }
}
