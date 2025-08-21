package net.giuliano.peruviansdelight.worldgen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LIMONERO_KEY = registerKey("limonero");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALTO_KEY = registerKey("palto");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        register(context, LIMONERO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.LIMONERO_LOG.get()),
                new StraightTrunkPlacer(4, 1, 0),

                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.LIMONERO_LEAVES.get().defaultBlockState(), 1)
                        .add(ModBlocks.LIMONERO_LEAVES_EMPTY.get().defaultBlockState(), 1)
                        .build()),

                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, PALTO_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PALTO_LOG.get()),
                new StraightTrunkPlacer(4, 1, 0),

                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                        .add(ModBlocks.PALTO_LEAVES.get().defaultBlockState(), 1)
                        .add(ModBlocks.PALTO_LEAVES_EMPTY.get().defaultBlockState(), 1)
                        .build()),

                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),

                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
