package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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
        basicItem(ModItems.KION.get());

        basicItem(ModItems.CAMOTE.get());
        basicItem(ModItems.CAMOTE_COCIDO.get());
        basicItem(ModItems.CAMOTE_CORTADO.get());
        basicItem(ModItems.CAMOTE_FRITO.get());
        basicItem(ModItems.YUCA.get());
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

        basicItem(ModItems.BEEF_HEART.get());
        basicItem(ModItems.RAW_HEART_SLICES.get());
        basicItem(ModItems.RAW_ANTICUCHO.get());
        basicItem(ModItems.ANTICUCHO.get());
        basicItem(ModItems.MASA_PICARONES.get());
        basicItem(ModItems.PICARONES.get());

        basicItem(ModItems.CHULETA_CORTADA.get());
        basicItem(ModItems.CHICHARRON.get());
        basicItem(ModItems.PAN_CHICHARRON.get());

        basicItem(ModItems.LLAMA.get());
        basicItem(ModItems.LLAMA_ASADA.get());
        basicItem(ModItems.CHARQUI.get());

        basicItem(ModItems.POTE_AJI_AMARILLO.get());
        basicItem(ModItems.SILLAO.get());
        basicItem(ModItems.HUANCAINA.get());

        basicItem(ModItems.VAINA_SOYA.get());
        basicItem(ModItems.GRANOS_SOYA.get());
        basicItem(ModItems.SEMILLAS_AJI_AMARILLO.get());

        saplingItem(ModBlocks.SEMILLA_PALTA);
        saplingItem(ModBlocks.SEMILLAS_LIMON);

        basicItem(ModBlocks.PALTO_DOOR.asItem());
        basicItem(ModBlocks.LIMONERO_DOOR.asItem());

        fenceItem(ModBlocks.PALTO_FENCE, ModBlocks.PALTO_PLANKS);
        fenceItem(ModBlocks.LIMONERO_FENCE, ModBlocks.LIMONERO_PLANKS);

        buttonItem(ModBlocks.PALTO_BUTTON, ModBlocks.PALTO_PLANKS);
        buttonItem(ModBlocks.LIMONERO_BUTTON, ModBlocks.LIMONERO_PLANKS);

        simpleBlockItemBlockTexture(ModBlocks.AJI_AMARILLO_SILVESTRE);
        simpleBlockItemBlockTexture(ModBlocks.KION_SILVESTRE);
        simpleBlockItemBlockTexture(ModBlocks.SOYA_SILVESTRE);
        simpleBlockItemBlockTexture(ModBlocks.CAMOTE_SILVESTRE);
        simpleBlockItemBlockTexture(ModBlocks.YUCA_SILVESTRE);

        getBuilder(ModBlocks.TENDAL.getId().getPath())
                .parent(new ModelFile.UncheckedModelFile(modLoc("block/tendal")));

        basicItem(ModItems.ATUN_BUCKET.get());
        withExistingParent(ModItems.ATUN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
