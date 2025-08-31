package net.sneezewipe.steelwitchesplus.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class WolfsbaneCropBlock extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;

    public WolfsbaneCropBlock(Settings settings) {
        super(settings.mapColor(MapColor.MAGENTA).nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY));;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.WOLFSBANE_SEEDS;
    }

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
