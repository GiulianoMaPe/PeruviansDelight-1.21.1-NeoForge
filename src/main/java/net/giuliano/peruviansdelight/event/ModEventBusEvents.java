package net.giuliano.peruviansdelight.event;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.entity.ModEntities;
import net.giuliano.peruviansdelight.entity.client.AtunModel;
import net.giuliano.peruviansdelight.entity.custom.AtunEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

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
}
