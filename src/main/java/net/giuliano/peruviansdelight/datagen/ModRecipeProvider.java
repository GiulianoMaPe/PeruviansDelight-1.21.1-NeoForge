package net.giuliano.peruviansdelight.datagen;

import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.item.ModItems;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import net.giuliano.peruviansdelight.util.ModTags;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;

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
                .requires(ModTags.Items.LIMONERO_LOGS)
                .unlockedBy("has_limonero_log", has(ModTags.Items.LIMONERO_LOGS))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PALTO_PLANKS.get(), 4)
                .requires(ModTags.Items.PALTO_LOGS)
                .unlockedBy("has_palto_log", has(ModTags.Items.PALTO_LOGS))
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
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HABAS.get(), 2)
                .requires(ModItems.VAINA_HABAS)
                .unlockedBy("has_vaina_habas", has(ModItems.VAINA_HABAS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, "habas_from_vaina_habas"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.HUANCAINA.get(), 2)
                .requires(Items.BOWL)
                .requires(ModTags.Items.AJI_AMARILLO_OR_JAR)
                .requires(Tags.Items.FOODS_BREAD)
                .requires(CompoundIngredient.of(
                        Ingredient.of(Tags.Items.BUCKETS_MILK), Ingredient.of(ModTags.Items.MILK_BOTTLES)))
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POTE_AJI_AMARILLO.get(), 2)
                .pattern("#S#")
                .define('#', Items.GLASS_BOTTLE)
                .define('S', ModItems.AJI_AMARILLO.get())
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.POTE_AJI_PANCA.get(), 2)
                .pattern("#S#")
                .define('#', Items.GLASS_BOTTLE)
                .define('S', ModItems.AJI_PANCA_SECO.get())
                .unlockedBy("has_aji_panca_seco", has(ModItems.AJI_PANCA_SECO))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ANTICUCHO.get())
                .requires(ModItems.RAW_HEART_SLICES)
                .requires(Tags.Items.RODS_WOODEN)
                .unlockedBy("has_raw_heart_slices", has(ModItems.RAW_HEART_SLICES))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SEMILLAS_AJI_AMARILLO.get())
                .requires(ModItems.AJI_AMARILLO)
                .unlockedBy("has_aji_amarillo", has(ModItems.AJI_AMARILLO))
                .save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SEMILLAS_AJI_PANCA.get())
                .requires(ModItems.AJI_PANCA)
                .unlockedBy("has_aji_panca", has(ModItems.AJI_PANCA))
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MUD_TILES.get(), 4)
                .pattern("SS")
                .pattern("SS")
                .define('S', Blocks.MUD_BRICKS)
                .unlockedBy("has_mud_bricks", has(Blocks.MUD_BRICKS))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHISELED_MUD_TILES.get(), 2)
                .pattern("S")
                .pattern("S")
                .define('S', ModBlocks.MUD_TILES)
                .unlockedBy("has_mud_tiles", has(ModBlocks.MUD_TILES))
                .save(recipeOutput);

        // CORTADORA DE PIEDRA
        stonecutterResultFromBase(recipeOutput, RecipeCategory.MISC,
                ModBlocks.MUD_TILES, Blocks.MUD_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.MISC,
                ModBlocks.CHISELED_MUD_TILES, Blocks.MUD_BRICKS);
        stonecutterResultFromBase(recipeOutput, RecipeCategory.MISC,
                ModBlocks.CHISELED_MUD_TILES, ModBlocks.MUD_TILES);

        // COCCION DE INGREDIENTES
        createFoodCookingRecipes(recipeOutput, ModItems.RAW_ANTICUCHO, ModItems.ANTICUCHO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.CAMOTE, ModItems.CAMOTE_COCIDO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.CAMOTE_CORTADO, ModItems.CAMOTE_FRITO, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.POTA_CORTADO, ModItems.CHICHARRON_POTA, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.FILETE_ATUN, ModItems.FILETE_ATUN_COCIDO, 0.35f);
        createFoodCookingRecipes(recipeOutput, Ingredient.of(ModTags.Items.CUT_POTATOES),
                "has_papas_cortadas", has(ModTags.Items.CUT_POTATOES), ModItems.PAPAS_FRITAS, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.YUCA_CORTADA, ModItems.YUCA_FRITA, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.CHULETA_CORTADA, ModItems.CHICHARRON, 0.35f);
        createFoodCookingRecipes(recipeOutput, ModItems.LLAMA, ModItems.LLAMA_ASADA, 0.35f);

        // TENDAL
        buildTendalRecipe(recipeOutput, Ingredient.of(ModItems.LLAMA), ModItems.CHARQUI, 9600, "llama_to_charqui_from_tendal"); // 8 min
        buildTendalRecipe(recipeOutput, Ingredient.of(ModTags.Items.RAW_MUTTON), ModItems.CHARQUI, 9600, "mutton_charqui_from_tendal");
        buildTendalRecipe(recipeOutput, Ingredient.of(ModTags.Items.CUT_POTATOES), ModItems.PAPA_SECA, 9600, "papa_seca_from_tendal");
        buildTendalRecipe(recipeOutput, Ingredient.of(ModItems.AJI_PANCA), ModItems.AJI_PANCA_SECO, 9600, "aji_panca_seco_from_tendal");

        //MADERA
        stairBuilder(ModBlocks.LIMONERO_STAIRS.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS)).group("limonero")
            .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIMONERO_SLAB.get(), ModBlocks.LIMONERO_PLANKS.get());
        buttonBuilder(ModBlocks.LIMONERO_BUTTON.get(), Ingredient.of(ModBlocks.LIMONERO_PLANKS)).group("limonero")
                .unlockedBy("has_limonero_planks", has(ModBlocks.LIMONERO_PLANKS)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.LIMONERO_PRESSURE_PLATE.get(), ModBlocks.LIMONERO_PLANKS.get());
        buildWoodenFenceRecipes(recipeOutput, ModBlocks.LIMONERO_PLANKS, ModBlocks.LIMONERO_FENCE,
                ModBlocks.LIMONERO_FENCE_GATE, "limonero");
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
        buildWoodenFenceRecipes(recipeOutput, ModBlocks.PALTO_PLANKS, ModBlocks.PALTO_FENCE, ModBlocks.PALTO_FENCE_GATE, "palto");
        doorBuilder(ModBlocks.PALTO_DOOR.get(), Ingredient.of(ModBlocks.PALTO_PLANKS)).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.PALTO_TRAPDOOR.get(), Ingredient.of(ModBlocks.PALTO_PLANKS)).group("palto")
                .unlockedBy("has_palto_planks", has(ModBlocks.PALTO_PLANKS)).save(recipeOutput);
    }

    private static void buildWoodenFenceRecipes(RecipeOutput recipeOutput, ItemLike planks,
                                                 ItemLike fence, ItemLike fenceGate, String group) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, fence, 3)
                .define('W', planks)
                .define('#', Tags.Items.RODS_WOODEN)
                .pattern("W#W")
                .pattern("W#W")
                .group(group)
                .unlockedBy(getHasName(planks), has(planks))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, fenceGate)
                .define('W', planks)
                .define('#', Tags.Items.RODS_WOODEN)
                .pattern("#W#")
                .pattern("#W#")
                .group(group)
                .unlockedBy(getHasName(planks), has(planks))
                .save(recipeOutput);
    }

    protected static void createFoodCookingRecipes(RecipeOutput recipeOutput, ItemLike input, ItemLike output, float experience) {
        createFoodCookingRecipes(recipeOutput, Ingredient.of(input), getHasName(input), has(input), output, experience);
    }

    private static void createFoodCookingRecipes(RecipeOutput recipeOutput, Ingredient input, String unlockName,
                                                  Criterion<InventoryChangeTrigger.TriggerInstance> unlockCriterion,
                                                  ItemLike output, float experience) {
        int smeltingTime = 200;
        int smokingTime = 100;
        int campfireTime = 600;

        SimpleCookingRecipeBuilder.smelting(input, RecipeCategory.MISC, output, experience, smeltingTime)
                .unlockedBy(unlockName, unlockCriterion)
                .save(recipeOutput, getItemName(output) + "_from_smelting");
        SimpleCookingRecipeBuilder.smoking(input, RecipeCategory.MISC, output, experience, smokingTime)
                .unlockedBy(unlockName, unlockCriterion)
                .save(recipeOutput, getItemName(output) + "_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(input, RecipeCategory.MISC, output, experience, campfireTime)
                .unlockedBy(unlockName, unlockCriterion)
                .save(recipeOutput, getItemName(output) + "_from_campfire_cooking");
    }

    protected void buildTendalRecipe(RecipeOutput pWriter, Ingredient input, ItemLike output, int time, String name) {
        TendalRecipe recipe = new TendalRecipe(input, new ItemStack(output), time);
        pWriter.accept(
                ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, name), recipe, null);
    }
}
