package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PeruviansDelight.MOD_ID);

    public static final DeferredItem<Item> INCA_KOLA = ITEMS.registerItem("inca_kola",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> CAUSA = ITEMS.registerItem("causa",
            Item::new, new Item.Properties());

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}

