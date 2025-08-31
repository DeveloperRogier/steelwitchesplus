package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.util.ModTags;

import java.util.List;

public class WitherSwordItem extends SwordItem {
    public WitherSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        if (!target.hasStatusEffect(StatusEffects.WITHER))
            // This effect is pretty hard to balance. Server feedback?
            target.setStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 100, 2), attacker);
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        boolean isDecayable = blockState.isIn(ModTags.Blocks.DECAYABLE_BLOCKS) || blockState.getBlock() instanceof PlantBlock;

        if (isDecayable) {
            /* Since this function runs on client and server, make a distinction between which thread
             * spawns particles and which breaks the block. */
            if (world.isClient()) {
                ParticleEffect effect = ParticleTypes.ASH;

                for (int i = 0; i < 360; i++) {
                    if (i % 20 == 0) {
                        world.addParticle(effect, blockPos.getX() + 0.5d, blockPos.getY(), blockPos.getZ() + 0.5d,
                                0.0, -1.0, 0.0);
                    }
                }
            } else {
                world.breakBlock(blockPos, false);
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(String.format("item.%s.wither_sword.tooltip.1", SteelWitchesPlus.MOD_ID)));
        tooltip.add(Text.translatable(String.format("item.%s.wither_sword.tooltip.2", SteelWitchesPlus.MOD_ID)));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
