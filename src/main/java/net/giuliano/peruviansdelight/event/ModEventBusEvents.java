package net.giuliano.peruviansdelight.event;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.entity.ModEntities;
import net.giuliano.peruviansdelight.entity.client.AtunModel;
import net.giuliano.peruviansdelight.entity.custom.AtunEntity;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = PeruviansDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AtunModel.LAYER_LOCATION, AtunModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.ATUN.get(), AtunEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.ATUN.get(), SpawnPlacementTypes.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                AbstractSchoolingFish::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
