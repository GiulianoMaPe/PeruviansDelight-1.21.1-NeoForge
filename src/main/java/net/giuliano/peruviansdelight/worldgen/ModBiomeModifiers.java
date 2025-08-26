package net.giuliano.peruviansdelight.worldgen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.entity.ModEntities;
import net.giuliano.peruviansdelight.util.ModTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_LIMONERO = registerKey("add_tree_limonero");
    public static final ResourceKey<BiomeModifier> ADD_TREE_PALTO = registerKey("add_tree_palto");
    public static final ResourceKey<BiomeModifier> ADD_AJI_AMARILLO_SILVESTRE = registerKey("add_aji_amarillo_silvestre");
    public static final ResourceKey<BiomeModifier> ADD_KION_SILVESTRE = registerKey("add_kion_silvestre");
    public static final ResourceKey<BiomeModifier> ADD_SOYA_SILVESTRE = registerKey("add_soya_silvestre");
    public static final ResourceKey<BiomeModifier> ADD_CAMOTE_SILVESTRE = registerKey("add_camote_silvestre");
    public static final ResourceKey<BiomeModifier> ADD_YUCA_SILVESTRE = registerKey("add_yuca_silvestre");
    public static final ResourceKey<BiomeModifier> ADD_ATUN = registerKey("add_atun");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_LIMONERO, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LIMONERO_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_TREE_PALTO, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PALTO_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        HolderSet<Biome> cropSpawnBiomes = biomes.getOrThrow(ModTags.Biomes.SPAWN_CROPS_IN);

        context.register(ADD_AJI_AMARILLO_SILVESTRE, new BiomeModifiers.AddFeaturesBiomeModifier(cropSpawnBiomes,
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.AJI_AMARILLO_SILVESTRE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_KION_SILVESTRE, new BiomeModifiers.AddFeaturesBiomeModifier(cropSpawnBiomes,
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.KION_SILVESTRE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_SOYA_SILVESTRE, new BiomeModifiers.AddFeaturesBiomeModifier(cropSpawnBiomes,
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SOYA_SILVESTRE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_CAMOTE_SILVESTRE, new BiomeModifiers.AddFeaturesBiomeModifier(cropSpawnBiomes,
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CAMOTE_SILVESTRE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_YUCA_SILVESTRE, new BiomeModifiers.AddFeaturesBiomeModifier(cropSpawnBiomes,
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.YUCA_SILVESTRE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_ATUN, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.OCEAN),
                        biomes.getOrThrow(Biomes.DEEP_OCEAN),
                        biomes.getOrThrow(Biomes.WARM_OCEAN),
                        biomes.getOrThrow(Biomes.LUKEWARM_OCEAN),
                        biomes.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN),
                        biomes.getOrThrow(Biomes.COLD_OCEAN),
                        biomes.getOrThrow(Biomes.DEEP_COLD_OCEAN)
                ),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.ATUN.get(), 20, 4, 8))));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, name));
    }
}
