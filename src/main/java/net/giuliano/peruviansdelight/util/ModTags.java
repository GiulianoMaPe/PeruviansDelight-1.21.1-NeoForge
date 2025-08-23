package net.giuliano.peruviansdelight.util;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> KNIVES = forgeCreate("tools/knife");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, name));
        }

        private static TagKey<Item> forgeCreate(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
