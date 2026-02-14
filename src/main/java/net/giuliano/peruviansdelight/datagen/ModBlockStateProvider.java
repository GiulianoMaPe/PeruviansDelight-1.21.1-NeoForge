package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.block.custom.*;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PeruviansDelight.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // TRONCOS
        registerLogAndWood(ModBlocks.LIMONERO_LOG, ModBlocks.LIMONERO_WOOD, ModBlocks.STRIPPED_LIMONERO_LOG, ModBlocks.STRIPPED_LIMONERO_WOOD);
        registerLogAndWood(ModBlocks.PALTO_LOG, ModBlocks.PALTO_WOOD, ModBlocks.STRIPPED_PALTO_LOG, ModBlocks.STRIPPED_PALTO_WOOD);

        // PLANKS, LEAVES, SAPLINGS
        blockWithItem(ModBlocks.LIMONERO_PLANKS);
        leavesBlock(ModBlocks.LIMONERO_LEAVES);
        leavesBlock(ModBlocks.LIMONERO_LEAVES_EMPTY);
        saplingBlock(ModBlocks.SEMILLAS_LIMON);

        blockWithItem(ModBlocks.PALTO_PLANKS);
        leavesBlock(ModBlocks.PALTO_LEAVES);
        leavesBlock(ModBlocks.PALTO_LEAVES_EMPTY);
        saplingBlock(ModBlocks.SEMILLA_PALTA);

        // DECORACIÓN (Stairs, Slabs, etc.)
        registerWoodDecorations(ModBlocks.LIMONERO_STAIRS, ModBlocks.LIMONERO_SLAB, ModBlocks.LIMONERO_BUTTON,
                ModBlocks.LIMONERO_PRESSURE_PLATE, ModBlocks.LIMONERO_FENCE, ModBlocks.LIMONERO_FENCE_GATE,
                ModBlocks.LIMONERO_DOOR, ModBlocks.LIMONERO_TRAPDOOR, ModBlocks.LIMONERO_PLANKS);
        registerWoodDecorations(ModBlocks.PALTO_STAIRS, ModBlocks.PALTO_SLAB, ModBlocks.PALTO_BUTTON,
                ModBlocks.PALTO_PRESSURE_PLATE, ModBlocks.PALTO_FENCE, ModBlocks.PALTO_FENCE_GATE,
                ModBlocks.PALTO_DOOR, ModBlocks.PALTO_TRAPDOOR, ModBlocks.PALTO_PLANKS);

        // CULTIVOS
        makeCrossCrop(ModBlocks.AJI_AMARILLO_CROP.get(), AjiAmarilloCropBlock.AGE, "ajies_amarillos_stage", "ajies_amarillos_stage");
        makeCrossCrop(ModBlocks.CAMOTE_CROP.get(), CamoteCropBlock.AGE, "camotes_stage", "camotes_stage");
        makeCrossCrop(ModBlocks.SOYA_CROP.get(), SoyaCropBlock.AGE, "soyas_stage", "soyas_stage");
        makeCrossCrop(ModBlocks.YUCA_CROP.get(), YucaCropBlock.AGE, "yucas_stage", "yucas_stage");

        makeNormalCrop(ModBlocks.KION_CROP.get(), KionCropBlock.AGE, "kiones_stage", "kiones_stage");

        // PLANTAS SILVESTRES
        simpleBlockWithItem(ModBlocks.AJI_AMARILLO_SILVESTRE.get(), crossBlock(ModBlocks.AJI_AMARILLO_SILVESTRE.get()));
        simpleBlockWithItem(ModBlocks.KION_SILVESTRE.get(), crossBlock(ModBlocks.KION_SILVESTRE.get()));
        simpleBlockWithItem(ModBlocks.SOYA_SILVESTRE.get(), crossBlock(ModBlocks.SOYA_SILVESTRE.get()));
        simpleBlockWithItem(ModBlocks.CAMOTE_SILVESTRE.get(), crossBlock(ModBlocks.CAMOTE_SILVESTRE.get()));
        simpleBlockWithItem(ModBlocks.YUCA_SILVESTRE.get(), crossBlock(ModBlocks.YUCA_SILVESTRE.get()));

        // CRATES Y BAGS
        crateBlock(ModBlocks.AJI_AMARILLO_CRATE);
        crateBlock(ModBlocks.CAMOTE_CRATE);
        crateBlock(ModBlocks.KION_CRATE);
        crateBlock(ModBlocks.LIMON_CRATE);
        crateBlock(ModBlocks.PALTA_CRATE);
        crateBlock(ModBlocks.SOYA_CRATE);
        crateBlock(ModBlocks.YUCA_CRATE);

        bagBlock(ModBlocks.SOYA_BAG);

        // BLOCKS SIMPLES
        var tendalModel = models().getBuilder("tendal")
                .parent(models().getExistingFile(mcLoc("block/block")))
                // Definimos las 6 texturas (4 lados + arriba + abajo)
                .texture("particle", modLoc("block/tendal_top"))
                .texture("top", modLoc("block/tendal_top"))
                .texture("bottom", modLoc("block/mud_tiles"))
                .texture("north", modLoc("block/tendal_nr"))
                .texture("south", modLoc("block/tendal_sl"))
                .texture("east", modLoc("block/tendal_nr"))
                .texture("west", modLoc("block/tendal_sl"))
                .element()
                    .from(0, 0, 0).to(16, 8, 16) // Tamaño del bloque
                    // Asignamos manualmente cada textura a su cara correspondiente
                    .face(Direction.UP).texture("#top").cullface(Direction.UP).end()
                    .face(Direction.DOWN).texture("#bottom").cullface(Direction.DOWN).end()
                    .face(Direction.NORTH).texture("#north").cullface(Direction.NORTH).end()
                    .face(Direction.SOUTH).texture("#south").cullface(Direction.SOUTH).end()
                    .face(Direction.EAST).texture("#east").cullface(Direction.EAST).end()
                    .face(Direction.WEST).texture("#west").cullface(Direction.WEST).end()
                    .end();
        horizontalBlock(ModBlocks.TENDAL.get(), tendalModel);
    }

    // MÉTODOS HELPER
    public void makeCrossCrop(Block block, IntegerProperty ageProperty, String modelName, String textureName) {
        getVariantBuilder(block).forAllStates(state -> {
            int age = state.getValue(ageProperty);
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(modelName + age, modLoc("block/crop_cross")) // Tu modelo custom
                            .texture("cross", modLoc("block/" + textureName + age))
                            .renderType("cutout"))
                    .build();
        });
    }
    public void makeNormalCrop(Block block, IntegerProperty ageProperty, String modelName, String textureName) {
        getVariantBuilder(block).forAllStates(state -> {
            int age = state.getValue(ageProperty);
            return ConfiguredModel.builder()
                    .modelFile(models().crop(modelName + age, modLoc("block/" + textureName + age))
                            .renderType("cutout"))
                    .build();
        });
    }

    private void registerLogAndWood(DeferredBlock<Block> log, DeferredBlock<Block> wood, DeferredBlock<Block> strippedLog, DeferredBlock<Block> strippedWood) {
        logBlock(((RotatedPillarBlock) log.get()));
        axisBlock((RotatedPillarBlock) wood.get(), blockTexture(log.get()), blockTexture(log.get()));
        logBlock(((RotatedPillarBlock) strippedLog.get()));
        axisBlock((RotatedPillarBlock) strippedWood.get(), blockTexture(strippedLog.get()), blockTexture(strippedLog.get()));

        blockItem(log);
        blockItem(wood);
        blockItem(strippedLog);
        blockItem(strippedWood);
    }

    private void registerWoodDecorations(DeferredBlock<?> stairs, DeferredBlock<?> slab, DeferredBlock<?> button,
                                         DeferredBlock<?> plate, DeferredBlock<?> fence, DeferredBlock<?> gate,
                                         DeferredBlock<?> door, DeferredBlock<?> trapdoor, DeferredBlock<?> planks) {
        stairsBlock((StairBlock) stairs.get(), blockTexture(planks.get()));
        slabBlock((SlabBlock) slab.get(), blockTexture(planks.get()), blockTexture(planks.get()));
        buttonBlock((ButtonBlock) button.get(), blockTexture(planks.get()));
        pressurePlateBlock((PressurePlateBlock) plate.get(), blockTexture(planks.get()));
        fenceBlock((FenceBlock) fence.get(), blockTexture(planks.get()));
        fenceGateBlock((FenceGateBlock) gate.get(), blockTexture(planks.get()));
        String doorName = door.getId().getPath();
        doorBlockWithRenderType((DoorBlock) door.get(), modLoc("block/" + doorName + "_bottom"), modLoc("block/" + doorName + "_top"), "cutout");
        String trapdoorName = trapdoor.getId().getPath();
        trapdoorBlockWithRenderType((TrapDoorBlock) trapdoor.get(), modLoc("block/" + trapdoorName), true, "cutout");

        blockItem(stairs);
        blockItem(slab);
        blockItem(plate);
        blockItem(gate);
        blockItem(trapdoor, "_bottom");
    }

    private ModelFile crossBlock(Block block) {
        return models().cross(BuiltInRegistries.BLOCK.getKey(block).getPath(), blockTexture(block)).renderType("cutout");
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(), crossBlock(blockRegistryObject.get()));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("peruviansdelight:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("peruviansdelight:block/" + deferredBlock.getId().getPath() + appendix));
    }

    public void crateBlock(DeferredBlock<?> deferredBlock) {
        String name = deferredBlock.getId().getPath();

        simpleBlock(deferredBlock.get(), models().cubeBottomTop(
                name,
                modLoc("block/" + name + "_side"),
                modLoc("block/crate_bottom"),
                modLoc("block/" + name + "_top")
        ));

        blockItem(deferredBlock);
    }

    public void bagBlock(DeferredBlock<?> deferredBlock) {
        String name = deferredBlock.getId().getPath();

        simpleBlock(deferredBlock.get(), models().cube(
                name,
                modLoc("block/bag_bottom"),
                modLoc("block/" + name + "_top"),
                modLoc("block/bag_side_tied"),
                modLoc("block/bag_side_tied"),
                modLoc("block/bag_side"),
                modLoc("block/bag_side")
        ).texture("particle", modLoc("block/" + name + "_top")));

        blockItem(deferredBlock);
    }
}