package net.sneezewipe.steelwitchesplus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.sneezewipe.steelwitchesplus.block.ModBlocks;
import net.sneezewipe.steelwitchesplus.item.ModItems;
import net.sneezewipe.steelwitchesplus.render.AetherealElytraFeatureRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Environment(EnvType.CLIENT)
public class SteelWitchesPlusClient implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
                ModBlocks.ARTICHOKE_CROP,
                ModBlocks.BELLADONNA_CROP,
                ModBlocks.BRAMBLE_EMBER_CROP,
                ModBlocks.BRAMBLE_WILD_CROP,
                ModBlocks.GARLIC_CROP,
                ModBlocks.SKYWORT_CROP,
                ModBlocks.SOLANDRA_CROP,
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
