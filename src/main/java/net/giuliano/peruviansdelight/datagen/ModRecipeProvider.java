package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // RECETAS DE CRAFTING
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIMONERO_WOOD.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.LIMONERO_PLANKS.get())
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIMONERO_PLANKS.get(), 4)
                .requires(ModBlocks.LIMONERO_WOOD)
                .unlockedBy("has_limonero_wood", has(ModBlocks.LIMONERO_WOOD)).save(recipeOutput);

        // COCCION DE INGREDIENTES
        createFoodCookingRecipes(recipeOutput, ModItems.RAW_ANTICUCHO, ModItems.ANTICUCHO, 0.35f);
        //createFoodCookingRecipes(recipeOutput, ModItems.CAMOTE, ModItems.CAMOTE_COCIDO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.CAMOTE_CORTADO, ModItems.CAMOTE_FRITO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.POTA_CORTADO, ModItems.CHICHARRON_POTA, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.FILETE_ATUN, ModItems.FILETE_ATUN_COCIDO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.PAPAS_CORTADAS, ModItems.PAPAS_FRITAS, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.YUCA_CORTADA, ModItems.YUCA_FRITA, 0.35f);
    }

    protected static void createFoodCookingRecipes(RecipeOutput recipeOutput, ItemLike input, ItemLike output, float experience) {
        int smeltingTime = 200;
        int smokingTime = 100;
        int campfireTime = 600;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.MISC, output, experience, smeltingTime)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, getItemName(output) + "_from_smelting");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.MISC, output, experience, smokingTime)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, getItemName(output) + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.MISC, output, experience, campfireTime)
                .unlockedBy(getHasName(input), has(input))
                .save(recipeOutput, getItemName(output) + "_from_campfire_cooking");
    }
}
