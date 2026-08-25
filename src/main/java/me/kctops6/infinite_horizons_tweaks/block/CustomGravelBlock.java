package me.kctops6.infinite_horizons_tweaks.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GravelBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CustomGravelBlock extends GravelBlock {
    private final int dustColor;

    public CustomGravelBlock(int dustColor, Properties properties) {
        super(properties);
        this.dustColor = dustColor;
    }

    @Override
    public int getDustColor(BlockState state, BlockGetter reader, BlockPos pos) {
        return this.dustColor;
    }
}