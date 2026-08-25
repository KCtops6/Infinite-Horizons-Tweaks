package me.kctops6.infinite_horizons_tweaks.init;

import me.kctops6.infinite_horizons_tweaks.InfiniteHorizonsTweaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    // Explicitly target the core REGISTRIES element instead of a static shortcut
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InfiniteHorizonsTweaks.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INFINITE_HORIZONS_TAB =
            CREATIVE_MODE_TABS.register("infinite_horizons_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.IRON_HAMMER.get()))
                    .title(Component.translatable("creativetab.infinite_horizons_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Hammers
                        output.accept(ModItems.STONE_HAMMER.get());
                        output.accept(ModItems.IRON_HAMMER.get());

                        // Trowels
                        output.accept(ModItems.WOODEN_TROWEL.get());
                        output.accept(ModItems.STONE_TROWEL.get());
                        output.accept(ModItems.IRON_TROWEL.get());

                        // Pebbles
                        output.accept(ModItems.STONE_PEBBLE.get());
                        output.accept(ModItems.ANDESITE_PEBBLE.get());
                        output.accept(ModItems.DIORITE_PEBBLE.get());
                        output.accept(ModItems.GRANITE_PEBBLE.get());
                        output.accept(ModItems.DEEPSLATE_PEBBLE.get());
                        output.accept(ModItems.TUFF_PEBBLE.get());

                        output.accept(ModItems.ANDESITE_GRAVEL_ITEM.get());
                        output.accept(ModItems.DIORITE_GRAVEL_ITEM.get());
                        output.accept(ModItems.GRANITE_GRAVEL_ITEM.get());
                        output.accept(ModItems.DEEPSLATE_GRAVEL_ITEM.get());
                        output.accept(ModItems.TUFF_GRAVEL_ITEM.get());
                        output.accept(ModItems.NETHERRACK_GRAVEL_ITEM.get());
                        output.accept(ModItems.END_STONE_GRAVEL_ITEM.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}