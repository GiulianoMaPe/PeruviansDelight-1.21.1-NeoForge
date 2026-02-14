package net.giuliano.peruviansdelight.recipe;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, PeruviansDelight.MOD_ID);

    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, PeruviansDelight.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<TendalRecipe>> TENDAL_SERIALIZER =
            SERIALIZERS.register("tendal", TendalRecipe.Serializer::new);

    public static final DeferredHolder<RecipeType<?>, RecipeType<TendalRecipe>> TENDAL_TYPE =
            TYPES.register("tendal", () -> new RecipeType<TendalRecipe>() {
                @Override
                public String toString() {
                    return "tendal";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
