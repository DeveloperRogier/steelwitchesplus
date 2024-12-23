package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class AttunedStoneDarkItem extends Item {
    public AttunedStoneDarkItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.BLOCK_SMALL_AMETHYST_BUD_PLACE,
                SoundCategory.NEUTRAL,
                1.5F,
                0.1F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
