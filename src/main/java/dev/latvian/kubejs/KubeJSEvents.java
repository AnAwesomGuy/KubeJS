package dev.latvian.kubejs;

import dev.latvian.kubejs.block.BlockBreakEventJS;
import dev.latvian.kubejs.block.BlockLeftClickEventJS;
import dev.latvian.kubejs.block.BlockPlaceEventJS;
import dev.latvian.kubejs.block.BlockRegistryEventJS;
import dev.latvian.kubejs.block.BlockRightClickEventJS;
import dev.latvian.kubejs.client.DebugInfoEventJS;
import dev.latvian.kubejs.command.CommandRegistryEventJS;
import dev.latvian.kubejs.crafting.handlers.AlloySmelterRecipeEventJS;
import dev.latvian.kubejs.crafting.handlers.CompressorRecipeEventJS;
import dev.latvian.kubejs.crafting.handlers.CraftingTableRecipeEventJS;
import dev.latvian.kubejs.crafting.handlers.FurnaceRecipeEventJS;
import dev.latvian.kubejs.crafting.handlers.PulverizerRecipeEventJS;
import dev.latvian.kubejs.crafting.handlers.RemoveRecipesEventJS;
import dev.latvian.kubejs.documentation.DocumentationEvent;
import dev.latvian.kubejs.entity.CheckLivingEntitySpawnEventJS;
import dev.latvian.kubejs.entity.EntitySpawnedEventJS;
import dev.latvian.kubejs.entity.LivingEntityAttackEventJS;
import dev.latvian.kubejs.entity.LivingEntityDeathEventJS;
import dev.latvian.kubejs.event.EventJS;
import dev.latvian.kubejs.item.ItemEntityInteractEventJS;
import dev.latvian.kubejs.item.ItemLeftClickEventJS;
import dev.latvian.kubejs.item.ItemPickupEventJS;
import dev.latvian.kubejs.item.ItemRegistryEventJS;
import dev.latvian.kubejs.item.ItemRightClickEmptyEventJS;
import dev.latvian.kubejs.item.ItemRightClickEventJS;
import dev.latvian.kubejs.item.ItemTossEventJS;
import dev.latvian.kubejs.player.PlayerAdvancementEventJS;
import dev.latvian.kubejs.player.PlayerChatEventJS;
import dev.latvian.kubejs.player.SimplePlayerEventJS;
import dev.latvian.kubejs.server.SimpleServerEventJS;
import dev.latvian.kubejs.world.SimpleWorldEventJS;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.UUID;

/**
 * @author LatvianModder
 */
@Mod.EventBusSubscriber(modid = KubeJS.MOD_ID)
public class KubeJSEvents
{
	public static final String POSTINIT = "postinit";
	public static final String UNLOADED = "unloaded";
	public static final String CLIENT_DEBUG_INFO = "client.debug_info";
	public static final String COMMAND_REGISTRY = "command.registry";

	public static final String SERVER_LOAD = "server.load";
	public static final String SERVER_UNLOAD = "server.unload";
	public static final String SERVER_TICK = "server.tick";

	public static final String WORLD_LOAD = "world.load";
	public static final String WORLD_UNLOAD = "world.unload";
	public static final String WORLD_TICK = "world.tick";

	public static final String PLAYER_LOGGED_IN = "player.logged_in";
	public static final String PLAYER_LOGGED_OUT = "player.logged_out";
	public static final String PLAYER_TICK = "player.tick";
	public static final String PLAYER_CHAT = "player.chat";
	public static final String PLAYER_ADVANCEMENT = "player.advancement";

	public static final String ENTITY_DEATH = "entity.death";
	public static final String ENTITY_ATTACK = "entity.attack";
	public static final String ENTITY_CHECK_SPAWN = "entity.check_spawn";
	public static final String ENTITY_SPAWNED = "entity.spawned";

	public static final String RECIPES_REMOVE_OUTPUT = "recipes.remove.output";
	public static final String RECIPES_REMOVE_INPUT = "recipes.remove.input";
	public static final String RECIPES_CRAFTING_TABLE = "recipes.crafting_table";
	public static final String RECIPES_FURNACE = "recipes.furnace";
	public static final String RECIPES_PULVERIZER = "recipes.pulverizer";
	public static final String RECIPES_COMPRESSOR = "recipes.compressor";
	public static final String RECIPES_ALLOY_SMELTER = "recipes.alloy_smelter";

	public static final String BLOCK_REGISTRY = "block.registry";
	public static final String BLOCK_RIGHT_CLICK = "block.right_click";
	public static final String BLOCK_LEFT_CLICK = "block.left_click";
	public static final String BLOCK_PLACE = "block.place";
	public static final String BLOCK_BREAK = "block.break";

	public static final String ITEM_REGISTRY = "item.registry";
	public static final String ITEM_RIGHT_CLICK = "item.right_click";
	public static final String ITEM_RIGHT_CLICK_EMPTY = "item.right_click_empty";
	public static final String ITEM_LEFT_CLICK = "item.left_click";
	public static final String ITEM_ENTITY_INTERACT = "item.entity_interact";
	public static final String ITEM_PICKUP = "item.pickup";
	public static final String ITEM_TOSS = "item.toss";

	@SubscribeEvent
	public static void registerDocumentation(DocumentationEvent event)
	{
		event.registerCustomName("void", void.class, Void.class);
		event.registerCustomName("byte", byte.class, Byte.class);
		event.registerCustomName("short", short.class, Short.class);
		event.registerCustomName("int", int.class, Integer.class);
		event.registerCustomName("long", long.class, Long.class);
		event.registerCustomName("float", float.class, Float.class);
		event.registerCustomName("double", double.class, Double.class);
		event.registerCustomName("char", char.class, Character.class);
		event.registerCustomName("string", String.class, CharSequence.class);
		event.registerCustomName("object", Object.class);
		event.registerCustomName("uuid", UUID.class);

		event.registerEvent(POSTINIT, EventJS.class);
		event.registerEvent(UNLOADED, EventJS.class);
		event.registerEvent(CLIENT_DEBUG_INFO, DebugInfoEventJS.class);
		event.registerEvent(COMMAND_REGISTRY, CommandRegistryEventJS.class);

		event.registerEvent(SERVER_LOAD, SimpleServerEventJS.class);
		event.registerEvent(SERVER_UNLOAD, SimpleServerEventJS.class);
		event.registerEvent(SERVER_TICK, SimpleServerEventJS.class);

		event.registerEvent(WORLD_LOAD, SimpleWorldEventJS.class);
		event.registerEvent(WORLD_UNLOAD, SimpleWorldEventJS.class);
		event.registerEvent(WORLD_TICK, SimpleWorldEventJS.class);

		event.registerEvent(PLAYER_LOGGED_IN, SimplePlayerEventJS.class);
		event.registerEvent(PLAYER_LOGGED_OUT, SimplePlayerEventJS.class);
		event.registerEvent(PLAYER_TICK, SimplePlayerEventJS.class);
		event.registerEvent(PLAYER_CHAT, PlayerChatEventJS.class, true);
		event.registerEvent(PLAYER_ADVANCEMENT, PlayerAdvancementEventJS.class);

		event.registerEvent(ENTITY_DEATH, LivingEntityDeathEventJS.class, true);
		event.registerEvent(ENTITY_ATTACK, LivingEntityAttackEventJS.class, true);
		event.registerEvent(ENTITY_CHECK_SPAWN, CheckLivingEntitySpawnEventJS.class, true);
		event.registerEvent(ENTITY_SPAWNED, EntitySpawnedEventJS.class, true);

		event.registerEvent(RECIPES_REMOVE_OUTPUT, RemoveRecipesEventJS.class);
		event.registerEvent(RECIPES_REMOVE_INPUT, RemoveRecipesEventJS.class);
		event.registerEvent(RECIPES_CRAFTING_TABLE, CraftingTableRecipeEventJS.class);
		event.registerEvent(RECIPES_FURNACE, FurnaceRecipeEventJS.class);
		event.registerEvent(RECIPES_PULVERIZER, PulverizerRecipeEventJS.class);
		event.registerEvent(RECIPES_COMPRESSOR, CompressorRecipeEventJS.class);
		event.registerEvent(RECIPES_ALLOY_SMELTER, AlloySmelterRecipeEventJS.class);

		event.registerEvent(BLOCK_REGISTRY, BlockRegistryEventJS.class);
		event.registerEvent(BLOCK_RIGHT_CLICK, BlockRightClickEventJS.class, true);
		event.registerEvent(BLOCK_LEFT_CLICK, BlockLeftClickEventJS.class, true);
		event.registerEvent(BLOCK_PLACE, BlockPlaceEventJS.class, true);
		event.registerEvent(BLOCK_BREAK, BlockBreakEventJS.class, true);

		event.registerEvent(ITEM_REGISTRY, ItemRegistryEventJS.class);
		event.registerEvent(ITEM_RIGHT_CLICK, ItemRightClickEventJS.class, true);
		event.registerEvent(ITEM_RIGHT_CLICK_EMPTY, ItemRightClickEmptyEventJS.class);
		event.registerEvent(ITEM_LEFT_CLICK, ItemLeftClickEventJS.class);
		event.registerEvent(ITEM_ENTITY_INTERACT, ItemEntityInteractEventJS.class, true);
		event.registerEvent(ITEM_PICKUP, ItemPickupEventJS.class, true);
		event.registerEvent(ITEM_TOSS, ItemTossEventJS.class, true);
	}
}