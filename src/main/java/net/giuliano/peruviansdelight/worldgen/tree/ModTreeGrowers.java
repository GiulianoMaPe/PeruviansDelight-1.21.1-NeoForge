package net.giuliano.peruviansdelight.worldgen.tree;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower LIMONERO = new TreeGrower(PeruviansDelight.MOD_ID + ":limonero",
            Optional.empty(), Optional.of(ModConfiguredFeatures.LIMONERO_KEY), Optional.empty());

    public static final TreeGrower PALTO = new TreeGrower(PeruviansDelight.MOD_ID + ":palto",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PALTO_KEY), Optional.empty());
}
