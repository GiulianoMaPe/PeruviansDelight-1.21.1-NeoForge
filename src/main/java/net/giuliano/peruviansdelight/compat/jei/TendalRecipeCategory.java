package net.giuliano.peruviansdelight.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.block.ModBlocks;
import net.giuliano.peruviansdelight.recipe.TendalRecipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class TendalRecipeCategory implements IRecipeCategory<TendalRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, "tendal");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(PeruviansDelight.MOD_ID, "textures/gui/jei_tendal.png");

    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableAnimated arrow;

    public TendalRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 108, 48);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TENDAL.get()));

        // Flecha estática recortada de la parte inferior de la imagen (ajustado a tu diseño anterior)
        IDrawableStatic staticArrow = helper.createDrawable(TEXTURE, 0, 48, 18, 12);
        this.arrow = helper.createAnimatedDrawable(staticArrow, 200, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public mezz.jei.api.recipe.RecipeType<TendalRecipe> getRecipeType() {
        return ModJEIPlugin.TENDAL_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.peruviansdelight.tendal");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, TendalRecipe recipe, IFocusGroup focuses) {
        // En 1.21.1 el "input" de la receta podría llamarse diferente dependiendo de tu implementación de TendalRecipe.
        // Asumo que tu TendalRecipe en 1.21 tiene un campo 'input' tipo Ingredient o similar.

        builder.addSlot(RecipeIngredientRole.INPUT, 18, 16)
                .addIngredients(recipe.input); // Verifica que 'input' sea público en tu TendalRecipe 1.21

        builder.addSlot(RecipeIngredientRole.OUTPUT, 74, 16)
                .addItemStack(recipe.output); // Verifica que 'output' sea público (ItemStack)
    }

    @Override
    public void draw(TendalRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        // Dibujar flecha animada (Coordenadas de tu diseño)
        arrow.draw(guiGraphics, 45, 20);

        // Dibujar tiempo
        int processingTime = recipe.time;
        int seconds = processingTime / 20;
        Component timeString = Component.literal(seconds + "s");

        Minecraft minecraft = Minecraft.getInstance();
        Font font = minecraft.font;
        int stringWidth = font.width(timeString);

        // Posición esquina inferior derecha
        int xPos = (108 - stringWidth - 1);
        int yPos = 40;

        guiGraphics.drawString(font, timeString, xPos, yPos, 0x8B8B8B, false);
    }
}
