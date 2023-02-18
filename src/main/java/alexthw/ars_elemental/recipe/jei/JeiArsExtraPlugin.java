package alexthw.ars_elemental.recipe.jei;

import alexthw.ars_elemental.ArsElemental;
import alexthw.ars_elemental.recipe.ElementalArmorRecipe;
import alexthw.ars_elemental.recipe.NetheriteUpgradeRecipe;
import com.hollingsworth.arsnouveau.setup.BlockRegistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JeiArsExtraPlugin implements IModPlugin {

    public static final RecipeType<ElementalArmorRecipe> ELEMENTAL_ARMOR_TYPE = RecipeType.create(ArsElemental.MODID, "armor_upgrade", ElementalArmorRecipe.class);
    public static final RecipeType<NetheriteUpgradeRecipe> SPELLBOOK_NETHERITE_TYPE = RecipeType.create(ArsElemental.MODID, "netherite_upgrade", NetheriteUpgradeRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ArsElemental.MODID, "main");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(
                new ElementalUpgradeRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
                new SpellBookUpgradeRecipeCategory(registry.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registry) {
        assert Minecraft.getInstance().level != null;
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();
        List<ElementalArmorRecipe> armorRecipes = new ArrayList<>();
        List<NetheriteUpgradeRecipe> spellbook = new ArrayList<>();
        for (Recipe<?> i : manager.getRecipes()) {
            if (i instanceof ElementalArmorRecipe aer) {
                armorRecipes.add(aer);
            } else if (i instanceof NetheriteUpgradeRecipe nur) {
                spellbook.add(nur);
            }
        }
        registry.addRecipes(ELEMENTAL_ARMOR_TYPE, armorRecipes);
        registry.addRecipes(SPELLBOOK_NETHERITE_TYPE, spellbook);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registry) {
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.ENCHANTING_APP_BLOCK), ELEMENTAL_ARMOR_TYPE);
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.ENCHANTING_APP_BLOCK), SPELLBOOK_NETHERITE_TYPE);
    }

}


