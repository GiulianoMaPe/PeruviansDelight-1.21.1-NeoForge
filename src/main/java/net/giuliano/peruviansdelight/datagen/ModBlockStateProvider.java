package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.block.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PeruviansDelight.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock(((RotatedPillarBlock) ModBlocks.LIMONERO_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.LIMONERO_WOOD.get(), blockTexture(ModBlocks.LIMONERO_LOG.get()), blockTexture(ModBlocks.LIMONERO_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_LIMONERO_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_LIMONERO_WOOD.get(), blockTexture(ModBlocks.STRIPPED_LIMONERO_LOG.get()), blockTexture(ModBlocks.STRIPPED_LIMONERO_LOG.get()));

        blockItem(ModBlocks.LIMONERO_LOG);
        blockItem(ModBlocks.LIMONERO_WOOD);
        blockItem(ModBlocks.STRIPPED_LIMONERO_LOG);
        blockItem(ModBlocks.STRIPPED_LIMONERO_WOOD);
        blockWithItem(ModBlocks.LIMONERO_PLANKS);
        leavesBlock(ModBlocks.LIMONERO_LEAVES);
        leavesBlock(ModBlocks.LIMONERO_LEAVES_EMPTY);
        saplingBlock(ModBlocks.SEMILLAS_LIMON);

        logBlock(((RotatedPillarBlock) ModBlocks.PALTO_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.PALTO_WOOD.get(), blockTexture(ModBlocks.PALTO_LOG.get()), blockTexture(ModBlocks.PALTO_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_PALTO_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_PALTO_WOOD.get(), blockTexture(ModBlocks.STRIPPED_PALTO_LOG.get()), blockTexture(ModBlocks.STRIPPED_PALTO_LOG.get()));

        blockItem(ModBlocks.PALTO_LOG);
        blockItem(ModBlocks.PALTO_WOOD);
        blockItem(ModBlocks.STRIPPED_PALTO_LOG);
        blockItem(ModBlocks.STRIPPED_PALTO_WOOD);
        blockWithItem(ModBlocks.PALTO_PLANKS);
        leavesBlock(ModBlocks.PALTO_LEAVES);
        leavesBlock(ModBlocks.PALTO_LEAVES_EMPTY);
        saplingBlock(ModBlocks.SEMILLA_PALTA);

        stairsBlock(ModBlocks.LIMONERO_STAIRS.get(), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        slabBlock(ModBlocks.LIMONERO_SLAB.get(), blockTexture(ModBlocks.LIMONERO_PLANKS.get()), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        buttonBlock(ModBlocks.LIMONERO_BUTTON.get(), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        pressurePlateBlock(ModBlocks.LIMONERO_PRESSURE_PLATE.get(), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        fenceBlock(ModBlocks.LIMONERO_FENCE.get(), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        fenceGateBlock(ModBlocks.LIMONERO_FENCE_GATE.get(), blockTexture(ModBlocks.LIMONERO_PLANKS.get()));
        doorBlockWithRenderType(ModBlocks.LIMONERO_DOOR.get(), modLoc("block/limonero_door_bottom"), modLoc("block/limonero_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.LIMONERO_TRAPDOOR.get(), modLoc("block/limonero_trapdoor"), true, "cutout");

        blockItem(ModBlocks.LIMONERO_STAIRS);
        blockItem(ModBlocks.LIMONERO_SLAB);
        blockItem(ModBlocks.LIMONERO_PRESSURE_PLATE);
        blockItem(ModBlocks.LIMONERO_FENCE_GATE);
        blockItem(ModBlocks.LIMONERO_TRAPDOOR, "_bottom");

        stairsBlock(ModBlocks.PALTO_STAIRS.get(), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        slabBlock(ModBlocks.PALTO_SLAB.get(), blockTexture(ModBlocks.PALTO_PLANKS.get()), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        buttonBlock(ModBlocks.PALTO_BUTTON.get(), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        pressurePlateBlock(ModBlocks.PALTO_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        fenceBlock(ModBlocks.PALTO_FENCE.get(), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        fenceGateBlock(ModBlocks.PALTO_FENCE_GATE.get(), blockTexture(ModBlocks.PALTO_PLANKS.get()));
        doorBlockWithRenderType(ModBlocks.PALTO_DOOR.get(), modLoc("block/palto_door_bottom"), modLoc("block/palto_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.PALTO_TRAPDOOR.get(), modLoc("block/palto_trapdoor"), true, "cutout");

        blockItem(ModBlocks.PALTO_STAIRS);
        blockItem(ModBlocks.PALTO_SLAB);
        blockItem(ModBlocks.PALTO_PRESSURE_PLATE);
        blockItem(ModBlocks.PALTO_FENCE_GATE);
        blockItem(ModBlocks.PALTO_TRAPDOOR, "_bottom");

        makeCrop1(((CropBlock) ModBlocks.AJI_AMARILLO_CROP.get()), "ajies_amarillos_stage", "ajies_amarillos_stage");
        makeCrop2(((CropBlock) ModBlocks.CAMOTE_CROP.get()), "camotes_stage", "camotes_stage");
        makeCrop3(((CropBlock) ModBlocks.KION_CROP.get()), "kiones_stage", "kiones_stage");
        makeCrop4(((CropBlock) ModBlocks.SOYA_CROP.get()), "soyas_stage", "soyas_stage");
        makeCrop5(((CropBlock) ModBlocks.YUCA_CROP.get()), "yucas_stage", "yucas_stage");

        simpleBlockWithItem(ModBlocks.AJI_AMARILLO_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.AJI_AMARILLO_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.AJI_AMARILLO_SILVESTRE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.KION_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.KION_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.KION_SILVESTRE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.SOYA_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.SOYA_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.SOYA_SILVESTRE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.CAMOTE_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.CAMOTE_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.CAMOTE_SILVESTRE.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.YUCA_SILVESTRE.get(), models().cross(blockTexture(ModBlocks.YUCA_SILVESTRE.get()).getPath(),
                blockTexture(ModBlocks.YUCA_SILVESTRE.get())).renderType("cutout"));
    }

    public void makeCrop1(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states1(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states1(BlockState state, CropBlock block, String modelName, String textureName) {
        int age = state.getValue(((AjiAmarilloCropBlock) block).getAgeProperty());
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                models().withExistingParent(modelName + age,
                                modLoc("block/crop_cross"))
                        .texture("cross", modLoc("block/" + textureName + age))
                        .renderType("cutout")
        );
        return models;
    }
    public void makeCrop2(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states2(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states2(BlockState state, CropBlock block, String modelName, String textureName) {
        int age = state.getValue(((CamoteCropBlock) block).getAgeProperty());
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                models().withExistingParent(modelName + age,
                                modLoc("block/crop_cross"))
                        .texture("cross", modLoc("block/" + textureName + age))
                        .renderType("cutout")
        );
        return models;
    }
    public void makeCrop3(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states3(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states3(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KionCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, "block/" + textureName + state.getValue(((KionCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    public void makeCrop4(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states4(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states4(BlockState state, CropBlock block, String modelName, String textureName) {
        int age = state.getValue(((SoyaCropBlock) block).getAgeProperty());
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                models().withExistingParent(modelName + age,
                                modLoc("block/crop_cross"))
                        .texture("cross", modLoc("block/" + textureName + age))
                        .renderType("cutout")
        );
        return models;
    }
    public void makeCrop5(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states5(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states5(BlockState state, CropBlock block, String modelName, String textureName) {
        int age = state.getValue(((YucaCropBlock) block).getAgeProperty());
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                models().withExistingParent(modelName + age,
                                modLoc("block/crop_cross"))
                        .texture("cross", modLoc("block/" + textureName + age))
                        .renderType("cutout")
        );
        return models;
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
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
}
