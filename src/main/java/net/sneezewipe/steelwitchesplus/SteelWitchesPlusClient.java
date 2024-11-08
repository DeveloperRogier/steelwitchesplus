package net.sneezewipe.steelwitchesplus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRenderEvents;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.sneezewipe.steelwitchesplus.item.ModItems;
import net.sneezewipe.steelwitchesplus.render.AetherealElytraFeatureRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SteelWitchesPlusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerFeatureRenderers();
    }


    private void registerFeatureRenderers() {
//        LOGGER.info("HELLOOOOO registerFeatureRenderers() here");
//        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
//            if (entityRenderer instanceof PlayerEntityRenderer) {
//                registrationHelper.register(new AetherealElytraFeatureRenderer<>(entityRenderer, context.getModelLoader()));
//            }
//        });
//        LivingEntityFeatureRenderEvents.ALLOW_CAPE_RENDER.register(player -> player.getEquippedStack(EquipmentSlot.CHEST).isOf(ModItems.AETHEREAL_ELYTRA));
//        System.out.println("LET'S SEE WHERE THIS ENDS UP");
//        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) ->
//                registrationHelper.register(new AetherealElytraFeatureRenderer<>(entityRenderer, context.getModelLoader())));
    }
}
