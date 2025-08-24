package net.sneezewipe.steelwitchesplus.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import net.sneezewipe.steelwitchesplus.block.entity.DistilleryBlockEntity;

public class ModBlockEntityTypes {
    public static final BlockEntityType<DistilleryBlockEntity> DISTILLERY_BLOCK_ENTITY = register("distillery_block_entity",
        FabricBlockEntityTypeBuilder.create(DistilleryBlockEntity::new, ModBlocks.DISTILLERY_BLOCK).build());

    public static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, SteelWitchesPlus.MOD_ID, type);
    }

    public static void registerBlockEntityTypes() {

    }
}
