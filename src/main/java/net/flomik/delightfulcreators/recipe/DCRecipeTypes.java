package net.flomik.delightfulcreators.recipe;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder.ProcessingRecipeFactory;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;

import net.flomik.delightfulcreators.DelightfulCreators;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Our own native Create recipe types, separate from the Farmer's Delight recipes the Mechanical
 * Cutter automates by default. Mirrors how Create registers AllRecipeTypes.PRESSING, so that a
 * CuttingProcessingRecipe can plug into Create's Sequenced Assembly framework the same way
 * PressingRecipe does for the Mechanical Press.
 */
public enum DCRecipeTypes implements IRecipeTypeInfo {

    CUTTING_PROCESSING(CuttingProcessingRecipe::new);

    private final ResourceLocation id;
    private final RegistryObject<RecipeSerializer<?>> serializerObject;
    private final RegistryObject<RecipeType<?>> typeObject;

    DCRecipeTypes(ProcessingRecipeFactory<?> processingFactory) {
        String name = name().toLowerCase();
        id = new ResourceLocation(DelightfulCreators.MOD_ID, name);
        serializerObject = Registers.SERIALIZER_REGISTER.register(name,
                () -> new ProcessingRecipeSerializer<>(processingFactory));
        typeObject = Registers.TYPE_REGISTER.register(name, () -> RecipeType.simple(id));
    }

    public static void register(IEventBus modEventBus) {
        Registers.SERIALIZER_REGISTER.register(modEventBus);
        Registers.TYPE_REGISTER.register(modEventBus);
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeSerializer<?>> T getSerializer() {
        return (T) serializerObject.get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends RecipeType<?>> T getType() {
        return (T) typeObject.get();
    }

    private static class Registers {
        private static final DeferredRegister<RecipeSerializer<?>> SERIALIZER_REGISTER =
                DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DelightfulCreators.MOD_ID);
        private static final DeferredRegister<RecipeType<?>> TYPE_REGISTER =
                DeferredRegister.create(Registries.RECIPE_TYPE, DelightfulCreators.MOD_ID);
    }
}
