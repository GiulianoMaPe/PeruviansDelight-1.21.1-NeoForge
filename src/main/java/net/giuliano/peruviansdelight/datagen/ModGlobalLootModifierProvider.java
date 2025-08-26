package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.item.ModItems;
import net.giuliano.peruviansdelight.loot.AddItemModifier;
import net.giuliano.peruviansdelight.loot.AddRandomCountItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, PeruviansDelight.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("lana_from_llama_x_color",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/llama")).build()
                }, Items.WHITE_WOOL));

        this.add("pota_for_calamar",
                new AddRandomCountItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/squid")).build()
                }, ModItems.TENTACULO_POTA.get(), 6, 8));
        this.add("pota_for_glow_calamar",
                new AddRandomCountItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/glow_squid")).build()
                }, ModItems.TENTACULO_POTA.get(), 6, 8));

        this.add("inka_for_chest1",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/pillager_outpost")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest2",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/desert_pyramid")).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest3",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build(),
                        LootItemRandomChanceCondition.randomChance(0.30f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest4",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/stronghold_library")).build(),
                        LootItemRandomChanceCondition.randomChance(0.40f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest5",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(0.20f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest6",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ruined_portal")).build(),
                        LootItemRandomChanceCondition.randomChance(0.10f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest7",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/igloo_chest")).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest8",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/buried_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest9",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/nether_bridge")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest10",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/end_city_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(0.8f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest11",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/ancient_city")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest12",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/jungle_temple")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest13",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_armorer")).build(),
                        LootItemRandomChanceCondition.randomChance(0.1f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest14",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/village/village_butcher")).build(),
                        LootItemRandomChanceCondition.randomChance(0.3f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest15",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_bridge")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest16",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/bastion_treasure")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest17",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/woodland_mansion")).build(),
                        LootItemRandomChanceCondition.randomChance(0.5f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest18",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/underwater_ruin_big")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, ModItems.INCA_KOLA.get()));
        this.add("inka_for_chest19",
                new AddItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/underwater_ruin_small")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build(),
                }, ModItems.INCA_KOLA.get()));
    }
}
