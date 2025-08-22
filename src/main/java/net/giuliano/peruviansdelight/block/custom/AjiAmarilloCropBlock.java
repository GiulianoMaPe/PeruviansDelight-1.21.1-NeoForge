package net.giuliano.peruviansdelight.block.custom;

import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AjiAmarilloCropBlock extends CropBlock {
    public static final int MAX_AGE = 7;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);
    private static final VoxelShape[] SHAPE_BY_AGE =
            new VoxelShape[] {
                    Block.box(4.0D, 0.0D, 4.0D, 12.0D, 7.0D, 12.0D), Block.box(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D),
                    Block.box(3.0D, 0.0D, 3.0D, 13.0D, 13.0D, 13.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D),
                    Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D),
                    Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D), Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D)
            };

    public AjiAmarilloCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHit) {
        int i = pState.getValue(AGE);
        // Si la planta no está madura, no hacemos nada.
        if (i < 7) {
            return InteractionResult.PASS;
        }

        // Si la planta está madura (edad 7), ejecutamos la lógica de cosecha.
        int j = 2 + pLevel.random.nextInt(2);
        popResource(pLevel, pPos, new ItemStack(ModItems.AJI_AMARILLO.get(), j + (i == 7 ? 1 : 0))); // Usamos i == 7 para más claridad
        pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);

        BlockState blockstate = pState.setValue(AGE, 3); // Reestablecemos la edad a 3
        pLevel.setBlock(pPos, blockstate, 2);
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, blockstate));

        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        // Si el ítem en la mano es polvo de hueso y la planta PUEDE crecer...
        if (pStack.is(Items.BONE_MEAL) && pState.getValue(AGE) < 7) {
            // ...no hacemos nada aquí y dejamos que el comportamiento por defecto del polvo de hueso actúe.
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        // Para cualquier otro ítem, o si la planta ya está madura,
        // le decimos al juego que ignore el ítem y proceda a la interacción normal (llamar a useWithoutItem).
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.SEMILLAS_AJI_AMARILLO.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
