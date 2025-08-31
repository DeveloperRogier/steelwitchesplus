//package net.sneezewipe.steelwitchesplus.mixin;
//
//import com.llamalad7.mixinextras.injector.ModifyReturnValue;
//import net.minecraft.client.render.VertexConsumerProvider;
//import net.minecraft.client.render.entity.feature.ElytraFeatureRenderer;
//import net.minecraft.client.render.entity.feature.FeatureRenderer;
//import net.minecraft.client.render.entity.feature.FeatureRendererContext;
//import net.minecraft.client.render.entity.model.EntityModel;
//import net.minecraft.client.render.entity.model.EntityModelLoader;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.entity.LivingEntity;
//import net.minecraft.item.ItemStack;
//import net.sneezewipe.steelwitchesplus.item.ModItems;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.ModifyArgs;
//import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
//
//@Mixin(ElytraFeatureRenderer.class)
//public abstract class AetherealElytraFeatureRendererMixin<T extends LivingEntity> {
//    @ModifyReturnValue(method = "render*", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
//    private static boolean render(ItemStack stack, boolean original) {
//        return original || stack.isOf(ModItems.AETHEREAL_ELYTRA);
//    }
//}