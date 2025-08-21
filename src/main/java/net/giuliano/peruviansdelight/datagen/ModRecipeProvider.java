package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

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

        //MADERA
        stairBuilder(ModBlocks.LIMONERO_STAIRS.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS)).group("limonero")
            .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMONERO_SLAB.get(), ModBlocks.LIMONERO_PLANKS.get());
        buttonBuilder(ModBlocks.LIMONERO_BUTTON.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS)).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.LIMONERO_PRESSURE_PLATE.get(), ModBlocks.LIMONERO_PLANKS.get());
        fenceBuilder(ModBlocks.LIMONERO_FENCE.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS)).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.LIMONERO_FENCE_GATE.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS)).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.LIMONERO_DOOR.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS)).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.LIMONERO_TRAPDOOR.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS)).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);

        stairBuilder(ModBlocks.PALTO_STAIRS.get(), Ingredient.of(ModBlocks.PALTO_PLANKS)).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALTO_SLAB.get(), ModBlocks.PALTO_PLANKS.get());
        buttonBuilder(ModBlocks.PALTO_BUTTON.get(), Ingredient.of(ModBlocks.PALTO_PLANKS)).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.PALTO_PRESSURE_PLATE.get(), ModBlocks.PALTO_PLANKS.get());
        fenceBuilder(ModBlocks.PALTO_FENCE.get(), Ingredient.of(ModBlocks.PALTO_PLANKS)).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.PALTO_FENCE_GATE.get(), Ingredient.of(ModBlocks.PALTO_PLANKS)).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS)).save(recipeOutput);
        doorBuilder(ModBlocks.PALTO_DOOR.get(), Ingredient.of(ModBlocks.PALTO_PLANKS)).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.PALTO_TRAPDOOR.get(), Ingredient.of(ModBlocks.PALTO_PLANKS)).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS)).save(recipeOutput);
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
