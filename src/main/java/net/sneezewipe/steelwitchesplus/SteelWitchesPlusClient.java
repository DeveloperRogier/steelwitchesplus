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
        /* Crops*/
                ModBlocks.ARTICHOKE_CROP,
                ModBlocks.BELLADONNA_CROP,
                ModBlocks.BRAMBLE_EMBER_CROP,
                ModBlocks.BRAMBLE_WILD_CROP,
                ModBlocks.GARLIC_CROP,
                ModBlocks.SKYWORT_CROP,
                ModBlocks.SOLANDRA_CROP,
                ModBlocks.WOLFSBANE_CROP,

        /* Flowers */
                ModBlocks.WISP_WEED

        );
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
