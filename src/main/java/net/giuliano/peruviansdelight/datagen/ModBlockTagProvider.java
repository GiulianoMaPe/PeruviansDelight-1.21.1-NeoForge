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
        //tag(BlockTags.MINEABLE_WITH_PICKAXE);
        //tag(BlockTags.NEEDS_IRON_TOOL);

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
    }
}
