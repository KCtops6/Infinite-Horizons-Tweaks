package me.kctops6.infinite_horizons_tweaks.init;

import me.kctops6.infinite_horizons_tweaks.InfiniteHorizonsTweaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> MINEABLE_WITH_TROWEL = tag("mineable/trowel");
        public static final TagKey<Block> MINEABLE_WITH_HAMMER = tag("mineable/hammer");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(InfiniteHorizonsTweaks.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> HAMMERS = tag("hammers");
        public static final TagKey<Item> TROWELS = tag("trowels");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(InfiniteHorizonsTweaks.MOD_ID, name));
        }
    }
}