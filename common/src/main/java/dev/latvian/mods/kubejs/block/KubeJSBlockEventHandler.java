package dev.latvian.mods.kubejs.block;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.utils.value.IntValue;
import dev.latvian.mods.kubejs.KubeJSEvents;
import dev.latvian.mods.kubejs.bindings.BlockWrapper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * @author LatvianModder
 */
public class KubeJSBlockEventHandler {

	public static void init() {
		InteractionEvent.RIGHT_CLICK_BLOCK.register(KubeJSBlockEventHandler::rightClick);
		InteractionEvent.LEFT_CLICK_BLOCK.register(KubeJSBlockEventHandler::leftClick);
		BlockEvent.BREAK.register(KubeJSBlockEventHandler::blockBreak);
		BlockEvent.PLACE.register(KubeJSBlockEventHandler::blockPlace);
	}

	private static String getBlockId(Block block) {
		return String.valueOf(BlockWrapper.getId(block));
	}

	private static EventResult rightClick(Player player, InteractionHand hand, BlockPos pos, Direction direction) {
		if (player != null && player.level instanceof ServerLevel && !player.getCooldowns().isOnCooldown(player.getItemInHand(hand).getItem()) && KubeJSEvents.BLOCK_RIGHT_CLICKED.post(getBlockId(player.level.getBlockState(pos).getBlock()), new BlockRightClickedEventJS(player, hand, pos, direction))) {
			return EventResult.interruptFalse();
		}

		return EventResult.pass();
	}

	private static EventResult leftClick(Player player, InteractionHand hand, BlockPos pos, Direction direction) {
		if (player != null && player.level instanceof ServerLevel && KubeJSEvents.BLOCK_LEFT_CLICKED.post(getBlockId(player.level.getBlockState(pos).getBlock()), new BlockLeftClickedEventJS(player, hand, pos, direction))) {
			return EventResult.interruptFalse();
		}

		return EventResult.pass();
	}

	private static EventResult blockBreak(Level level, BlockPos pos, BlockState state, ServerPlayer player, @Nullable IntValue xp) {
		if (level instanceof ServerLevel && player != null && KubeJSEvents.BLOCK_BROKEN.post(getBlockId(state.getBlock()), new BlockBrokenEventJS(player, level, pos, state, xp))) {
			return EventResult.interruptFalse();
		}

		return EventResult.pass();
	}

	private static EventResult blockPlace(Level level, BlockPos pos, BlockState state, @Nullable Entity placer) {
		if (level instanceof ServerLevel && (placer == null || placer.level != null) && KubeJSEvents.BLOCK_PLACED.post(getBlockId(state.getBlock()), new BlockPlacedEventJS(placer, level, pos, state))) {
			return EventResult.interruptFalse();
		}

		return EventResult.pass();
	}

}