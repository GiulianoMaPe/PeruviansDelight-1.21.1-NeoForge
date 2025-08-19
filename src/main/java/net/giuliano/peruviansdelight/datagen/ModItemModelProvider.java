package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PeruviansDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.INCA_KOLA.get());
        basicItem(ModItems.CAUSA.get());
        basicItem(ModItems.CAUSA_ATUN.get());
        basicItem(ModItems.CHAUFA.get());
        basicItem(ModItems.TALLARIN_SALTADO.get());
        basicItem(ModItems.LOMO_SALTADO.get());
        basicItem(ModItems.POLLO_BRASA.get());
        basicItem(ModItems.CEVICHE.get());
        basicItem(ModItems.AEROPUERTO.get());
        basicItem(ModItems.MOSTRITO.get());
        basicItem(ModItems.PAPA_HUANCAINA.get());
        basicItem(ModItems.TOCOSH.get());
        basicItem(ModItems.AJI_AMARILLO.get());
        basicItem(ModItems.LIMON.get());
        basicItem(ModItems.GAJO_LIMON.get());
        //
        //
        basicItem(ModItems.CAMOTE_COCIDO.get());
        basicItem(ModItems.CAMOTE_CORTADO.get());
        basicItem(ModItems.CAMOTE_FRITO.get());
        //
        basicItem(ModItems.YUCA_CORTADA.get());
        basicItem(ModItems.YUCA_FRITA.get());
        basicItem(ModItems.ATUN.get());
        basicItem(ModItems.FILETE_ATUN.get());
        basicItem(ModItems.FILETE_ATUN_COCIDO.get());
        basicItem(ModItems.PALTA.get());
        basicItem(ModItems.PALTA_CORTADA.get());
        basicItem(ModItems.PAPAS_CORTADAS.get());
        basicItem(ModItems.PAPAS_FRITAS.get());
        basicItem(ModItems.TENTACULO_POTA.get());
        basicItem(ModItems.POTA_CORTADO.get());
        basicItem(ModItems.CHICHARRON_POTA.get());

        basicItem(ModItems.POTE_AJI_AMARILLO.get());
        basicItem(ModItems.SILLAO.get());
        basicItem(ModItems.HUANCAINA.get());

        //

        basicItem(ModItems.VAINA_SOYA.get());
        //
        //

        basicItem(ModItems.BEEF_HEART.get());
        basicItem(ModItems.RAW_HEART_SLICES.get());
        basicItem(ModItems.RAW_ANTICUCHO.get());
        basicItem(ModItems.ANTICUCHO.get());

        basicItem(ModItems.MASA_PICARONES.get());
        basicItem(ModItems.PICARONES.get());
    }
}
