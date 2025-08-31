package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class AttunedStoneLightItem extends Item {
    public AttunedStoneLightItem(net.minecraft.item.Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.BLOCK_SMALL_AMETHYST_BUD_PLACE,
                SoundCategory.NEUTRAL,
                1.5F,
                0.6F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        return ActionResult.SUCCESS;
    }
}
