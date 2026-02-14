package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // RECETAS DE CRAFTING
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIMONERO_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.LIMONERO_LOG.get())
                .unlockedBy("has_limonero_log", has(ModBlocks.LIMONERO_LOG))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIPPED_LIMONERO_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.STRIPPED_LIMONERO_LOG.get())
                .unlockedBy("has_stripped_limonero_log", has(ModBlocks.STRIPPED_LIMONERO_LOG))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PALTO_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.PALTO_LOG.get())
                .unlockedBy("has_palto_log", has(ModBlocks.PALTO_LOG))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIPPED_PALTO_WOOD.get(), 3)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.STRIPPED_PALTO_LOG.get())
                .unlockedBy("has_stripped_palto_log", has(ModBlocks.STRIPPED_PALTO_LOG))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.LIMONERO_PLANKS.get(), 4)
                .requires(anyOf(ModBlocks.LIMONERO_LOG, ModBlocks.LIMONERO_WOOD, ModBlocks.STRIPPED_LIMONERO_LOG, ModBlocks.STRIPPED_LIMONERO_WOOD))
                .unlockedBy("has_limonero_log", has(ModBlocks.LIMONERO_LOG))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PALTO_PLANKS.get(), 4)
                .requires(anyOf(ModBlocks.PALTO_LOG, ModBlocks.PALTO_WOOD, ModBlocks.STRIPPED_PALTO_LOG, ModBlocks.STRIPPED_PALTO_WOOD))
                .unlockedBy("has_limonero_log", has(ModBlocks.PALTO_LOG))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STRING, 4)
                .requires(ItemTags.WOOL)
                .unlockedBy("has_wool", has(ItemTags.WOOL))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AJI_AMARILLO_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.AJI_AMARILLO.get())
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AJI_AMARILLO, 9)
                .requires(ModBlocks.AJI_AMARILLO_CRATE.get())
                .unlockedBy("has_aji_amarillo_crate", has(ModBlocks.AJI_AMARILLO_CRATE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CAMOTE_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.CAMOTE.get())
                .unlockedBy("has_camote", has(ModItems.CAMOTE))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CAMOTE, 9)
                .requires(ModBlocks.CAMOTE_CRATE.get())
                .unlockedBy("has_camote_crate", has(ModBlocks.CAMOTE_CRATE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KION_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.KION.get())
                .unlockedBy("has_kion", has(ModItems.KION))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KION, 9)
                .requires(ModBlocks.KION_CRATE.get())
                .unlockedBy("has_kion_crate", has(ModBlocks.KION_CRATE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIMON_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.LIMON.get())
                .unlockedBy("has_limon", has(ModItems.LIMON))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIMON, 9)
                .requires(ModBlocks.LIMON_CRATE.get())
                .unlockedBy("has_limon_crate", has(ModBlocks.LIMON_CRATE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PALTA_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.PALTA.get())
                .unlockedBy("has_palta", has(ModItems.PALTA))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PALTA, 9)
                .requires(ModBlocks.PALTA_CRATE.get())
                .unlockedBy("has_palta_crate", has(ModBlocks.PALTA_CRATE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOYA_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.VAINA_SOYA.get())
                .unlockedBy("has_vaina_soya", has(ModItems.VAINA_SOYA))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VAINA_SOYA, 9)
                .requires(ModBlocks.SOYA_CRATE.get())
                .unlockedBy("has_soya_crate", has(ModBlocks.SOYA_CRATE))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.YUCA_CRATE.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.YUCA.get())
                .unlockedBy("has_yuca", has(ModItems.YUCA))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.YUCA, 9)
                .requires(ModBlocks.YUCA_CRATE.get())
                .unlockedBy("has_yuca_crate", has(ModBlocks.YUCA_CRATE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOYA_BAG.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.GRANOS_SOYA.get())
                .unlockedBy("has_granos_soya", has(ModItems.GRANOS_SOYA))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRANOS_SOYA, 9)
                .requires(ModBlocks.SOYA_BAG.get())
                .unlockedBy("has_soya_bag", has(ModBlocks.SOYA_BAG))
                .save(recipeOutput, "granos_soya_from_soya_bag");

        //COMIDAS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MOSTRITO.get(), 2)
                .requires(ModItems.POLLO_BRASA)
                .requires(ModItems.CHAUFA)
                .unlockedBy("has_pollo_brasa", has(ModItems.POLLO_BRASA))
                .unlockedBy("has_chaufa", has(ModItems.CHAUFA))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRANOS_SOYA.get(), 2)
                .requires(ModItems.VAINA_SOYA)
                .unlockedBy("has_vaina_soya", has(ModItems.VAINA_SOYA))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HUANCAINA.get(), 2)
                .requires(Items.BOWL)
                .requires(anyOf(ModItems.AJI_AMARILLO, ModItems.POTE_AJI_AMARILLO))
                .requires(Tags.Items.FOODS_BREAD)
                .requires(Tags.Items.BUCKETS_MILK)
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POTE_AJI_AMARILLO.get(), 2)
                .pattern("#S#")
                .define('#', Items.GLASS_BOTTLE)
                .define('S', ModItems.AJI_AMARILLO.get())
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ANTICUCHO.get())
                .requires(ModItems.RAW_HEART_SLICES)
                .requires(Items.STICK)
                .unlockedBy("has_raw_heart_slices", has(ModItems.RAW_HEART_SLICES))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SEMILLAS_AJI_AMARILLO.get())
                .requires(ModItems.AJI_AMARILLO)
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILLAO.get())
                .requires(ModItems.GRANOS_SOYA)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_granos_soya", has(ModItems.GRANOS_SOYA))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.SEMILLAS_LIMON.get())
                .requires(ModItems.LIMON)
                .unlockedBy("has_limon", has(ModItems.LIMON))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.SEMILLA_PALTA.get())
                .requires(ModItems.PALTA)
                .unlockedBy("has_palta", has(ModItems.PALTA))
                .save(recipeOutput);

        // COCCION DE INGREDIENTES
        createFoodCookingRecipes(recipeOutput, ModItems.RAW_ANTICUCHO, ModItems.ANTICUCHO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.CAMOTE, ModItems.CAMOTE_COCIDO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.CAMOTE_CORTADO, ModItems.CAMOTE_FRITO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.POTA_CORTADO, ModItems.CHICHARRON_POTA, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.FILETE_ATUN, ModItems.FILETE_ATUN_COCIDO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.PAPAS_CORTADAS, ModItems.PAPAS_FRITAS, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.YUCA_CORTADA, ModItems.YUCA_FRITA, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.CHULETA_CORTADA, ModItems.CHICHARRON, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.LLAMA, ModItems.LLAMA_ASADA, 0.35f);

        // TENDAL
        buildTendalRecipe(recipeOutput, ModItems.LLAMA, ModItems.CHARQUI, 20, "charqui_from_tendal"); //20 ticks = 1 segundo

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

    private static Ingredient anyOf(ItemLike... items) {
        return Ingredient.of(items);
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

    protected void buildTendalRecipe(RecipeOutput pWriter, ItemLike input, ItemLike output, int time, String name) {
        TendalRecipe recipe = new TendalRecipe(
                Ingredient.of(input), new ItemStack(output), time);
        pWriter.accept(
                ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, name), recipe, null);
    }
}
