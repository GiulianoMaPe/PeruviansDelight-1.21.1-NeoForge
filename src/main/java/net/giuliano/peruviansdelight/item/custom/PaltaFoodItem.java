package net.giuliano.peruviansdelight.item.custom;

import net.giuliano.peruviansdelight.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PaltaFoodItem extends Item {
    public PaltaFoodItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack semilla = new ItemStack(ModBlocks.SEMILLA_PALTA.get(), 1);
        if (!level.isClientSide) {
            level.playSound(
                    null,
                    livingEntity.blockPosition(),
                    SoundEvents.LLAMA_SPIT,
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );
            if (livingEntity instanceof Player player) {
                if (stack.isEmpty()) {
                    return semilla;
                } else {
                    if (!player.getInventory().add(semilla)) {
                        player.drop(semilla, false);
                    }
                }
            }
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }


    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_EAT;
    }
}
