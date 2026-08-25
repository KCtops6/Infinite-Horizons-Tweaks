package me.kctops6.infinite_horizons_tweaks.init;

import me.kctops6.infinite_horizons_tweaks.InfiniteHorizonsTweaks;
import me.kctops6.infinite_horizons_tweaks.item.HammerItem;
import me.kctops6.infinite_horizons_tweaks.item.TrowelItem;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, InfiniteHorizonsTweaks.MOD_ID);

    // ===== TROWELS =====

    public static final RegistryObject<Item> WOODEN_TROWEL =
            ITEMS.register("wooden_trowel",
                    () -> new TrowelItem(Tiers.WOOD, 1.5F, -3.0F,
                            new Item.Properties()));

    public static final RegistryObject<Item> STONE_TROWEL =
            ITEMS.register("stone_trowel",
                    () -> new TrowelItem(Tiers.STONE, 1.5F, -3.0F,
                            new Item.Properties()));

    public static final RegistryObject<Item> IRON_TROWEL =
            ITEMS.register("iron_trowel",
                    () -> new TrowelItem(Tiers.IRON, 1.5F, -3.0F,
                            new Item.Properties()));

    // ===== HAMMERS =====

    public static final RegistryObject<Item> STONE_HAMMER =
            ITEMS.register("stone_hammer",
                    () -> new HammerItem(Tiers.STONE, 2.0F, -3.2F,
                            new Item.Properties()));

    public static final RegistryObject<Item> IRON_HAMMER =
            ITEMS.register("iron_hammer",
                    () -> new HammerItem(Tiers.IRON, 2.0F, -3.2F,
                            new Item.Properties()));

    // ===== PEBBLES =====

    public static final RegistryObject<Item> STONE_PEBBLE =
            ITEMS.register("stone_pebble",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ANDESITE_PEBBLE =
            ITEMS.register("andesite_pebble",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GRANITE_PEBBLE =
            ITEMS.register("granite_pebble",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DIORITE_PEBBLE =
            ITEMS.register("diorite_pebble",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DEEPSLATE_PEBBLE =
            ITEMS.register("deepslate_pebble",
                    () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TUFF_PEBBLE =
            ITEMS.register("tuff_pebble",
                    () -> new Item(new Item.Properties()));

    // ===== BLOCK ITEMS =====

    public static final RegistryObject<Item> ANDESITE_GRAVEL_ITEM =
            registerBlockItem("andesite_gravel", ModBlocks.ANDESITE_GRAVEL);

    public static final RegistryObject<Item> GRANITE_GRAVEL_ITEM =
            registerBlockItem("granite_gravel", ModBlocks.GRANITE_GRAVEL);

    public static final RegistryObject<Item> DIORITE_GRAVEL_ITEM =
            registerBlockItem("diorite_gravel", ModBlocks.DIORITE_GRAVEL);

    public static final RegistryObject<Item> TUFF_GRAVEL_ITEM =
            registerBlockItem("tuff_gravel", ModBlocks.TUFF_GRAVEL);

    public static final RegistryObject<Item> DEEPSLATE_GRAVEL_ITEM =
            registerBlockItem("deepslate_gravel", ModBlocks.DEEPSLATE_GRAVEL);

    public static final RegistryObject<Item> NETHERRACK_GRAVEL_ITEM =
            registerBlockItem("netherrack_gravel", ModBlocks.NETHERRACK_GRAVEL);

    public static final RegistryObject<Item> END_STONE_GRAVEL_ITEM =
            registerBlockItem("end_stone_gravel", ModBlocks.END_STONE_GRAVEL);

    private static <T extends Block> RegistryObject<Item> registerBlockItem(
            String name,
            RegistryObject<T> block
    ) {
        return ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static final RegistryObject<Item> IRON_FILE = ITEMS.register("iron_file",
            () -> new Item(new Item.Properties().durability(250)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}