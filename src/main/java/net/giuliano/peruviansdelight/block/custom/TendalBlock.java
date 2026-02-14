package net.giuliano.peruviansdelight.block.custom;

import com.mojang.serialization.MapCodec;
import net.giuliano.peruviansdelight.block.entity.TendalBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class TendalBlock extends BaseEntityBlock {
    public static final MapCodec<TendalBlock> CODEC = simpleCodec(TendalBlock::new);
    // Forma de Slab (0 a 8 en altura)
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 8, 16);

    public TendalBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TendalBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        BlockEntity be = level.getBlockEntity(pos);
        if (be instanceof TendalBlockEntity estera) {
            ItemStack heldItem = player.getMainHandItem();

            // Shift + Mano vacía: Sacar el último ítem
            if (player.isCrouching() && heldItem.isEmpty()) {
                extractLastItem(estera, player);
                return InteractionResult.CONSUME;
            }

            // Poner ítem
            if (!heldItem.isEmpty()) {
                insertItem(estera, player, heldItem);
                return InteractionResult.CONSUME;
            }
        }
        return InteractionResult.PASS;
    }

    private void insertItem(TendalBlockEntity be, Player player, ItemStack stack) {
        for (int i = 0; i < be.inventory.getSlots(); i++) {
            if (be.inventory.getStackInSlot(i).isEmpty()) {
                be.inventory.insertItem(i, stack.copyWithCount(1), false);
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                return;
            }
        }
    }

    private void extractLastItem(TendalBlockEntity be, Player player) {
        for (int i = be.inventory.getSlots() - 1; i >= 0; i--) {
            ItemStack stack = be.inventory.getStackInSlot(i);
            if (!stack.isEmpty()) {
                player.getInventory().add(stack);
                be.inventory.setStackInSlot(i, ItemStack.EMPTY);
                return;
            }
        }
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof TendalBlockEntity be) {
                for (int i = 0; i < be.inventory.getSlots(); i++) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), be.inventory.getStackInSlot(i));
                }
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}
