package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PeruviansDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //this.tag(BlockTags.MINEABLE_WITH_PICKAXE);
        //this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALTO_LOG.get())
                .add(ModBlocks.PALTO_WOOD.get())
                .add(ModBlocks.STRIPPED_PALTO_LOG.get())
                .add(ModBlocks.STRIPPED_PALTO_WOOD.get())
                .add(ModBlocks.LIMONERO_LOG.get())
                .add(ModBlocks.LIMONERO_WOOD.get())
                .add(ModBlocks.STRIPPED_LIMONERO_LOG.get())
                .add(ModBlocks.STRIPPED_LIMONERO_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.PALTO_PLANKS.get())
                .add(ModBlocks.LIMONERO_PLANKS.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.PALTO_FENCE.get())
                .add(ModBlocks.LIMONERO_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PALTO_FENCE_GATE.get())
                .add(ModBlocks.LIMONERO_FENCE_GATE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.LIMONERO_LOG.get(),
                        ModBlocks.LIMONERO_WOOD.get(),
                        ModBlocks.STRIPPED_LIMONERO_LOG.get(),
                        ModBlocks.STRIPPED_LIMONERO_WOOD.get(),
                        ModBlocks.LIMONERO_PLANKS.get(),
                        ModBlocks.LIMONERO_STAIRS.get(),
                        ModBlocks.LIMONERO_SLAB.get(),
                        ModBlocks.LIMONERO_FENCE.get(),
                        ModBlocks.LIMONERO_FENCE_GATE.get(),
                        ModBlocks.LIMONERO_DOOR.get(),
                        ModBlocks.LIMONERO_TRAPDOOR.get(),
                        ModBlocks.LIMONERO_BUTTON.get(),
                        ModBlocks.LIMONERO_PRESSURE_PLATE.get(),

                        ModBlocks.PALTO_LOG.get(),
                        ModBlocks.PALTO_WOOD.get(),
                        ModBlocks.STRIPPED_PALTO_LOG.get(),
                        ModBlocks.STRIPPED_PALTO_WOOD.get(),
                        ModBlocks.PALTO_PLANKS.get(),
                        ModBlocks.PALTO_STAIRS.get(),
                        ModBlocks.PALTO_SLAB.get(),
                        ModBlocks.PALTO_FENCE.get(),
                        ModBlocks.PALTO_FENCE_GATE.get(),
                        ModBlocks.PALTO_DOOR.get(),
                        ModBlocks.PALTO_TRAPDOOR.get(),
                        ModBlocks.PALTO_BUTTON.get(),
                        ModBlocks.PALTO_PRESSURE_PLATE.get(),

                        ModBlocks.AJI_AMARILLO_CRATE.get(),
                        ModBlocks.CAMOTE_CRATE.get(),
                        ModBlocks.KION_CRATE.get(),
                        ModBlocks.LIMON_CRATE.get(),
                        ModBlocks.PALTA_CRATE.get(),
                        ModBlocks.SOYA_CRATE.get(),
                        ModBlocks.YUCA_CRATE.get());

        this.tag(BlockTags.LEAVES)
                .add(ModBlocks.LIMONERO_LEAVES.get(),
                        ModBlocks.LIMONERO_LEAVES_EMPTY.get(),
                        ModBlocks.PALTO_LEAVES.get(),
                        ModBlocks.PALTO_LEAVES_EMPTY.get());

        this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.LIMONERO_STAIRS.get(), ModBlocks.PALTO_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.LIMONERO_SLAB.get(), ModBlocks.PALTO_SLAB.get());
        this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.LIMONERO_FENCE.get(), ModBlocks.PALTO_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.LIMONERO_FENCE_GATE.get(), ModBlocks.PALTO_FENCE_GATE.get());
        this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.LIMONERO_DOOR.get(), ModBlocks.PALTO_DOOR.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.LIMONERO_TRAPDOOR.get(), ModBlocks.PALTO_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.LIMONERO_PRESSURE_PLATE.get(), ModBlocks.PALTO_PRESSURE_PLATE.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.LIMONERO_BUTTON.get(), ModBlocks.PALTO_BUTTON.get());
    }
}
