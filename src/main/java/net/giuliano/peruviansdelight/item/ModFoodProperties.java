package net.giuliano.peruviansdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {

    public static final FoodProperties INCA_KOLA = new FoodProperties.Builder().fast().alwaysEdible().nutrition(4).saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 1000, 2), 1f)
            .build();

    public static final FoodProperties CAUSA = new FoodProperties.Builder().nutrition(12)
            .saturationModifier(1f).build();
    public static final FoodProperties CAUSA_ATUN = new FoodProperties.Builder().nutrition(12)
            .saturationModifier(1f).build();
    public static final FoodProperties CHAUFA = new FoodProperties.Builder().nutrition(10)
            .saturationModifier(1f).build();
    public static final FoodProperties TALLARIN_SALTADO = new FoodProperties.Builder().nutrition(10)
            .saturationModifier(1f).build();
    public static final FoodProperties LOMO_SALTADO = new FoodProperties.Builder().nutrition(10)
            .saturationModifier(1f).build();
    public static final FoodProperties POLLO_BRASA = new FoodProperties.Builder().nutrition(10)
            .saturationModifier(1f).build();
    public static final FoodProperties CEVICHE = new FoodProperties.Builder().nutrition(8)
            .saturationModifier(1f).build();
    public static final FoodProperties AEROPUERTO = new FoodProperties.Builder().nutrition(12)
            .saturationModifier(1f).build();
    public static final FoodProperties MOSTRITO = new FoodProperties.Builder().nutrition(14)
            .saturationModifier(1f).build();
    public static final FoodProperties PAPA_HUANCAINA = new FoodProperties.Builder().nutrition(10)
            .saturationModifier(1f).build();

    public static final FoodProperties TOCOSH = new FoodProperties.Builder().nutrition(8).fast()
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 3), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 1), 1f)
            .build();

    public static final FoodProperties AJI_AMARILLO = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 1f).build();
    public static final FoodProperties LIMON = new FoodProperties.Builder().nutrition(2).fast()
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 3), 1f)
            .build();
    public static final FoodProperties GAJO_LIMON = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 1), 1f)
            .build();
    public static final FoodProperties KION = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 0), 1f).build();

    public static final FoodProperties CAMOTE = new FoodProperties.Builder().nutrition(1)
            .saturationModifier(0.6f).build();

    public static final FoodProperties CAMOTE_COCIDO = new FoodProperties.Builder().nutrition(5).fast()
            .saturationModifier(1.2f).build();
            //.saturationModifier(1.2f).meat().build(); Agregar Tag más adelante

    public static final FoodProperties CAMOTE_CORTADO = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.3f).build();
    public static final FoodProperties CAMOTE_FRITO = new FoodProperties.Builder().nutrition(6).fast()
            .saturationModifier(1.2f).build();
    public static final FoodProperties YUCA = new FoodProperties.Builder().nutrition(2)
            .saturationModifier(0.5f).build();
    public static final FoodProperties YUCA_CORTADA = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.5f).build();
    public static final FoodProperties YUCA_FRITA = new FoodProperties.Builder().nutrition(6).fast()
            .saturationModifier(1.3f).build();
    public static final FoodProperties ATUN = new FoodProperties.Builder().nutrition(10)
            .saturationModifier(0.1f).build();
    public static final FoodProperties FILETE_ATUN = new FoodProperties.Builder().nutrition(2).fast()
            .saturationModifier(0.2f).build();
    public static final FoodProperties FILETE_ATUN_COCIDO = new FoodProperties.Builder().nutrition(6).fast()
            .saturationModifier(0.5f).build();
    public static final FoodProperties PALTA = new FoodProperties.Builder().nutrition(6)
            .saturationModifier(0.5f).build();
    public static final FoodProperties PALTA_CORTADA = new FoodProperties.Builder().nutrition(3).fast()
            .saturationModifier(0.7f).build();
    public static final FoodProperties PAPAS_CORTADAS = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(0.2f).build();
    public static final FoodProperties PAPAS_FRITAS = new FoodProperties.Builder().nutrition(5).fast()
            .saturationModifier(0.6f).build();
    public static final FoodProperties TENTACULO_POTA = new FoodProperties.Builder().nutrition(4).fast()
            .saturationModifier(0.6f).build();
    public static final FoodProperties POTA_CORTADO = new FoodProperties.Builder().nutrition(1).fast()
            .saturationModifier(1f).build();
    public static final FoodProperties CHICHARRON_POTA = new FoodProperties.Builder().nutrition(4).fast()
            .saturationModifier(0.75f).build();
}
