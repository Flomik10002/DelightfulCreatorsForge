package net.flomik.delightfulcreators.block.cutter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.simibubi.create.content.kinetics.belt.transport.TransportedItemStack;
import com.simibubi.create.content.kinetics.press.PressingBehaviour;
import com.simibubi.create.content.kinetics.press.PressingBehaviour.Mode;
import com.simibubi.create.content.kinetics.press.PressingBehaviour.PressingBehaviourSpecifics;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.basin.BasinOperatingBlockEntity;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipe;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.item.SmartInventory;
import com.simibubi.create.foundation.recipe.RecipeApplier;

import net.createmod.catnip.math.VecHelper;
import net.flomik.delightfulcreators.config.DCServerConfig;
import net.flomik.delightfulcreators.recipe.CuttingProcessingRecipe;
import net.flomik.delightfulcreators.recipe.DCRecipeTypes;
import net.flomik.delightfulcreators.recipe.KnifeCuttingRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

/**
 * Runs every Farmer's Delight cutting board recipe whose tool matches a knife (the "knife_dig"
 * subset of Farmer's Delight's own cutting recipes) found on items passing on a belt/depot, dropped
 * in the world above this block, or (if enabled via config, on by default) sitting in a Basin two
 * blocks below it - reusing Create's Mechanical Press animation, belt processing behaviour and
 * basin-operating machinery. Axe/shovel cutting-board recipes (log stripping, digging) are left to
 * the tools they actually require. Also recognises "delightfulcreators:cutting_processing" recipes
 * (see CuttingProcessingRecipe) so the Cutter can be used as a step inside a Create Sequenced
 * Assembly chain, the same way the real Mechanical Press does via PressingRecipe.
 */
public class MechanicalCutterBlockEntity extends BasinOperatingBlockEntity implements PressingBehaviourSpecifics {

    private static final Object cuttingRecipesKey = new Object();
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

    // --- Basin processing (config-gated, mirrors Create's Mechanical Press) ---

    @Override
    public boolean tryProcessInBasin(boolean simulate) {
        applyBasinRecipe();

        Optional<BasinBlockEntity> basin = getBasin();
        if (basin.isPresent()) {
            SmartInventory inputs = basin.get()
                    .getInputInventory();
            for (int slot = 0; slot < inputs.getSlots(); slot++) {
                ItemStack stackInSlot = inputs.getItem(slot);
                if (stackInSlot.isEmpty())
                    continue;
                pressingBehaviour.particleItems.add(stackInSlot);
            }
        }

        return true;
    }

    @Override
    protected void applyBasinRecipe() {
        // Reimplemented rather than relying on the generic BasinRecipe.apply() path used by the
        // parent class: that path falls back to Recipe#getResultItem() for non-ProcessingRecipe
        // types, which would silently drop the chance-rolled secondary results that
        // CuttingBoardRecipe supports. rollRecipeResults() below already handles those correctly
        // for the belt/world paths, so basin mode reuses the same logic.
        if (!(currentRecipe instanceof CuttingBoardRecipe recipe))
            return;

        Optional<BasinBlockEntity> optionalBasin = getBasin();
        if (optionalBasin.isEmpty())
            return;
        BasinBlockEntity basin = optionalBasin.get();

        IItemHandler items = basin.getCapability(ForgeCapabilities.ITEM_HANDLER)
                .orElse(null);
        if (items == null)
            return;

        for (int slot = 0; slot < items.getSlots(); slot++) {
            ItemStack extracted = items.extractItem(slot, 1, true);
            if (extracted.isEmpty() || !recipe.getIngredients()
                    .get(0)
                    .test(extracted))
                continue;

            items.extractItem(slot, 1, false);
            List<ItemStack> outputs = rollRecipeResults(recipe, 1);
            basin.acceptOutputs(outputs, Collections.emptyList(), false);
            basin.notifyChangeOfContents();
            break;
        }
    }

    @Override
    protected boolean isRunning() {
        return pressingBehaviour.running;
    }

    @Override
    protected void onBasinRemoved() {
        pressingBehaviour.particleItems.clear();
        pressingBehaviour.running = false;
        pressingBehaviour.runningTicks = 0;
        sendData();
    }

    @Override
    public void startProcessingBasin() {
        if (pressingBehaviour.running && pressingBehaviour.runningTicks <= PressingBehaviour.CYCLE / 2)
            return;
        super.startProcessingBasin();
        pressingBehaviour.start(Mode.BASIN);
    }

    @Override
    protected <C extends Container> boolean matchStaticFilters(Recipe<C> recipe) {
        if (!DCServerConfig.SERVER.mechanicalCutterBasinProcessing.get())
            return false;
        return recipe.getType() == ModRecipeTypes.CUTTING.get() && recipe instanceof CuttingBoardRecipe cuttingRecipe
                && KnifeCuttingRecipes.isKnifeRecipe(cuttingRecipe);
    }

    @Override
    protected Object getRecipeCacheKey() {
        return cuttingRecipesKey;
    }

    // --- Belt / world processing ---

    @Override
    public boolean tryProcessInWorld(ItemEntity itemEntity, boolean simulate) {
        ItemStack item = itemEntity.getItem();

        Optional<CuttingProcessingRecipe> assemblyRecipe = SequencedAssemblyRecipe.getRecipe(level, item,
                DCRecipeTypes.CUTTING_PROCESSING.getType(), CuttingProcessingRecipe.class);
        if (assemblyRecipe.isPresent()) {
            if (simulate)
                return true;
            pressingBehaviour.particleItems.add(item);
            RecipeApplier.applyRecipeOn(itemEntity, assemblyRecipe.get(), true);
            return true;
        }

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
        Optional<CuttingProcessingRecipe> assemblyRecipe = SequencedAssemblyRecipe.getRecipe(level, input.stack,
                DCRecipeTypes.CUTTING_PROCESSING.getType(), CuttingProcessingRecipe.class);
        if (assemblyRecipe.isPresent()) {
            if (simulate)
                return true;
            pressingBehaviour.particleItems.add(input.stack);
            outputList.addAll(RecipeApplier.applyRecipeOn(level,
                    canProcessInBulk() ? input.stack : ItemHandlerHelper.copyStackWithSize(input.stack, 1),
                    assemblyRecipe.get(), true));
            return true;
        }

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
        if (pressingBehaviour.onBasin() && matchBasinRecipe(currentRecipe)
                && getBasin().filter(BasinBlockEntity::canContinueProcessing)
                        .isPresent())
            startProcessingBasin();
        else
            basinChecker.scheduleUpdate();
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

        Optional<CuttingBoardRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.CUTTING.get(), CUTTING_INV, level)
                .filter(KnifeCuttingRecipes::isKnifeRecipe);
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
