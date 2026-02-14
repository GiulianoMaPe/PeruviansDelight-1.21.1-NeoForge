package net.giuliano.peruviansdelight.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class TendalRecipe implements Recipe<RecipeInput> {
    public final Ingredient input;
    public final ItemStack output;
    public final int time; // Tiempo en ticks

    public TendalRecipe(Ingredient input, ItemStack output, int time) {
        this.input = input;
        this.output = output;
        this.time = time;
    }

    @Override
    public boolean matches(RecipeInput pInput, Level pLevel) {
        // Verifica si el ítem en el input coincide con la receta (usamos el slot 0 del input simple)
        return this.input.test(pInput.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeInput pInput, HolderLookup.Provider pRegistries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.TENDAL_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.TENDAL_TYPE.get();
    }

    // SERIALIZER
    public static class Serializer implements RecipeSerializer<TendalRecipe> {
        public static final MapCodec<TendalRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(r -> r.input),
                ItemStack.CODEC.fieldOf("result").forGetter(r -> r.output),
                Codec.INT.fieldOf("time").forGetter(r -> r.time)
        ).apply(inst, TendalRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, TendalRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, r -> r.input,
                ItemStack.STREAM_CODEC, r -> r.output,
                net.minecraft.network.codec.ByteBufCodecs.INT, r -> r.time,
                TendalRecipe::new
        );

        @Override
        public MapCodec<TendalRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, TendalRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
