package net.giuliano.peruviansdelight.item.custom;

import net.minecraft.world.item.ItemStack;

public class DrinkFoil extends ModDrinkItems {
    public DrinkFoil(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
