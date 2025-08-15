package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PeruviansDelight.MOD_ID);

    public static final Supplier<CreativeModeTab> PERUVIANSDELIGHT_TAB = CREATIVE_MODE_TAB.register("peruviansdelight_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CAUSA.get()))
                    .title(Component.translatable("creativeTab.peruviansdelight_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.INCA_KOLA.get());
                        output.accept(ModItems.CAUSA.get());

                        output.accept(ModBlocks.LIMONERO_WOOD.get());
                        output.accept(ModBlocks.LIMONERO_PLANKS.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
