package net.sneezewipe.steelwitchesplus.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;

public class BewitchedEffect extends StatusEffect {
    public BewitchedEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (!world.isClient) {
            entity.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.NAUSEA,
                    30,
                    3,
                    true, false, false
            ));
            entity.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.LEVITATION,
                    30,
                    0,
                    true, false, false
            ));
        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}