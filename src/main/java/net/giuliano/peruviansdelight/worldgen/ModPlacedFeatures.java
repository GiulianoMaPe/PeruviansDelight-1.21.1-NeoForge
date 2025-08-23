package net.giuliano.peruviansdelight.worldgen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> LIMONERO_PLACED_KEY = registerKey("limonero_placed");
    public static final ResourceKey<PlacedFeature> PALTO_PLACED_KEY = registerKey("palto_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, LIMONERO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIMONERO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.02f, 2),
                        ModBlocks.SEMILLAS_LIMON.get()));
        register(context, PALTO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALTO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.02f, 2),
                        ModBlocks.SEMILLA_PALTA.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
