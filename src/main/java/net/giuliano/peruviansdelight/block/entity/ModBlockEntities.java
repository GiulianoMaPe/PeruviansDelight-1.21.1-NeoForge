package net.giuliano.peruviansdelight.block.entity;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PeruviansDelight.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TendalBlockEntity>> TENDAL_BE =
            BLOCK_ENTITIES.register("tendal_be", () ->
                    BlockEntityType.Builder.of(TendalBlockEntity::new,
                            ModBlocks.TENDAL.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
