package net.giuliano.peruviansdelight.item.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class ModDrinkItems extends Item {
    public ModDrinkItems(Properties properties) {
        super(properties);
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, net.minecraft.world.level.Level level, net.minecraft.world.entity.LivingEntity entity) {
        if (entity instanceof net.minecraft.world.entity.player.Player player) {
            if (!player.getAbilities().instabuild) {
                stack.shrink(1);

                ItemStack emptyBottle = new ItemStack(net.minecraft.world.item.Items.GLASS_BOTTLE);

                if (stack.isEmpty()) {
                    return emptyBottle;
                } else {
                    if (!player.getInventory().add(emptyBottle)) {
                        player.drop(emptyBottle, false);
                    }
                }
            }
        } else {
            stack.shrink(1);
        }

        return stack;
    }
}
