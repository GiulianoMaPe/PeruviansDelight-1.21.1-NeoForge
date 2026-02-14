package net.giuliano.peruviansdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects; //COMFORT y NOURISHMENT -> 6000 = 5 min / 3600 = 3 min / 1200 = 1 min

public class ModFoodProperties {

    public static final FoodProperties INCA_KOLA = new FoodProperties.Builder().fast().alwaysEdible().nutrition(1)
            .saturationModifier(6f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 2), 1f)
            .build();

    public static final FoodProperties CAUSA = new FoodProperties.Builder().nutrition(14)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 1), 1f)
            .saturationModifier(0.8f).build();
    public static final FoodProperties CAUSA_ATUN = new FoodProperties.Builder().nutrition(14)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 1), 1f)
            .saturationModifier(0.8f).build();
    public static final FoodProperties CHAUFA = new FoodProperties.Builder().nutrition(12)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 1), 1f)
            .saturationModifier(0.9f).build();
    public static final FoodProperties TALLARIN_SALTADO = new FoodProperties.Builder().nutrition(10)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 1), 1f)
            .saturationModifier(0.9f).build();
    public static final FoodProperties LOMO_SALTADO = new FoodProperties.Builder().nutrition(10)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 3600, 1), 1f)
            .saturationModifier(0.9f).build();
    public static final FoodProperties POLLO_BRASA = new FoodProperties.Builder().nutrition(12)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 6000, 1), 1f)
            .saturationModifier(0.9f).build();
    public static final FoodProperties CEVICHE = new FoodProperties.Builder().nutrition(8)
            .saturationModifier(1f).build();
    public static final FoodProperties AEROPUERTO = new FoodProperties.Builder().nutrition(14)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 6000, 1), 1f)
            .saturationModifier(0.9f).build();
    public static final FoodProperties MOSTRITO = new FoodProperties.Builder().nutrition(16)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT, 6000, 1), 1f)
            .saturationModifier(0.75f).build();
    public static final FoodProperties PAPA_HUANCAINA = new FoodProperties.Builder().nutrition(10)
            .saturationModifier(0.8f).build();

    public static final FoodProperties TOCOSH = new FoodProperties.Builder().nutrition(8).fast()
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT, 6000, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 3), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 300, 1), 1f)
            .build();

    public static final FoodProperties AJI_AMARILLO = new FoodProperties.Builder().nutrition(2).fast()
            .saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 1f).build();
    public static final FoodProperties LIMON = new FoodProperties.Builder().nutrition(2).fast()
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 3), 1f)
            .build();
    public static final FoodProperties GAJO_LIMON = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1f)
            .build();
    public static final FoodProperties KION = new FoodProperties.Builder().nutrition(2).fast()
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 1f).build();

    public static final FoodProperties CAMOTE = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.6f).build();
    public static final FoodProperties CAMOTE_COCIDO = new FoodProperties.Builder().nutrition(6).fast()
            .saturationModifier(0.8f).build();
            //.saturationModifier(0.8f).meat().build(); Agregado el TAGs
    public static final FoodProperties CAMOTE_CORTADO = new FoodProperties.Builder().nutrition(1).fast()
                    .saturationModifier(0.5f).build();
    public static final FoodProperties CAMOTE_FRITO = new FoodProperties.Builder().nutrition(3).fast()
            .saturationModifier(0.8f).build();
    public static final FoodProperties YUCA = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.5f).build();
    public static final FoodProperties YUCA_CORTADA = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.5f).build();
    public static final FoodProperties YUCA_FRITA = new FoodProperties.Builder().nutrition(3).fast()
            .saturationModifier(0.8f).build();
    public static final FoodProperties ATUN = new FoodProperties.Builder().nutrition(6)
            .saturationModifier(0.1f).build();
    public static final FoodProperties FILETE_ATUN = new FoodProperties.Builder().nutrition(2).fast()
            .saturationModifier(0.2f).build();
    public static final FoodProperties FILETE_ATUN_COCIDO = new FoodProperties.Builder().nutrition(6).fast()
            .saturationModifier(0.5f).build();
    public static final FoodProperties PALTA = new FoodProperties.Builder().nutrition(4)
            .saturationModifier(0.5f).build();
    public static final FoodProperties PALTA_CORTADA = new FoodProperties.Builder().nutrition(2).fast()
            .saturationModifier(0.7f).build();
    public static final FoodProperties PAPAS_CORTADAS = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.5f).build();
    public static final FoodProperties PAPAS_FRITAS = new FoodProperties.Builder().nutrition(3).fast()
            .saturationModifier(0.8f).build();
    public static final FoodProperties TENTACULO_POTA = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.6f).build();
    public static final FoodProperties POTA_CORTADO = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(1f).build();
    public static final FoodProperties CHICHARRON_POTA = new FoodProperties.Builder().nutrition(3).fast()
            .saturationModifier(0.8f).build();

    public static final FoodProperties BEEF_HEART = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.2f).build();
    public static final FoodProperties RAW_HEART_SLICES = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.5f).build();
    public static final FoodProperties RAW_ANTICUCHO = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.5f).build();
    public static final FoodProperties ANTICUCHO = new FoodProperties.Builder().nutrition(8)
            .saturationModifier(0.75f).build();

    public static final FoodProperties PICARONES = new FoodProperties.Builder().nutrition(8)
            .saturationModifier(1f).build();

    public static final FoodProperties CHULETA_CORTADA = new FoodProperties.Builder().nutrition(4)
            .saturationModifier(0.6f).build();
    public static final FoodProperties CHICHARRON = new FoodProperties.Builder().nutrition(4)
            .saturationModifier(1f).build();
    public static final FoodProperties PAN_CHICHARRON = new FoodProperties.Builder().nutrition(10)
            .saturationModifier(0.8f).build();

    public static final FoodProperties LLAMA = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.3f).build();
    public static final FoodProperties LLAMA_ASADA = new FoodProperties.Builder().nutrition(8)
            .saturationModifier(0.8f).build();
    public static final FoodProperties CHARQUI = new FoodProperties.Builder().nutrition(6)
            .saturationModifier(0.8f).fast().build();
}
