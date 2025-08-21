package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

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
