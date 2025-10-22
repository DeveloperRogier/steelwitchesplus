package net.sneezewipe.steelwitchesplus.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class TurnipCropBlock extends CropBlock {
    public static final int MAX_AGE = 3;
    public static final IntProperty AGE = Properties.AGE_3;

    public TurnipCropBlock(AbstractBlock.Settings settings) {
        super(settings
                .mapColor(MapColor.DULL_PINK)
                .nonOpaque()
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .sounds(BlockSoundGroup.CROP)
                .pistonBehavior(PistonBehavior.DESTROY));
    }

    @Override
    protected ItemConvertible getSeedsItem() {return ModItems.TURNIP;}

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
