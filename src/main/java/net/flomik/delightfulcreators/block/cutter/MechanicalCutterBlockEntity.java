package net.flomik.delightfulcreators.block.cutter;

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
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

/**
 * Runs every Farmer's Delight cutting board recipe found on items passing on a belt/depot or
 * dropped in the world above this block, reusing Create's Mechanical Press animation and belt
 * processing behaviour. Unlike the Mechanical Press, this block entity never looks for a basin
 * underneath it.
 */
public class MechanicalCutterBlockEntity extends KineticBlockEntity implements PressingBehaviourSpecifics {

    private static final RecipeWrapper CUTTING_INV = new RecipeWrapper(new ItemStackHandler(1));

    public PressingBehaviour pressingBehaviour;
    private CuttingBoardRecipe lastRecipe;

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
        Optional<CuttingBoardRecipe> recipe = getRecipe(item);
        if (recipe.isEmpty())
            return false;
        if (simulate)
            return true;

        pressingBehaviour.particleItems.add(item);

        if (canProcessInBulk() || item.getCount() == 1) {
            List<ItemStack> results = rollRecipeResults(recipe.get(), item.getCount());
            if (results.isEmpty()) {
                itemEntity.discard();
            } else {
                itemEntity.setItem(results.remove(0));
                for (ItemStack additional : results)
                    spawnResultEntity(itemEntity, additional);
            }
        } else {
            for (ItemStack result : rollRecipeResults(recipe.get(), 1))
                spawnResultEntity(itemEntity, result);
            item.shrink(1);
        }

        return true;
    }

    @Override
    public boolean tryProcessOnBelt(TransportedItemStack input, List<ItemStack> outputList, boolean simulate) {
        Optional<CuttingBoardRecipe> recipe = getRecipe(input.stack);
        if (recipe.isEmpty())
            return false;
        if (simulate)
            return true;

        pressingBehaviour.particleItems.add(input.stack);
        int amount = canProcessInBulk() ? input.stack.getCount() : 1;
        outputList.addAll(rollRecipeResults(recipe.get(), amount));
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
            for (ItemStack rolled : recipe.rollResults(level.random, 0, CUTTING_INV)) {
                if (rolled.isEmpty())
                    continue;

                ItemStack stack = rolled.copy();
                for (ItemStack previouslyRolled : stacks) {
                    if (stack.isEmpty() || !ItemHandlerHelper.canItemStacksStack(stack, previouslyRolled))
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

    public Optional<CuttingBoardRecipe> getRecipe(ItemStack item) {
        CUTTING_INV.setItem(0, item);
        if (lastRecipe != null && lastRecipe.matches(CUTTING_INV, level))
            return Optional.of(lastRecipe);

        Optional<CuttingBoardRecipe> recipe =
                level.getRecipeManager().getRecipeFor(ModRecipeTypes.CUTTING.get(), CUTTING_INV, level);
        recipe.ifPresent(r -> lastRecipe = r);
        return recipe;
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
