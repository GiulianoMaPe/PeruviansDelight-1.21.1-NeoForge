package net.giuliano.peruviansdelight.item;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.entity.ModEntities;
import net.giuliano.peruviansdelight.item.custom.DrinkFoil;
import net.giuliano.peruviansdelight.item.custom.ModBowlFood;
import net.giuliano.peruviansdelight.item.custom.ModDrinkItems;
import net.giuliano.peruviansdelight.item.custom.PaltaFoodItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PeruviansDelight.MOD_ID);

    public static final DeferredItem<Item> INCA_KOLA = ITEMS.registerItem("inca_kola",
            DrinkFoil::new, new Item.Properties().rarity(Rarity.EPIC).fireResistant()
                    .food(ModFoodProperties.INCA_KOLA));

    public static final DeferredItem<Item> CAUSA = ITEMS.registerItem("causa",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.CAUSA));
    public static final DeferredItem<Item> CAUSA_ATUN = ITEMS.registerItem("causa_atun",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.CAUSA_ATUN));
    public static final DeferredItem<Item> CHAUFA = ITEMS.registerItem("chaufa",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.CHAUFA));
    public static final DeferredItem<Item> TALLARIN_SALTADO = ITEMS.registerItem("tallarin_saltado",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.TALLARIN_SALTADO));
    public static final DeferredItem<Item> LOMO_SALTADO = ITEMS.registerItem("lomo_saltado",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.LOMO_SALTADO));
    public static final DeferredItem<Item> POLLO_BRASA = ITEMS.registerItem("pollo_brasa",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.POLLO_BRASA));
    public static final DeferredItem<Item> CEVICHE = ITEMS.registerItem("ceviche",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.CEVICHE));
    public static final DeferredItem<Item> AEROPUERTO = ITEMS.registerItem("aeropuerto",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.AEROPUERTO));
    public static final DeferredItem<Item> MOSTRITO = ITEMS.registerItem("mostrito",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.MOSTRITO));
    public static final DeferredItem<Item> PAPA_HUANCAINA = ITEMS.registerItem("papa_huancaina",
            ModBowlFood::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.PAPA_HUANCAINA));

    public static final DeferredItem<Item> TOCOSH = ITEMS.registerItem("tocosh",
            ModDrinkItems::new, new Item.Properties().stacksTo(16)
                    .food(ModFoodProperties.TOCOSH));

    public static final DeferredItem<Item> AJI_AMARILLO = ITEMS.registerItem("aji_amarillo",
            Item::new, new Item.Properties().food(ModFoodProperties.AJI_AMARILLO));
    public static final DeferredItem<Item> LIMON = ITEMS.registerItem("limon",
            Item::new, new Item.Properties().food(ModFoodProperties.LIMON));
    public static final DeferredItem<Item> GAJO_LIMON = ITEMS.registerItem("gajo_limon",
            Item::new, new Item.Properties().food(ModFoodProperties.GAJO_LIMON));

    public static final DeferredItem<Item> KION = ITEMS.register("kion",
            () -> new ItemNameBlockItem(ModBlocks.KION_CROP.get(), new Item.Properties().food(ModFoodProperties.KION)));
    public static final DeferredItem<Item> CAMOTE = ITEMS.register("camote",
            () -> new ItemNameBlockItem(ModBlocks.CAMOTE_CROP.get(), new Item.Properties().food(ModFoodProperties.CAMOTE)));

    public static final DeferredItem<Item> CAMOTE_COCIDO = ITEMS.registerItem("camote_cocido",
            Item::new, new Item.Properties().food(ModFoodProperties.CAMOTE_COCIDO));
    public static final DeferredItem<Item> CAMOTE_CORTADO = ITEMS.registerItem("camote_cortado",
            Item::new, new Item.Properties().food(ModFoodProperties.CAMOTE_CORTADO));
    public static final DeferredItem<Item> CAMOTE_FRITO = ITEMS.registerItem("camote_frito",
            Item::new, new Item.Properties().food(ModFoodProperties.CAMOTE_FRITO));

    public static final DeferredItem<Item> YUCA = ITEMS.register("yuca",
            () -> new ItemNameBlockItem(ModBlocks.YUCA_CROP.get(), new Item.Properties().food(ModFoodProperties.YUCA)));

    public static final DeferredItem<Item> YUCA_CORTADA = ITEMS.registerItem("yuca_cortada",
            Item::new, new Item.Properties().food(ModFoodProperties.YUCA_CORTADA));
    public static final DeferredItem<Item> YUCA_FRITA = ITEMS.registerItem("yuca_frita",
            Item::new, new Item.Properties().food(ModFoodProperties.YUCA_FRITA));
    public static final DeferredItem<Item> ATUN = ITEMS.registerItem("atun",
            Item::new, new Item.Properties().food(ModFoodProperties.ATUN));
    public static final DeferredItem<Item> FILETE_ATUN = ITEMS.registerItem("filete_atun",
            Item::new, new Item.Properties().food(ModFoodProperties.FILETE_ATUN));
    public static final DeferredItem<Item> FILETE_ATUN_COCIDO = ITEMS.registerItem("filete_atun_cocido",
            Item::new, new Item.Properties().food(ModFoodProperties.FILETE_ATUN_COCIDO));

    public static final DeferredItem<Item> PALTA = ITEMS.registerItem("palta",
            PaltaFoodItem::new, new Item.Properties().food(ModFoodProperties.PALTA));

    public static final DeferredItem<Item> PALTA_CORTADA = ITEMS.registerItem("palta_cortada",
            Item::new, new Item.Properties().food(ModFoodProperties.PALTA_CORTADA));
    public static final DeferredItem<Item> PAPAS_CORTADAS = ITEMS.registerItem("papas_cortadas",
            Item::new, new Item.Properties().food(ModFoodProperties.PAPAS_CORTADAS));
    public static final DeferredItem<Item> PAPAS_FRITAS = ITEMS.registerItem("papas_fritas",
            Item::new, new Item.Properties().food(ModFoodProperties.PAPAS_FRITAS));
    public static final DeferredItem<Item> TENTACULO_POTA = ITEMS.registerItem("tentaculo_pota",
            Item::new, new Item.Properties().stacksTo(16).food(ModFoodProperties.TENTACULO_POTA));
    public static final DeferredItem<Item> POTA_CORTADO = ITEMS.registerItem("pota_cortado",
            Item::new, new Item.Properties().food(ModFoodProperties.POTA_CORTADO));
    public static final DeferredItem<Item> CHICHARRON_POTA = ITEMS.registerItem("chicharron_pota",
            Item::new, new Item.Properties().food(ModFoodProperties.CHICHARRON_POTA));

    public static final DeferredItem<Item> POTE_AJI_AMARILLO = ITEMS.registerItem("pote_aji_amarillo",
            Item::new, new Item.Properties().stacksTo(16));
    public static final DeferredItem<Item> SILLAO = ITEMS.registerItem("sillao",
            Item::new, new Item.Properties().stacksTo(16));
    public static final DeferredItem<Item> HUANCAINA = ITEMS.registerItem("huancaina",
            Item::new, new Item.Properties().stacksTo(16));

    public static final DeferredItem<Item> VAINA_SOYA = ITEMS.registerItem("vaina_soya",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> GRANOS_SOYA = ITEMS.register("granos_soya",
            () -> new ItemNameBlockItem(ModBlocks.SOYA_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> SEMILLAS_AJI_AMARILLO = ITEMS.register("semillas_aji_amarillo",
            () -> new ItemNameBlockItem(ModBlocks.AJI_AMARILLO_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> BEEF_HEART = ITEMS.registerItem("beef_heart",
            Item::new, new Item.Properties().food(ModFoodProperties.BEEF_HEART));
    public static final DeferredItem<Item> RAW_HEART_SLICES = ITEMS.registerItem("raw_heart_slices",
            Item::new, new Item.Properties().food(ModFoodProperties.RAW_HEART_SLICES));
    public static final DeferredItem<Item> RAW_ANTICUCHO = ITEMS.registerItem("raw_anticucho",
            Item::new, new Item.Properties().food(ModFoodProperties.RAW_ANTICUCHO));
    public static final DeferredItem<Item> ANTICUCHO = ITEMS.registerItem("anticucho",
            Item::new, new Item.Properties().food(ModFoodProperties.ANTICUCHO));

    public static final DeferredItem<Item> MASA_PICARONES = ITEMS.registerItem("masa_picarones",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> PICARONES = ITEMS.registerItem("picarones",
            Item::new, new Item.Properties().food(ModFoodProperties.PICARONES));

    //MOBS
    public static final DeferredItem<Item> ATUN_BUCKET = ITEMS.register("atun_bucket",
            () -> new MobBucketItem(ModEntities.ATUN.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH,
                    new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ATUN_SPAWN_EGG = ITEMS.register("atun_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.ATUN, 0xb4d4e1, 0x195a75,
                    new Item.Properties()));

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
