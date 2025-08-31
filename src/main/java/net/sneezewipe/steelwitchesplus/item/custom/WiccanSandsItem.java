package net.sneezewipe.steelwitchesplus.item.custom;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.consume.UseAction;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.scoreboard.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.sneezewipe.steelwitchesplus.SteelWitchesPlus;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

// TODO: add a crafting recipe.
// TODO: fix the fact that the item does not properly end its use process when the player scrolls away from the item
// TODO:    in the hotbar while using it.
public class WiccanSandsItem extends Item {
    private static final int MAX_USE_TIME = 72000; // 1 hour
    private static final String OBJECTIVE_NAME = "night_skip_ritual";
    private static final Text OBJECTIVE_DISPLAY_NAME = Text.of("Occult Dawn Ritual");

    public WiccanSandsItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BRUSH;
    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return MAX_USE_TIME;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient && world.isDay()) {
            return ActionResult.FAIL;
        }

        if (!world.isClient) {
            SteelWitchesPlus.LOGGER.info(String.format("started using hourglass %s", user.getStackInHand(hand)));

            Scoreboard scoreboard = world.getScoreboard();
            ScoreboardObjective objective = getOrCreateScoreboardObjective(scoreboard, OBJECTIVE_NAME);
            ScoreAccess scoreAccess = scoreboard.getOrCreateScore(ScoreHolder.WILDCARD, objective, true);

            if (world.isDay()) {
                scoreAccess.resetScore(); // Prevent score from persisting if used during daytime
                return ActionResult.FAIL;
            }

            int score = scoreAccess.getScore(); // Current number of players partaking in the "ritual"
            int requiredScore = getRequiredScore(world);
            if (++score >= requiredScore) {
                scoreAccess.resetScore();
                ((ServerWorld) world).setTimeOfDay(0);
                showHudMessage(world, "The coven has ordained the dawn breaketh...");
            } else {
                scoreAccess.lock(); // All possible race conditions might not be prevented by this...
                scoreAccess.incrementScore();
                scoreAccess.unlock();
                showScoreOnHud(world, score, requiredScore);
            }
        }

        return ItemUsage.consumeHeldItem(world, user, hand);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        SteelWitchesPlus.LOGGER.info(String.format("finishUsing call for %s", stack));
        return stopUsing(stack, world);
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        SteelWitchesPlus.LOGGER.info(String.format("onStoppedUsing call for %s", stack));
        stopUsing(stack, world);
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable(String.format("item.%s.wiccan_sands.tooltip.1", SteelWitchesPlus.MOD_ID)));
        textConsumer.accept(Text.translatable(String.format("item.%s.wiccan_sands.tooltip.2", SteelWitchesPlus.MOD_ID)));
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }

    /**
     * If {objective} exists in the scoreboard, return it. Otherwise, create it and then return it.
     * This way, scoreboard interactions by the item are guaranteed to hit.
     * @param scoreboard The scoreboard used by the server world
     * @param objective The name of the objective that tracks the number of users performing the night skip ritual
     * @return The objective that tracks the night skip ritual
     */
    private ScoreboardObjective getOrCreateScoreboardObjective(Scoreboard scoreboard, String objective) {
        @Nullable ScoreboardObjective ritualObjective = scoreboard.getNullableObjective(objective);

        if (ritualObjective == null) {
            scoreboard.addObjective(objective, ScoreboardCriterion.DUMMY, OBJECTIVE_DISPLAY_NAME, ScoreboardCriterion.RenderType.INTEGER, false, null);
            return scoreboard.getNullableObjective(objective);
        }
        return ritualObjective;
    }

    private int getRequiredScore(World world) {
        return world.getPlayers().size() / 2;
    }

    private void showScoreOnHud(World world, int score, int requiredScore) {
        showHudMessage(world,
                String.format("%d out of %d required witches are manipulating the sands...", score, requiredScore));
    }

    private void showHudMessage(World world, String message) {
        Text text = Text.of(message);
        for (PlayerEntity serverPlayerEntity : world.getPlayers()) {
            serverPlayerEntity.sendMessage(text, true);
        }
    }

    private ItemStack stopUsing(ItemStack stack, World world) {
        if (!world.isClient) {
            SteelWitchesPlus.LOGGER.info(String.format("decrementing scoreboard for %s", stack));
            Scoreboard scoreboard = world.getScoreboard();
            ScoreboardObjective objective = getOrCreateScoreboardObjective(scoreboard, OBJECTIVE_NAME);
            ScoreAccess scoreAccess = scoreboard.getOrCreateScore(ScoreHolder.WILDCARD, objective, true);
            scoreAccess.lock();
            if (scoreAccess.getScore() <= 0) {
                scoreAccess.resetScore();
            } else {
                scoreAccess.incrementScore(-1);
            }
            scoreAccess.unlock();
            showScoreOnHud(world, scoreAccess.getScore(), getRequiredScore(world));
        }
        return stack;
    }
}
