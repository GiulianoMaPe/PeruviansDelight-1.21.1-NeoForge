package net.giuliano.peruviansdelight.block.entity;

import net.giuliano.peruviansdelight.recipe.ModRecipes;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.Optional;

public class TendalBlockEntity extends BlockEntity {
    // 9 slots
    public final ItemStackHandler inventory = new ItemStackHandler(9) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (level != null && !level.isClientSide) {
                level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
                // Si cambia el item, reseteamos el progreso de ese slot
                progress[slot] = 0;
                maxProgress[slot] = 0;
            }
        }

        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            ItemStack stack = this.getStackInSlot(slot);

            // Chequeamos si este ítem tiene receta
            if (level != null && !stack.isEmpty()) {
                SingleRecipeInput recipeInput = new SingleRecipeInput(stack);
                boolean hasRecipe = level.getRecipeManager()
                        .getRecipeFor(ModRecipes.TENDAL_TYPE.get(), recipeInput, level)
                        .isPresent();

                // Si tiene receta NO dejamos sacarlo
                if (hasRecipe) {
                    return ItemStack.EMPTY;
                }
            }

            // Si no tiene receta dejamos que la tolva lo saque
            return super.extractItem(slot, amount, simulate);
        }
    };

    // Arrays para guardar el progreso de cada uno de los 9 slots
    private final int[] progress = new int[9];
    private final int[] maxProgress = new int[9];

    public TendalBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.TENDAL_BE.get(), pos, blockState);
    }

    // LÓGICA DEL TICK (Procesamiento)
    public static void tick(Level level, BlockPos pos, BlockState state, TendalBlockEntity entity) {
        if (level.isClientSide) return;

        // Condiciones ambientales
        boolean esDeDia = level.isDay();
        boolean sinSombra = level.canSeeSky(pos.above());
        if (!esDeDia || !sinSombra) return;
        if (level.isRainingAt(pos.above())) return;

        for (int i = 0; i < entity.inventory.getSlots(); i++) {
            ItemStack stack = entity.inventory.getStackInSlot(i);

            if (!stack.isEmpty()) {
                // Si no sabemos el tiempo máximo, buscamos la receta
                if (entity.maxProgress[i] <= 0) {
                    SingleRecipeInput recipeInput = new SingleRecipeInput(stack);
                    Optional<TendalRecipe> recipe = level.getRecipeManager()
                            .getRecipeFor(ModRecipes.TENDAL_TYPE.get(), recipeInput, level)
                            .map(r -> r.value());

                    if (recipe.isPresent()) {
                        entity.maxProgress[i] = recipe.get().time;
                    } else {
                        // No hay receta válida, no hacemos nada (o reseteamos)
                        entity.progress[i] = 0;
                        continue;
                    }
                }

                // Aumentar progreso
                entity.progress[i]++;

                // Verificar si terminó
                if (entity.progress[i] >= entity.maxProgress[i]) {
                    craftItem(level, pos, entity, i);
                }
            } else {
                // Slot vacío, resetear
                entity.progress[i] = 0;
                entity.maxProgress[i] = 0;
            }
        }
    }

    private static void craftItem(Level level, BlockPos pos, TendalBlockEntity entity, int slot) {
        ItemStack stack = entity.inventory.getStackInSlot(slot);
        SingleRecipeInput recipeInput = new SingleRecipeInput(stack);

        Optional<TendalRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ModRecipes.TENDAL_TYPE.get(), recipeInput, level)
                .map(r -> r.value());

        if (recipe.isPresent()) {
            ItemStack output = recipe.get().output.copy();

            entity.inventory.setStackInSlot(slot, output);

            entity.progress[slot] = 0;
            entity.maxProgress[slot] = 0;
        }
    }

    // GUARDADO DE DATOS (NBT)
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
        tag.putIntArray("progress", progress);
        tag.putIntArray("maxProgress", maxProgress);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));

        int[] loadedProgress = tag.getIntArray("progress");
        if (loadedProgress.length == 9) System.arraycopy(loadedProgress, 0, progress, 0, 9);

        int[] loadedMax = tag.getIntArray("maxProgress");
        if (loadedMax.length == 9) System.arraycopy(loadedMax, 0, maxProgress, 0, 9);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }
}
