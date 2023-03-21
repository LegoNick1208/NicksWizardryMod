package net.legonick1208.nickswizardry.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.legonick1208.nickswizardry.block.ModBlocks;
import net.legonick1208.nickswizardry.item.ModItems;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
//        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TestItem, RecipeCategory.DECORATIONS, ModBlocks.TestBlock);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.Wand)
                .pattern("  G")
                .pattern(" S ")
                .pattern("S  ")
                .input('S', Items.STICK)
                .input('G', Items.GOLD_INGOT)
                .criterion(FabricRecipeProvider.hasItem(Items.GOLD_INGOT), FabricRecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.Wand)));
    }
}