package net.giuliano.peruviansdelight.event;

import net.giuliano.peruviansdelight.item.ModItems;
import net.giuliano.peruviansdelight.util.ModTags;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;

public class ModEvents {

    @SubscribeEvent
    public void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntity() instanceof Cow cow) {
            if (event.getSource().getEntity() instanceof Player player) {
                ItemStack weapon = player.getMainHandItem();

                if (weapon.is(ModTags.Items.KNIVES)) {
                    ItemEntity heartDrop = new ItemEntity(cow.level(), cow.getX(), cow.getY(), cow.getZ(),
                            new ItemStack(ModItems.BEEF_HEART.get()));
                    event.getDrops().add(heartDrop);
                }
            }
        }
    }
}
