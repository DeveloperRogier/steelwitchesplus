package net.sneezewipe.steelwitchesplus.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.sneezewipe.steelwitchesplus.block.ModBlockEntityTypes;
import net.sneezewipe.steelwitchesplus.block.entity.DistilleryBlockEntity;
import net.sneezewipe.steelwitchesplus.util.TickableBlockEntity;
import org.jetbrains.annotations.Nullable;

public class DistilleryBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final MapCodec<DistilleryBlock> CODEC = DistilleryBlock.createCodec(DistilleryBlock::new);
    public DistilleryBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient())
            return ActionResult.PASS;

        if (world.getBlockEntity(pos) instanceof DistilleryBlockEntity distilleryBlockEntity && player != null) {
            player.sendMessage(Text.of(distilleryBlockEntity.getMiningPos().toString()), true);
        }

        // Swing hand on client but not on server
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntityTypes.DISTILLERY_BLOCK_ENTITY.instantiate(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return TickableBlockEntity.getTicker(world);
    }
}
