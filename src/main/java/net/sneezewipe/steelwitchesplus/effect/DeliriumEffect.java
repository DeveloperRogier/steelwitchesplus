package net.sneezewipe.steelwitchesplus.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;

public class DeliriumEffect extends StatusEffect {
    public DeliriumEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if (entity.hasStatusEffect(ModEffects.DELIRIUM)) {
            entity.addStatusEffect(
                   new StatusEffectInstance(StatusEffects.SLOWNESS, 30, 2, true, false, false)
            );
            entity.addStatusEffect(
                    new StatusEffectInstance(StatusEffects.BLINDNESS, 30, 0, true, false, false)
            );
        }
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}