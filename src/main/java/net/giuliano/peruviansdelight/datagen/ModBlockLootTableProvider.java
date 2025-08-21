package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    private LootItemCondition.Builder modHasSilkTouch() {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return MatchTool.toolMatches(ItemPredicate.Builder.item().withSubPredicate(ItemSubPredicates.ENCHANTMENTS, ItemEnchantmentsPredicate.enchantments(List.of(new EnchantmentPredicate(registrylookup.getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1))))));
    }
    private LootItemCondition.Builder modHasShearsOrSilkTouch() {
        return HAS_SHEARS.or(modHasSilkTouch());
    }
    private LootItemCondition.Builder modDoesNotHaveShearsOrSilkTouch() {
        return modHasShearsOrSilkTouch().invert();
    }

    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};

    @Override
    protected void generate() {
        dropSelf(ModBlocks.LIMONERO_LOG.get());
        dropSelf(ModBlocks.LIMONERO_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_LIMONERO_LOG.get());
        dropSelf(ModBlocks.STRIPPED_LIMONERO_WOOD.get());
        dropSelf(ModBlocks.LIMONERO_PLANKS.get());
        dropSelf(ModBlocks.SEMILLAS_LIMON.get());
        add(ModBlocks.LIMONERO_LEAVES.get(), block ->
                createModLeavesDrops(block, ModItems.LIMON.get(), 1.0F, 1.25F, 1.6667F, 2.0F));
        add(ModBlocks.LIMONERO_LEAVES_EMPTY.get(), this::createEmptyLeavesDrops);

        dropSelf(ModBlocks.PALTO_LOG.get());
        dropSelf(ModBlocks.PALTO_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PALTO_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PALTO_WOOD.get());
        dropSelf(ModBlocks.PALTO_PLANKS.get());
        dropSelf(ModBlocks.SEMILLA_PALTA.get());
        add(ModBlocks.PALTO_LEAVES.get(), block ->
                createModLeavesDrops(block, ModItems.PALTA.get(), 0.5F, 0.5556F, 0.625F, 0.8333F));
        add(ModBlocks.PALTO_LEAVES_EMPTY.get(), this::createEmptyLeavesDrops);

        dropSelf(ModBlocks.LIMONERO_STAIRS.get());
        add(ModBlocks.LIMONERO_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LIMONERO_SLAB.get()));
        dropSelf(ModBlocks.LIMONERO_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.LIMONERO_BUTTON.get());
        dropSelf(ModBlocks.LIMONERO_FENCE.get());
        dropSelf(ModBlocks.LIMONERO_FENCE_GATE.get());
        add(ModBlocks.LIMONERO_DOOR.get(),
                block -> createDoorTable(ModBlocks.LIMONERO_DOOR.get()));
        dropSelf(ModBlocks.LIMONERO_TRAPDOOR.get());

        dropSelf(ModBlocks.PALTO_STAIRS.get());
        add(ModBlocks.PALTO_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALTO_SLAB.get()));
        dropSelf(ModBlocks.PALTO_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PALTO_BUTTON.get());
        dropSelf(ModBlocks.PALTO_FENCE.get());
        dropSelf(ModBlocks.PALTO_FENCE_GATE.get());
        add(ModBlocks.PALTO_DOOR.get(),
                block -> createDoorTable(ModBlocks.PALTO_DOOR.get()));
        dropSelf(ModBlocks.PALTO_TRAPDOOR.get());
    }

    protected LootTable.Builder createModLeavesDrops(Block leavesBlock, Item dropItem, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(leavesBlock,
                        this.applyExplosionCondition(leavesBlock,
                                        LootItem.lootTableItem(dropItem))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                        registrylookup.getOrThrow(Enchantments.FORTUNE), chances)))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(modDoesNotHaveShearsOrSilkTouch())
                        .add(this.applyExplosionDecay(leavesBlock,
                                        LootItem.lootTableItem(Items.STICK)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(1.0F, 2.0F))))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                        registrylookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_STICK_CHANCES))));
    }
    protected LootTable.Builder createEmptyLeavesDrops(Block leavesBlock) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .when(modDoesNotHaveShearsOrSilkTouch())
                        .add(this.applyExplosionDecay(leavesBlock,
                                        LootItem.lootTableItem(Items.STICK)
                                                .apply(SetItemCountFunction.setCount(
                                                        UniformGenerator.between(1.0F, 2.0F))))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(
                                        registrylookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_STICK_CHANCES))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
