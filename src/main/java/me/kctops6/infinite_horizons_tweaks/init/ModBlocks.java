package me.kctops6.infinite_horizons_tweaks.init;

import me.kctops6.infinite_horizons_tweaks.InfiniteHorizonsTweaks;
import me.kctops6.infinite_horizons_tweaks.block.CustomGravelBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, InfiniteHorizonsTweaks.MOD_ID);

    // Replaces KubeJS custom gravels discovered in script files
    public static final RegistryObject<Block> ANDESITE_GRAVEL = BLOCKS.register("andesite_gravel",
            () -> new CustomGravelBlock(0x848684, BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> GRANITE_GRAVEL = BLOCKS.register("granite_gravel",
            () -> new CustomGravelBlock(0x9c6a5c, BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> DIORITE_GRAVEL = BLOCKS.register("diorite_gravel",
            () -> new CustomGravelBlock(0xbfbfbf, BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> TUFF_GRAVEL = BLOCKS.register("tuff_gravel",
            () -> new CustomGravelBlock(0x6c6d64, BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> DEEPSLATE_GRAVEL = BLOCKS.register("deepslate_gravel",
            () -> new CustomGravelBlock(0x4d4d50, BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> NETHERRACK_GRAVEL = BLOCKS.register("netherrack_gravel",
            () -> new CustomGravelBlock(0x511515, BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static final RegistryObject<Block> END_STONE_GRAVEL = BLOCKS.register("end_stone_gravel",
            () -> new CustomGravelBlock(0xdcdf9e, BlockBehaviour.Properties.copy(Blocks.GRAVEL)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}