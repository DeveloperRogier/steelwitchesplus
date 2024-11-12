package net.sneezewipe.steelwitchesplus.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class ArtichokeCropBlock extends CropBlock {
    public static final int MAX_AGE = 4;
    public static final IntProperty AGE = Properties.AGE_4;

    public ArtichokeCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.WATER);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.ARTICHOKE_SEEDS;
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
