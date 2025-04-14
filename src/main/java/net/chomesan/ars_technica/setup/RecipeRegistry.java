package net.chomesan.ars_technica.setup;

import net.chomesan.ars_technica.YAArsTechnicaMod;
import net.chomesan.ars_technica.recipe.TechnomancerArmorRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RecipeRegistry {
  public static final DeferredRegister<RecipeType<?>> RECIPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES,
      YAArsTechnicaMod.MODID);
  public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister
      .create(ForgeRegistries.RECIPE_SERIALIZERS, YAArsTechnicaMod.MODID);

  public static void register(IEventBus eventBus) {
    RECIPES.register(eventBus);
    SERIALIZERS.register(eventBus);
  }

  public static final RegistryObject<RecipeType<TechnomancerArmorRecipe>> TECHNOMANCER_ARMOR_UP = RECIPES.register(
      "technomancer_armor_up",
      () -> RecipeType.simple(new ResourceLocation(YAArsTechnicaMod.MODID, "technomancer_armor_up")));
  public static final RegistryObject<RecipeSerializer<TechnomancerArmorRecipe>> TECHNOMANCER_ARMOR_UP_SERIALIZER = SERIALIZERS
      .register("armor_upgrade", TechnomancerArmorRecipe.Serializer::new);

}
