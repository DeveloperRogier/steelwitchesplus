package net.sneezewipe.steelwitchesplus.potion;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.block.Portal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.effect.ModEffects;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class ModPotions {

    public static final RegistryEntry<Potion> DELIRIUM_POTION = registerPotion(
            "delirium_potion",
            new Potion("potion.steelwitchesplus.delirium",
                    new StatusEffectInstance(ModEffects.DELIRIUM, 20 * 20, 0))
    );

//    public static final RegistryEntry<Potion> POTION_BIG_REGENERATION = registerPotion("potion_big_regeneration",
//            new Potion(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 1)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(SteelWitchesPlus.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        SteelWitchesPlus.LOGGER.info("Registering potions for " + SteelWitchesPlus.MOD_ID);
        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        /* Example recipe registration */
//        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
//            builder.registerPotionRecipe(Potions.WATER, ModItems.BELLADONNA, ModPotions.POTION_BIG_REGENERATION);
//        });
    }
}
