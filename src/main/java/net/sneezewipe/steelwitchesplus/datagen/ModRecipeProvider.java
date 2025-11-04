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
import net.sneezewipe.steelwitchesplus.item.ModItems.ArmorSet;
import net.sneezewipe.steelwitchesplus.item.ModItems.ToolSet;

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
                generateRecipeDisinfectantBase(recipeExporter);
                generateRecipeForestEssence(recipeExporter);
                generateRecipeGlassJar(recipeExporter);
                generateRecipeIronTurnip(recipeExporter);
                generateRecipeQuartzSword(recipeExporter);
                generateRecipeWiccanSands(recipeExporter);
                try {
                    generateRecipeBasicArmor(recipeExporter, ModItems.QUARTZ_ARMOR_SET, Items.QUARTZ);
                    generateRecipeBasicArmor(recipeExporter, ModItems.RUBINITE_ARMOR_SET, ModItems.RUBINITE_INGOT);
                    generateRecipeBasicArmor(recipeExporter, ModItems.RUBY_ARMOR_SET, ModItems.RUBY);
                    generateRecipeBasicToolset(recipeExporter, ModItems.RUBY_TOOL_SET, ModItems.RUBY);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                /* Shaped recipes blocks */
                generateRecipeQuartzWall(recipeExporter);

                /* Shapeless recipes items */
                generateRecipeAetherFeather(recipeExporter);
                generateRecipeCleanedFlesh(recipeExporter);
                generateRecipeGarlicClove(recipeExporter);
                generateRecipeInkcapStew(recipeExporter);
                generateRecipePalePumpkinPie(recipeExporter);
                generateRecipePalePumpkinSeeds(recipeExporter);
                generateRecipeRubiniteIngot(recipeExporter);
                generateRecipeRubyFromBlock(recipeExporter);
                generateRecipeWitherSword(recipeExporter);

                /* Shapeless recipes blocks */
                generateStonecutterRecipeQuartzTrimBlock(recipeExporter);
                generateStonecutterRecipeQuartzWall(recipeExporter);
                generateRecipeRubyBlock(recipeExporter);

                /* (Blast) furnace recipes */
                generateBlastFurnaceRecipeWitchesPowders(recipeExporter, Map.of(
                        Items.AMETHYST_SHARD, ModItems.AMETHYST_DUST,
                        Items.WEEPING_VINES, ModItems.WEEPING_POWDER,
                        Items.ECHO_SHARD, ModItems.SCULK_POWDER
                ));
                generateFurnaceRecipeBakedClayJar(recipeExporter);
                generateFurnaceRecipeDisinfectant(recipeExporter);
                generateFurnaceRecipeCookedTurnip(recipeExporter);
                generateSmokerRecipeCookedTurnip(recipeExporter);

                /* Smoker recipes */
                generateSmokerRecipeLeather(recipeExporter);

                /* Campfire recipes */
                generateCampfireRecipeCookedTurnip(recipeExporter);
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

            private void generateRecipeIronTurnip(RecipeExporter exporter) {
                createShaped(RecipeCategory.FOOD, ModItems.IRON_TURNIP, 1)
                        .pattern("III")
                        .pattern("ITI")
                        .pattern("III")
                        .input('I', Items.IRON_NUGGET)
                        .input('T', ModItems.TURNIP)
                        .criterion(hasItem(ModItems.TURNIP), conditionsFromItem(ModItems.TURNIP))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.IRON_TURNIP))));
            }

            private void generateRecipeBasicArmor(RecipeExporter exporter, ArmorSet armorSet, Item ingredient) {
                createShaped(RecipeCategory.COMBAT, armorSet.helmet(), 1)
                        .pattern("###")
                        .pattern("# #")
                        .input('#', ingredient)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(armorSet.helmet()))));

                createShaped(RecipeCategory.COMBAT, armorSet.chestplate(), 1)
                        .pattern("# #")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ingredient)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(armorSet.chestplate()))));

                createShaped(RecipeCategory.COMBAT, armorSet.leggings(), 1)
                        .pattern("###")
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', ingredient)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(armorSet.leggings()))));

                createShaped(RecipeCategory.COMBAT, armorSet.boots(), 1)
                        .pattern("# #")
                        .pattern("# #")
                        .input('#', ingredient)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(armorSet.boots()))));
            }

            private void generateRecipeBasicToolset(RecipeExporter exporter, ToolSet toolSet, Item ingredient) {
                createShaped(RecipeCategory.TOOLS, toolSet.axe(), 1)
                        .pattern("##")
                        .pattern("#S")
                        .pattern(" S")
                        .input('#', ingredient).input('S', Items.STICK)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(toolSet.axe()))));

                createShaped(RecipeCategory.TOOLS, toolSet.hoe(), 1)
                        .pattern("##")
                        .pattern(" S")
                        .pattern(" S")
                        .input('#', ingredient).input('S', Items.STICK)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(toolSet.hoe()))));

                createShaped(RecipeCategory.TOOLS, toolSet.pickaxe(), 1)
                        .pattern("###")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('#', ingredient).input('S', Items.STICK)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(toolSet.pickaxe()))));

                createShaped(RecipeCategory.TOOLS, toolSet.shovel(), 1)
                        .pattern("#")
                        .pattern("S")
                        .pattern("S")
                        .input('#', ingredient).input('S', Items.STICK)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(toolSet.shovel()))));

                createShaped(RecipeCategory.COMBAT, toolSet.sword(), 1)
                        .pattern("#")
                        .pattern("#")
                        .pattern("S")
                        .input('#', ingredient).input('S', Items.STICK)
                        .criterion(hasItem(ingredient), conditionsFromItem(ingredient))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(toolSet.sword()))));
            }

            private void generateRecipeQuartzSword(RecipeExporter exporter) {
                createShaped(RecipeCategory.COMBAT, ModItems.QUARTZ_SWORD, 1)
                        .pattern("Q")
                        .pattern("Q")
                        .pattern("S")
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

            private void generateRecipeCleanedFlesh(RecipeExporter exporter) {
                createShapeless(RecipeCategory.MISC, ModItems.CLEANED_FLESH, 8)
                        .input(Items.ROTTEN_FLESH, 8).input(ModItems.DISINFECTANT)
                        .criterion(hasItem(Items.ROTTEN_FLESH), conditionsFromItem(Items.ROTTEN_FLESH))
                        .criterion(hasItem(ModItems.DISINFECTANT), conditionsFromItem(ModItems.DISINFECTANT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.CLEANED_FLESH))));
            }

            private void generateRecipeDisinfectantBase(RecipeExporter exporter) {
                createShapeless(RecipeCategory.MISC, ModItems.DISINFECTANT_BASE, 1)
                        .input(Items.GLASS_BOTTLE).input(Items.SLIME_BALL).input(Items.DANDELION)
                        .criterion(hasItem(Items.SLIME_BALL), conditionsFromItem(Items.SLIME_BALL))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.DISINFECTANT_BASE))));
            }

            private void generateRecipeGarlicClove(RecipeExporter exporter) {
                createShapeless(RecipeCategory.MISC, ModItems.GARLIC_CLOVE, 3)
                        .input(ModItems.GARLIC)
                        .criterion(hasItem(ModItems.GARLIC), conditionsFromItem(ModItems.GARLIC))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.GARLIC_CLOVE))));
            }

            private void generateRecipeInkcapStew(RecipeExporter exporter) {
                createShapeless(RecipeCategory.FOOD, ModItems.INKCAP_STEW, 1)
                        .input(ModItems.INKCAP).input(ModItems.WITCHCAP).input(Items.BOWL)
                        .criterion(hasItem(ModItems.INKCAP), conditionsFromItem(ModItems.INKCAP))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.INKCAP_STEW))));
            }

            private void generateRecipePalePumpkinPie(RecipeExporter exporter) {
                createShapeless(RecipeCategory.FOOD, ModItems.PALE_PUMPKIN_PIE, 1)
                        .input(Items.SUGAR).input(Items.EGG).input(ModBlocks.PALE_PUMPKIN)
                        .criterion(hasItem(ModBlocks.PALE_PUMPKIN), conditionsFromItem(ModBlocks.PALE_PUMPKIN))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.PALE_PUMPKIN_PIE))));
            }

            private void generateRecipePalePumpkinSeeds(RecipeExporter exporter) {
                createShapeless(RecipeCategory.MISC, ModItems.PALE_PUMPKIN_SEEDS, 4)
                        .input(ModBlocks.PALE_PUMPKIN)
                        .criterion(hasItem(ModBlocks.PALE_PUMPKIN), conditionsFromItem(ModBlocks.PALE_PUMPKIN))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName((ModItems.PALE_PUMPKIN_SEEDS)))));
            }

            private void generateRecipeRubyFromBlock(RecipeExporter exporter) {
                createShapeless(RecipeCategory.MISC, ModItems.RUBY, 9)
                        .input(ModBlocks.RUBY_BLOCK)
                        .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.RUBY))));
            }

            private void generateRecipeRubiniteIngot(RecipeExporter exporter) {
                createShapeless(RecipeCategory.MISC, ModItems.RUBINITE_INGOT, 1)
                        .input(Items.NETHERITE_INGOT).input(ModItems.RUBY)
                        .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                        .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.RUBINITE_INGOT))));
            }

            private void generateRecipeRubyBlock(RecipeExporter exporter) {
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK, 1)
                        .input(ModItems.RUBY, 9)
                        .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModBlocks.RUBY_BLOCK))));
            }

            private void generateRecipeWitherSword(RecipeExporter exporter) {
                createShapeless(RecipeCategory.COMBAT, ModItems.WITHER_SWORD, 1)
                        .input(Items.WITHER_ROSE).input(Items.WITHER_SKELETON_SKULL).input(Items.NETHERITE_SWORD)
                        .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.WITHER_SWORD))));
            }

            /* Miscellaneous recipes */
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
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.CLAY_JAR), RecipeCategory.BREWING, ModItems.BAKED_CLAY_JAR, 1.2f, 200)
                        .criterion(hasItem(ModItems.CLAY_JAR), conditionsFromItem(ModItems.CLAY_JAR))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.BAKED_CLAY_JAR))));
            }

            private void generateFurnaceRecipeDisinfectant(RecipeExporter exporter) {
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(ModItems.DISINFECTANT_BASE), RecipeCategory.MISC, ModItems.DISINFECTANT, 1.2f, 200)
                        .criterion(hasItem(ModItems.DISINFECTANT_BASE), conditionsFromItem(ModItems.DISINFECTANT_BASE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.DISINFECTANT))));
            }

            private void generateSmokerRecipeLeather(RecipeExporter exporter) {
                CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItem(ModItems.CLEANED_FLESH), RecipeCategory.MISC, Items.LEATHER, 0.5f, 600)
                        .criterion(hasItem(ModItems.CLEANED_FLESH), conditionsFromItem(ModItems.CLEANED_FLESH))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(Items.LEATHER))));
            }

            private void generateFurnaceRecipeCookedTurnip(RecipeExporter exporter) {
                CookingRecipeJsonBuilder.createSmelting(
                                Ingredient.ofItems(ModItems.TURNIP),
                                RecipeCategory.FOOD,
                                ModItems.COOKED_TURNIP,
                                0.35f,  // XP
                                200     // ticks (10 seconds)
                        ).criterion(hasItem(ModItems.TURNIP), conditionsFromItem(ModItems.TURNIP))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.COOKED_TURNIP) + "_smelting")));
            }

            private void generateSmokerRecipeCookedTurnip(RecipeExporter exporter) {
                CookingRecipeJsonBuilder.createSmoking(
                                Ingredient.ofItems(ModItems.TURNIP),
                                RecipeCategory.FOOD,
                                ModItems.COOKED_TURNIP,
                                0.35f,  // XP
                                100     // ticks (5 seconds)
                        ).criterion(hasItem(ModItems.TURNIP), conditionsFromItem(ModItems.TURNIP))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.COOKED_TURNIP) + "_smoking")));
            }

            private void generateCampfireRecipeCookedTurnip(RecipeExporter exporter) {
                CookingRecipeJsonBuilder.createCampfireCooking(
                                Ingredient.ofItems(ModItems.TURNIP),
                                RecipeCategory.FOOD,
                                ModItems.COOKED_TURNIP,
                                0.35f,  // XP
                                600     // ticks (30 seconds)
                        ).criterion(hasItem(ModItems.TURNIP), conditionsFromItem(ModItems.TURNIP))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.COOKED_TURNIP) + "_campfire")));
            }
        };
    }

    @Override
    public String getName() {
        return "SteelWitchesPlus Recipes";
    }
}
