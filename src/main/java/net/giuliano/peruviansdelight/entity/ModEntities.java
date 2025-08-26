package net.giuliano.peruviansdelight.entity;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.entity.custom.AtunEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, PeruviansDelight.MOD_ID);

    public static final Supplier<EntityType<AtunEntity>> ATUN = ENTITY_TYPES.register("atun",
            () -> EntityType.Builder.of(AtunEntity::new, MobCategory.WATER_CREATURE)
            .sized(1.2f, 0.6f).clientTrackingRange(4).build("atun"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
