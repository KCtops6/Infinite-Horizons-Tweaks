package me.kctops6.infinite_horizons_tweaks;

import me.kctops6.infinite_horizons_tweaks.event.ModCommonEvents;
import me.kctops6.infinite_horizons_tweaks.init.ModBlocks;
import me.kctops6.infinite_horizons_tweaks.init.ModCreativeModeTabs;
import me.kctops6.infinite_horizons_tweaks.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(InfiniteHorizonsTweaks.MOD_ID)
public class InfiniteHorizonsTweaks {
    public static final String MOD_ID = "infinite_horizons_tweaks";

    public InfiniteHorizonsTweaks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(ModCommonEvents.class);
    }
}