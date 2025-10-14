package net.sneezewipe.steelwitchesplus.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> DELIRIUM = registerStatusEffect("delirium",
            new DeliriumEffect(StatusEffectCategory.HARMFUL, 0x191919));

    public static final RegistryEntry<StatusEffect> BEWITCHED = registerStatusEffect("bewitched",
            new BewitchedEffect(StatusEffectCategory.HARMFUL, 0x8B678D));

    public static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(SteelWitchesPlus.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        SteelWitchesPlus.LOGGER.info("Registering Mod Effect " + SteelWitchesPlus.MOD_ID);
    }
}
