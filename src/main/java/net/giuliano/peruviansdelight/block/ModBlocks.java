package net.giuliano.peruviansdelight.block;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.custom.*;
import net.giuliano.peruviansdelight.item.ModItems;
import net.giuliano.peruviansdelight.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PeruviansDelight.MOD_ID);

    public static final DeferredBlock<Block> AJI_AMARILLO_CROP = BLOCKS.register("ajies_amarillos",
            () -> new AjiAmarilloCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> KION_CROP = registerBlock("kiones",
            () -> new KionCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> SOYA_CROP = BLOCKS.register("soyas",
            () -> new SoyaCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> CAMOTE_CROP = BLOCKS.register("camotes",
            () -> new CamoteCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).noOcclusion().noCollission()));
    public static final DeferredBlock<Block> YUCA_CROP = BLOCKS.register("yucas",
            () -> new YucaCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).noOcclusion().noCollission()));

    public static final DeferredBlock<Block> LIMONERO_LOG = registerBlock("limonero_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> LIMONERO_WOOD = registerBlock("limonero_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_LIMONERO_LOG = registerBlock("stripped_limonero_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_LIMONERO_WOOD = registerBlock("stripped_limonero_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> LIMONERO_PLANKS = registerBlock("limonero_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> LIMONERO_LEAVES = registerBlock("limonero_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final DeferredBlock<Block> LIMONERO_LEAVES_EMPTY = registerBlock("limonero_leaves_empty",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> PALTO_LOG = registerBlock("palto_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> PALTO_WOOD = registerBlock("palto_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALTO_LOG = registerBlock("stripped_palto_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_PALTO_WOOD = registerBlock("stripped_palto_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PALTO_PLANKS = registerBlock("palto_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<Block> PALTO_LEAVES = registerBlock("palto_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });
    public static final DeferredBlock<Block> PALTO_LEAVES_EMPTY = registerBlock("palto_leaves_empty",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> SEMILLAS_LIMON = registerBlock("semillas_limon",
            () -> new SaplingBlock(ModTreeGrowers.LIMONERO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));
    public static final DeferredBlock<Block> SEMILLA_PALTA = registerBlock("semilla_palta",
            () -> new SaplingBlock(ModTreeGrowers.PALTO, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    public static final DeferredBlock<StairBlock> LIMONERO_STAIRS = registerBlock("limonero_stairs",
            () -> new StairBlock(ModBlocks.LIMONERO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> LIMONERO_SLAB = registerBlock("limonero_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<PressurePlateBlock> LIMONERO_PRESSURE_PLATE = registerBlock("limonero_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f)));
    public static final DeferredBlock<ButtonBlock> LIMONERO_BUTTON = registerBlock("limonero_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.of()
                    .strength(2f).noCollission()));
    public static final DeferredBlock<FenceBlock> LIMONERO_FENCE = registerBlock("limonero_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(2f)));
    public static final DeferredBlock<FenceGateBlock> LIMONERO_FENCE_GATE = registerBlock("limonero_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f)));
    public static final DeferredBlock<DoorBlock> LIMONERO_DOOR = registerBlock("limonero_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> LIMONERO_TRAPDOOR = registerBlock("limonero_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f).noOcclusion()));

    public static final DeferredBlock<StairBlock> PALTO_STAIRS = registerBlock("palto_stairs",
            () -> new StairBlock(ModBlocks.PALTO_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> PALTO_SLAB = registerBlock("palto_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<PressurePlateBlock> PALTO_PRESSURE_PLATE = registerBlock("palto_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f)));
    public static final DeferredBlock<ButtonBlock> PALTO_BUTTON = registerBlock("palto_button",
            () -> new ButtonBlock(BlockSetType.OAK, 20, BlockBehaviour.Properties.of()
                    .strength(2f).noCollission()));
    public static final DeferredBlock<FenceBlock> PALTO_FENCE = registerBlock("palto_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(2f)));
    public static final DeferredBlock<FenceGateBlock> PALTO_FENCE_GATE = registerBlock("palto_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f)));
    public static final DeferredBlock<DoorBlock> PALTO_DOOR = registerBlock("palto_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> PALTO_TRAPDOOR = registerBlock("palto_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f).noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
