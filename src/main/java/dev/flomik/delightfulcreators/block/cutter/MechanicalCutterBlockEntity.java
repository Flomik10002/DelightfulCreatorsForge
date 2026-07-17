package dev.flomik.delightfulcreators.block.cutter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
import com.simibubi.create.content.kinetics.press.PressingBehaviour.PressingBehaviourSpecifics;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;

import net.createmod.catnip.math.VecHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipeInput;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

/**
 * Runs every Farmer's Delight cutting board recipe found on items passing on a belt/depot or
 * dropped in the world above this block, reusing Create's Mechanical Press animation and belt
 * processing behaviour. Unlike the Mechanical Press, this block entity never looks for a basin
 * underneath it.
 */
public class MechanicalCutterBlockEntity extends KineticBlockEntity implements PressingBehaviourSpecifics {

    public PressingBehaviour pressingBehaviour;

    public MechanicalCutterBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    protected AABB createRenderBoundingBox() {
        return new AABB(worldPosition).expandTowards(0, -1.5, 0)
                .expandTowards(0, 1, 0);
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);
        pressingBehaviour = new PressingBehaviour(this);
        behaviours.add(pressingBehaviour);
    }

    public PressingBehaviour getPressingBehaviour() {
        return pressingBehaviour;
    }

    @Override
    public boolean tryProcessInBasin(boolean simulate) {
        return false;
    }

    @Override
    public boolean tryProcessInWorld(ItemEntity itemEntity, boolean simulate) {
        ItemStack item = itemEntity.getItem();
        Optional<RecipeHolder<CuttingBoardRecipe>> recipe = getRecipe(item);
        if (recipe.isEmpty())
            return false;
        if (simulate)
            return true;

        pressingBehaviour.particleItems.add(item);

        if (canProcessInBulk() || item.getCount() == 1) {
            List<ItemStack> results = rollRecipeResults(recipe.get().value(), item.getCount());
            if (results.isEmpty()) {
                itemEntity.discard();
            } else {
                itemEntity.setItem(results.remove(0));
                for (ItemStack additional : results)
                    spawnResultEntity(itemEntity, additional);
            }
        } else {
            for (ItemStack result : rollRecipeResults(recipe.get().value(), 1))
                spawnResultEntity(itemEntity, result);
            item.shrink(1);
        }

        return true;
    }

    @Override
    public boolean tryProcessOnBelt(TransportedItemStack input, List<ItemStack> outputList, boolean simulate) {
        Optional<RecipeHolder<CuttingBoardRecipe>> recipe = getRecipe(input.stack);
        if (recipe.isEmpty())
            return false;
        if (simulate)
            return true;

        pressingBehaviour.particleItems.add(input.stack);
        int amount = canProcessInBulk() ? input.stack.getCount() : 1;
        outputList.addAll(rollRecipeResults(recipe.get().value(), amount));
        return true;
    }

    @Override
    public void onPressingCompleted() {
        // No basin to hand off to - nothing further to do once the animation finishes.
    }

    private void spawnResultEntity(ItemEntity source, ItemStack stack) {
        ItemEntity created = new ItemEntity(level, source.getX(), source.getY(), source.getZ(), stack);
        created.setDefaultPickUpDelay();
        created.setDeltaMovement(VecHelper.offsetRandomly(Vec3.ZERO, level.random, .05f));
        level.addFreshEntity(created);
    }

    private List<ItemStack> rollRecipeResults(CuttingBoardRecipe recipe, int count) {
        List<ItemStack> stacks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            for (ItemStack rolled : recipe.rollResults(level.random, 0, null)) {
                if (rolled.isEmpty())
                    continue;

                ItemStack stack = rolled.copy();
                for (ItemStack previouslyRolled : stacks) {
                    if (stack.isEmpty() || !ItemStack.isSameItemSameComponents(stack, previouslyRolled))
                        continue;
                    int mergeAmount = Math.min(previouslyRolled.getMaxStackSize() - previouslyRolled.getCount(),
                            stack.getCount());
                    previouslyRolled.grow(mergeAmount);
                    stack.shrink(mergeAmount);
                }

                if (!stack.isEmpty())
                    stacks.add(stack);
            }
        }
        return stacks;
    }

    /**
     * This block has no held tool of its own, so a representative item from the recipe's own tool
     * ingredient is used purely to satisfy {@link CuttingBoardRecipe#matches} - it is never
     * consumed or damaged.
     */
    private ItemStack anyToolFor(Ingredient toolIngredient) {
        ItemStack[] items = toolIngredient.getItems();
        return items.length > 0 ? items[0] : ItemStack.EMPTY;
    }

    public Optional<RecipeHolder<CuttingBoardRecipe>> getRecipe(ItemStack item) {
        for (RecipeHolder<CuttingBoardRecipe> candidate : level.getRecipeManager()
                .getAllRecipesFor(ModRecipeTypes.CUTTING.get())) {
            CuttingBoardRecipe recipe = candidate.value();
            if (!recipe.getIngredients().get(0).test(item))
                continue;
            ItemStack tool = anyToolFor(recipe.getTool());
            if (tool.isEmpty())
                continue;
            if (recipe.matches(new CuttingBoardRecipeInput(item, tool), level))
                return Optional.of(candidate);
        }
        return Optional.empty();
    }

    @Override
    public float getKineticSpeed() {
        return getSpeed();
    }

    @Override
    public boolean canProcessInBulk() {
        return false;
    }

    @Override
    public int getParticleAmount() {
        return 15;
    }

}
