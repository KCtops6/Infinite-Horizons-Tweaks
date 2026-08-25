package me.kctops6.infinite_horizons_tweaks.event;

import me.kctops6.infinite_horizons_tweaks.InfiniteHorizonsTweaks;
import me.kctops6.infinite_horizons_tweaks.init.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModCommonEvents {

    // Define your custom item tags so Java can map them to your JSON tags
    public static final TagKey<Item> HAMMERS = TagKey.create(Registries.ITEM,
            new ResourceLocation(InfiniteHorizonsTweaks.MOD_ID, "hammers"));

    public static final TagKey<Item> TROWELS = TagKey.create(Registries.ITEM,
            new ResourceLocation(InfiniteHorizonsTweaks.MOD_ID, "trowels"));

    @SubscribeEvent
    public static void onBlockBreakWithSpecialTools(BlockEvent.BreakEvent event) {
        // Safety 1: Protect against null players or creative mode
        if (event.getPlayer() == null || event.getPlayer().isCreative()) return;

        Level level = (Level) event.getLevel();
        if (level.isClientSide()) return;

        // Safety 2: Protect against completely null or empty itemstacks in the hand
        ItemStack tool = event.getPlayer().getMainHandItem();
        if (tool == null || tool.isEmpty()) return;

        // Safety 3: Protect against null blocks or block states
        if (event.getState() == null || event.getState().getBlock() == null) return;
        Block block = event.getState().getBlock();

        // Safety 4: Protect against unregistered or null block resource locations
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(block);
        if (blockId == null) return;

        String blockStr = blockId.toString();
        Item heldItem = tool.getItem();

        RandomSource random = level.getRandom();
        List<ItemStack> dropsToSpawn = new ArrayList<>();
        boolean shouldCancelVanillaDrops = false;

        // ==========================================
        // 1. HAMMER CRUSHING LOGIC (Using Tags)
        // ==========================================
        if (tool.is(HAMMERS)) {
            String outputItemStr = null;
            if (blockStr.equals("minecraft:cobblestone")) outputItemStr = "minecraft:gravel";
            else if (blockStr.equals("minecraft:gravel")) outputItemStr = "minecraft:sand";
            else if (blockStr.equals("minecraft:andesite")) outputItemStr = "infinite_horizons_tweaks:andesite_gravel";
            else if (blockStr.equals("minecraft:diorite")) outputItemStr = "infinite_horizons_tweaks:diorite_gravel";
            else if (blockStr.equals("minecraft:granite")) outputItemStr = "infinite_horizons_tweaks:granite_gravel";
            else if (blockStr.equals("minecraft:sand")) outputItemStr = "createsifter:dust";

            if (outputItemStr != null) {
                Item target = ForgeRegistries.ITEMS.getValue(new ResourceLocation(outputItemStr));
                if (target != null && target != Items.AIR) {
                    dropsToSpawn.add(new ItemStack(target));
                    shouldCancelVanillaDrops = true;
                }
            }
        }

        // ==========================================
        // 2. TROWEL PEBBLE LOGIC (Using Tags)
        // ==========================================
        if (tool.is(TROWELS)) {
            boolean isDirtType = blockStr.equals("minecraft:dirt") || blockStr.equals("minecraft:grass_block") || blockStr.equals("minecraft:dirt_path");
            boolean isGravelType = blockStr.equals("minecraft:gravel") ||
                    blockStr.equals("infinite_horizons_tweaks:andesite_gravel") ||
                    blockStr.equals("infinite_horizons_tweaks:granite_gravel") ||
                    blockStr.equals("infinite_horizons_tweaks:diorite_gravel");

            // WOODEN TROWEL
            if (heldItem == ModItems.WOODEN_TROWEL.get() && isDirtType) {
                if (random.nextFloat() < 0.25f) {
                    dropsToSpawn.add(new ItemStack(ModItems.STONE_PEBBLE.get()));
                    shouldCancelVanillaDrops = true;
                }
            }
            // STONE TROWEL
            else if (heldItem == ModItems.STONE_TROWEL.get()) {
                if (isDirtType) {
                    if (random.nextFloat() < 0.5f) dropsToSpawn.add(new ItemStack(ModItems.STONE_PEBBLE.get()));
                    if (random.nextFloat() < 0.25f) {
                        dropsToSpawn.add(new ItemStack(ModItems.ANDESITE_PEBBLE.get()));
                        dropsToSpawn.add(new ItemStack(ModItems.GRANITE_PEBBLE.get()));
                        dropsToSpawn.add(new ItemStack(ModItems.DIORITE_PEBBLE.get()));
                    }
                    if (!dropsToSpawn.isEmpty() && random.nextFloat() < 0.5f) shouldCancelVanillaDrops = true;
                } else if (isGravelType && random.nextFloat() < 0.5f) {
                    dropsToSpawn.add(new ItemStack(ModItems.STONE_PEBBLE.get()));
                    if (random.nextFloat() < 0.25f) dropsToSpawn.add(new ItemStack(Items.IRON_NUGGET));
                    shouldCancelVanillaDrops = true;
                }
            }
            // IRON TROWEL
            else if (heldItem == ModItems.IRON_TROWEL.get()) {
                if (isDirtType) {
                    if (random.nextFloat() < 0.75f) dropsToSpawn.add(new ItemStack(ModItems.STONE_PEBBLE.get()));
                    if (random.nextFloat() < 0.5f) {
                        dropsToSpawn.add(new ItemStack(ModItems.ANDESITE_PEBBLE.get()));
                        dropsToSpawn.add(new ItemStack(ModItems.GRANITE_PEBBLE.get()));
                        dropsToSpawn.add(new ItemStack(ModItems.DIORITE_PEBBLE.get()));
                    }
                    if (random.nextFloat() < 0.25f) dropsToSpawn.add(new ItemStack(ModItems.DEEPSLATE_PEBBLE.get()));
                    if (!dropsToSpawn.isEmpty() && random.nextFloat() < 0.75f) shouldCancelVanillaDrops = true;
                } else if (isGravelType && random.nextFloat() < 0.75f) {
                    dropsToSpawn.add(new ItemStack(ModItems.STONE_PEBBLE.get()));
                    if (random.nextFloat() < 0.5f) dropsToSpawn.add(new ItemStack(Items.IRON_NUGGET));
                    shouldCancelVanillaDrops = true;
                } else if (blockStr.equals("infinite_horizons_tweaks:tuff_gravel") && random.nextFloat() < 0.75f) {
                    dropsToSpawn.add(new ItemStack(ModItems.TUFF_PEBBLE.get()));
                    if (random.nextFloat() < 0.25f) dropsToSpawn.add(new ItemStack(ModItems.DEEPSLATE_PEBBLE.get()));
                    shouldCancelVanillaDrops = true;
                } else if (blockStr.equals("infinite_horizons_tweaks:deepslate_gravel") && random.nextFloat() < 0.75f) {
                    dropsToSpawn.add(new ItemStack(ModItems.DEEPSLATE_PEBBLE.get()));
                    if (random.nextFloat() < 0.25f) dropsToSpawn.add(new ItemStack(ModItems.TUFF_PEBBLE.get()));
                    shouldCancelVanillaDrops = true;
                }
            }
        }

        // ==========================================
        // 3. EXECUTE ITEM DROP SPAWNING
        // ==========================================
        if (!dropsToSpawn.isEmpty()) {
            if (shouldCancelVanillaDrops) {
                level.destroyBlock(event.getPos(), false);
            }

            for (ItemStack stack : dropsToSpawn) {
                ItemEntity entity = new ItemEntity(level,
                        event.getPos().getX() + 0.5D,
                        event.getPos().getY() + 0.5D,
                        event.getPos().getZ() + 0.5D,
                        stack);
                entity.setDefaultPickUpDelay();
                level.addFreshEntity(entity);
            }
        }
    }
}