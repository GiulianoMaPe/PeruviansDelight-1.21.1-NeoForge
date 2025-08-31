package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, PeruviansDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALTO_LOG.get().asItem())
                .add(ModBlocks.PALTO_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_PALTO_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_PALTO_WOOD.get().asItem())
                .add(ModBlocks.LIMONERO_LOG.get().asItem())
                .add(ModBlocks.LIMONERO_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_LIMONERO_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_LIMONERO_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.PALTO_PLANKS.get().asItem())
                .add(ModBlocks.LIMONERO_PLANKS.get().asItem());

        tag(Tags.Items.FOODS_RAW_FISH)
                .add(ModItems.FILETE_ATUN.get());

        tag(ItemTags.MEAT)  //Alimentar Lobos
                .add(ModItems.CAMOTE_COCIDO.get());
    }
}
