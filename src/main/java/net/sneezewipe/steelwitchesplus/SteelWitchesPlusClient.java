package net.sneezewipe.steelwitchesplus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;

@Environment(EnvType.CLIENT)
public class SteelWitchesPlusClient implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.ARTICHOKE_CROP,
                ModBlocks.BELLADONNA_CROP,
                ModBlocks.BLEAK_BERRY_BUSH,
                ModBlocks.BRAMBLE_EMBER_CROP,
                ModBlocks.BRAMBLE_WILD_CROP,
                ModBlocks.GARLIC_CROP,
                ModBlocks.GHOST_LARKSPUR,
                ModBlocks.GRASP_GRASS,
                ModBlocks.GYPSOPHILA,
                ModBlocks.INKCAP_FLOWER,
                ModBlocks.INKCAP_CROP,
                ModBlocks.PALE_PUMPKIN_STEM,
                ModBlocks.PALE_ATTACHED_PUMPKIN_STEM,
                ModBlocks.SKYWORT_CROP,
                ModBlocks.SOLANDRA_CROP,
                ModBlocks.TURNIP_CROP,
                ModBlocks.WITCHCAP_CROP,
                ModBlocks.WOLFSBANE_CROP);
        registerFeatureRenderers();
    }

    private void registerFeatureRenderers() {
//        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
//            if (entityRenderer instanceof PlayerEntityRenderer) {
//                registrationHelper.register(new AetherealElytraFeatureRenderer<>(entityRenderer, context.getModelLoader()));
//            }
//        });
    }
}
