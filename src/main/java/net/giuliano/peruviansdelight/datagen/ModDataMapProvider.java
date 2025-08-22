package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.AJI_AMARILLO.getId(), new Compostable(0.65f), false)
                .add(ModItems.SEMILLAS_AJI_AMARILLO.getId(), new Compostable(0.30f), false)

                .add(ModItems.CAMOTE.getId(), new Compostable(0.65f), false)
                .add(ModItems.CAMOTE_COCIDO.getId(), new Compostable(0.85f), false)
                .add(ModItems.CAMOTE_CORTADO.getId(), new Compostable(0.50f), false)
                .add(ModItems.CAMOTE_FRITO.getId(), new Compostable(0.70f), false)

                .add(ModItems.KION.getId(), new Compostable(0.65f), false)

                .add(ModItems.VAINA_SOYA.getId(), new Compostable(0.65f), false)
                .add(ModItems.GRANOS_SOYA.getId(), new Compostable(0.30f), false)

                .add(ModItems.YUCA.getId(), new Compostable(0.65f), false)
                .add(ModItems.YUCA_CORTADA.getId(), new Compostable(0.50f), false)
                .add(ModItems.YUCA_FRITA.getId(), new Compostable(0.70f), false)

                .add(ModItems.LIMON.getId(), new Compostable(0.65f), false)
                .add(ModItems.GAJO_LIMON.getId(), new Compostable(0.30f), false)
                .add(ModBlocks.SEMILLAS_LIMON.getId(), new Compostable(0.30F), false)

                .add(ModItems.PALTA.getId(), new Compostable(0.65f), false)
                .add(ModItems.PALTA_CORTADA.getId(), new Compostable(0.50f), false)
                .add(ModBlocks.SEMILLA_PALTA.getId(), new Compostable(0.30f), false)

                .add(ModItems.PAPAS_CORTADAS.getId(), new Compostable(0.50f), false);
    }
}
