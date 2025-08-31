package net.sneezewipe.steelwitchesplus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.item.ModItems;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                /* Shaped recipes items */
//                generateRecipeAetherealElytra(recipeExporter);
                generateRecipeAmethystGreatsword(recipeExporter);
                generateRecipeClayJar(recipeExporter);
                generateRecipeForestEssence(recipeExporter);
                generateRecipeGlassJar(recipeExporter);
                generateRecipeQuartzArmor(recipeExporter);
                generateRecipeQuartzSword(recipeExporter);
                generateRecipeWiccanSands(recipeExporter);

                /* Shaped recipes blocks */
                generateRecipeQuartzWall(recipeExporter);

                /* Shapeless recipes items */
                generateRecipeAetherFeather(recipeExporter);
                generateRecipeGarlicClove(recipeExporter);
                generateRecipeWitherSword(recipeExporter);

                /* Shapeless recipes blocks */
                generateStonecutterRecipeQuartzTrimBlock(recipeExporter);
                generateStonecutterRecipeQuartzWall(recipeExporter);

                /* (Blast) furnace recipes */
                generateBlastFurnaceRecipeWitchesPowders(recipeExporter, Map.of(
                        Items.AMETHYST_SHARD, ModItems.AMETHYST_DUST,
                        Items.WEEPING_VINES, ModItems.WEEPING_POWDER,
                        Items.ECHO_SHARD, ModItems.SCULK_POWDER
                ));
                generateFurnaceRecipeBakedClayJar(recipeExporter);
            }

            /* Shaped recipes */
//            private void generateRecipeAetherealElytra(RecipeExporter exporter) {
//                createShaped(RecipeCategory.TRANSPORTATION, ModItems.AETHEREAL_ELYTRA, 1)
//                        .pattern("F F")
//                        .pattern("FEF")
//                        .pattern("F F")
//                        .input('E', Items.ELYTRA).input('F', ModItems.AETHEREAL_FEATHER)
//                        .criterion(hasItem(Items.ELYTRA), conditionsFromItem(Items.ELYTRA))
//                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.AETHEREAL_ELYTRA))));
//            }

            private void generateRecipeAmethystGreatsword(RecipeExporter exporter) {
                createShaped(RecipeCategory.COMBAT, ModItems.AMETHYST_GREATSWORD, 1)
                        .pattern(" AA")
                        .pattern("AAA")
                        .pattern("SA ")
                        .input('A', Items.AMETHYST_SHARD).input('S', Items.STICK)
                        .criterion(hasItem(Items.AMETHYST_SHARD), conditionsFromItem(Items.AMETHYST_SHARD))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.AMETHYST_GREATSWORD))));
            }

            private void generateRecipeClayJar(RecipeExporter exporter) {
                createShaped(RecipeCategory.BREWING, ModItems.CLAY_JAR, 1)
                        .pattern("C C")
                        .pattern(" C ")
                        .input('C', Items.CLAY_BALL)
                        .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.CLAY_JAR))));
            }

            private void generateRecipeForestEssence(RecipeExporter exporter) {
                createShaped(RecipeCategory.MISC, ModItems.FOREST_ESSENCE, 1)
                        .pattern("SMS")
                        .pattern("MFM")
                        .pattern("SMS")
                        .input('S', Items.SHORT_GRASS).input('M', Items.MOSS_BLOCK).input('F', Items.FERN)
                        .criterion(hasItem(Items.MOSS_BLOCK), conditionsFromItem(Items.MOSS_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.FOREST_ESSENCE))));
            }

            private void generateRecipeGlassJar(RecipeExporter exporter) {
                createShaped(RecipeCategory.BREWING, ModItems.GLASS_JAR, 5)
                        .pattern("G G")
                        .pattern("GGG")
                        .input('G', Items.GLASS)
                        .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.GLASS_JAR))));
            }

            private void generateRecipeQuartzArmor(RecipeExporter exporter) {
                createShaped(RecipeCategory.COMBAT, ModItems.QUARTZ_HELMET, 1)
                        .pattern("QQQ")
                        .pattern("Q Q")
                        .input('Q', Items.QUARTZ)
                        .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.QUARTZ_HELMET))));

                createShaped(RecipeCategory.COMBAT, ModItems.QUARTZ_CHESTPLATE, 1)
                        .pattern("Q Q")
                        .pattern("QQQ")
                        .pattern("QQQ")
                        .input('Q', Items.QUARTZ)
                        .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.QUARTZ_CHESTPLATE))));

                createShaped(RecipeCategory.COMBAT, ModItems.QUARTZ_LEGGINGS, 1)
                        .pattern("QQQ")
                        .pattern("Q Q")
                        .pattern("Q Q")
                        .input('Q', Items.QUARTZ)
                        .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.QUARTZ_LEGGINGS))));

                createShaped(RecipeCategory.COMBAT, ModItems.QUARTZ_BOOTS, 1)
                        .pattern("Q Q")
                        .pattern("Q Q")
                        .input('Q', Items.QUARTZ)
                        .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.QUARTZ_BOOTS))));
            }

            private void generateRecipeQuartzSword(RecipeExporter exporter) {
                createShaped(RecipeCategory.COMBAT, ModItems.QUARTZ_SWORD, 1)
                        .pattern(" Q ")
                        .pattern(" Q ")
                        .pattern(" S ")
                        .input('Q', Items.QUARTZ).input('S', Items.STICK)
                        .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.QUARTZ_SWORD))));
            }

            private void generateRecipeQuartzWall(RecipeExporter exporter) {
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_WALL, Blocks.QUARTZ_PILLAR);
            }

            private void generateRecipeWiccanSands(RecipeExporter exporter) {
                createShaped(RecipeCategory.TOOLS, ModItems.WICCAN_SANDS, 1)
                        .pattern("GLG")
                        .pattern("GSG")
                        .pattern("GDG")
                        .input('G', Items.GOLD_INGOT).input('L', ModItems.ATTUNED_STONE_LIGHT)
                        .input('D', ModItems.ATTUNED_STONE_DARK).input('S', Items.SAND)
                        .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.WICCAN_SANDS))));
            }


            /* Shapeless recipes */
            private void generateRecipeAetherFeather(RecipeExporter exporter) {
                createShapeless(RecipeCategory.MISC, ModItems.AETHEREAL_FEATHER, 1)
                        .input(Items.FEATHER).input(Items.BLAZE_POWDER)
                        .criterion(hasItem(Items.FEATHER), conditionsFromItem(Items.FEATHER))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.AETHEREAL_FEATHER))));
            }

            private void generateRecipeGarlicClove(RecipeExporter exporter) {
                createShapeless(RecipeCategory.MISC, ModItems.GARLIC_CLOVE, 3)
                        .input(ModItems.GARLIC)
                        .criterion(hasItem(ModItems.GARLIC), conditionsFromItem(ModItems.GARLIC))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.GARLIC))));
            }

            private void generateRecipeWitherSword(RecipeExporter exporter) {
                createShapeless(RecipeCategory.COMBAT, ModItems.WITHER_SWORD, 1)
                        .input(Items.WITHER_ROSE).input(Items.WITHER_SKELETON_SKULL).input(Items.NETHERITE_SWORD)
                        .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.WITHER_SWORD))));
            }

            private void generateStonecutterRecipeQuartzTrimBlock(RecipeExporter exporter) {
                StonecuttingRecipeJsonBuilder.createStonecutting(
                                Ingredient.ofItems(Blocks.QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TRIM_QUARTZ_BLOCK, 1)
                        .criterion(hasItem(Blocks.QUARTZ_BLOCK), conditionsFromItem(Blocks.QUARTZ_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModBlocks.TRIM_QUARTZ_BLOCK)+"from_quartz_stonecutting")));
            }

            private void generateStonecutterRecipeQuartzWall(RecipeExporter exporter) {
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_WALL, Blocks.QUARTZ_PILLAR);
            }

            private void generateBlastFurnaceRecipeWitchesPowders(RecipeExporter exporter, Map<Item, Item> ingredientToPowder) {
                for (Map.Entry<Item, Item> entry : ingredientToPowder.entrySet()) {
                    CookingRecipeJsonBuilder.createBlasting(
                                    Ingredient.ofItems(entry.getKey()), RecipeCategory.MISC, entry.getValue(), 0.5f, 300)
                            .criterion(hasItem(entry.getKey()), conditionsFromItem(entry.getKey()))
                            .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(entry.getValue()))));
                }
            }

            private void generateFurnaceRecipeBakedClayJar(RecipeExporter exporter) {
                CookingRecipeJsonBuilder.createSmelting(
                                Ingredient.ofItems(ModItems.CLAY_JAR), RecipeCategory.BREWING, ModItems.BAKED_CLAY_JAR, 1.2f, 200)
                        .criterion(hasItem(ModItems.CLAY_JAR), conditionsFromItem(ModItems.CLAY_JAR))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.BAKED_CLAY_JAR))));
            }
        };
    }

    @Override
    public String getName() {
        return "SteelWitchesPlus Recipes";
    }
}
