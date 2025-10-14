package net.sneezewipe.steelwitchesplus.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemConvertible;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class WitchcapCropBlock extends CropBlock {
    public static final int MAX_AGE = 4;
    public static final IntProperty AGE = Properties.AGE_4;

    public WitchcapCropBlock(AbstractBlock.Settings settings) {
        super(settings
                .mapColor(MapColor.BROWN)
                .nonOpaque()
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .sounds(BlockSoundGroup.CROP)
                .pistonBehavior(PistonBehavior.DESTROY));
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.PODZOL);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.WITCHCAP_SPORES;
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
