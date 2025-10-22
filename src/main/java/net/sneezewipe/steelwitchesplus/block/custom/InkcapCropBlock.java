package net.sneezewipe.steelwitchesplus.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.sneezewipe.steelwitchesplus.item.ModItems;

public class InkcapCropBlock extends CropBlock {
    public static final int MAX_AGE = 6;
    public static final IntProperty AGE = IntProperty.of("age", 0, MAX_AGE);

    public InkcapCropBlock(AbstractBlock.Settings settings) {
        super(settings
                .mapColor(MapColor.IRON_GRAY)
                .nonOpaque()
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .sounds(BlockSoundGroup.CROP)
                .pistonBehavior(PistonBehavior.DESTROY));
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.PALE_MOSS_BLOCK);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int age = getAge(state);
        if (age < getMaxAge() && random.nextInt(5) == 0) {
            world.setBlockState(pos, withAge(age + 1), 2);
        }
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.INKCAP_SPORES;
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