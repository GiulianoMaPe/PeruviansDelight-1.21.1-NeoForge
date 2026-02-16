package net.giuliano.peruviansdelight.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.recipe.ModRecipes;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class ModJEIPlugin implements IModPlugin {
    public static final RecipeType<TendalRecipe> TENDAL_TYPE =
            new RecipeType<>(ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, "tendal"), TendalRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TendalRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Minecraft.getInstance().level.getRecipeManager();

        // En 1.21, getAllRecipesFor devuelve una lista de RecipeHolder.
        // Convertimos RecipeHolder -> TendalRecipe usando .map(RecipeHolder::value)
        List<TendalRecipe> recipes = rm.getAllRecipesFor(ModRecipes.TENDAL_TYPE.get())
                .stream()
                .map(RecipeHolder::value)
                .toList();

        registration.addRecipes(TENDAL_TYPE, recipes);
    }
}
