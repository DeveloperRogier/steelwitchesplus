package net.sneezewipe.steelwitchesplus.item.custom;

import net.fabricmc.fabric.api.entity.event.v1.EntityElytraEvents;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.event.GameEvent;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;

import java.util.List;

public class AetherealElytraItem extends ElytraItem implements FabricElytraItem {
    private static final Identifier TEXTURE_AETHEREAL_ELYTRA = Identifier.of(SteelWitchesPlus.MOD_ID, "textures/entity/aethereal_elytra.png");
    public AetherealElytraItem(Settings settings) {
        super(settings);
    }

    @Override
    public void doVanillaElytraTick(LivingEntity entity, ItemStack chestStack) {
        int nextRoll = entity.getFallFlyingTicks() + 1;
        if (!entity.getWorld().isClient && nextRoll % 10 == 0) {
            entity.emitGameEvent(GameEvent.ELYTRA_GLIDE);
        }
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(String.format("item.%s.aethereal_elytra.tooltip.1", SteelWitchesPlus.MOD_ID)));
        tooltip.add(Text.translatable(String.format("item.%s.aethereal_elytra.tooltip.2", SteelWitchesPlus.MOD_ID)));
        tooltip.add(Text.translatable(String.format("item.%s.aethereal_elytra.tooltip.3", SteelWitchesPlus.MOD_ID)));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
