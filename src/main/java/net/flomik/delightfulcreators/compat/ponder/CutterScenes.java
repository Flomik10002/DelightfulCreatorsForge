package net.flomik.delightfulcreators.compat.ponder;

import com.simibubi.create.content.kinetics.press.PressingBehaviour.Mode;
import com.simibubi.create.foundation.ponder.CreateSceneBuilder;
import com.simibubi.create.foundation.ponder.element.BeltItemElement;

import net.createmod.catnip.math.Pointing;
import net.createmod.ponder.api.element.ElementLink;
import net.createmod.ponder.api.element.WorldSectionElement;
import net.createmod.ponder.api.scene.SceneBuilder;
import net.createmod.ponder.api.scene.SceneBuildingUtil;
import net.createmod.ponder.api.scene.Selection;

import net.flomik.delightfulcreators.block.ModBlocks;
import net.flomik.delightfulcreators.block.cutter.MechanicalCutterBlockEntity;
import net.flomik.delightfulcreators.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

/**
 * Reuses the layout of Create's own "mechanical_press/pressing" schematic (belts, depot, shaft
 * placement), but swaps the press block out for our actual Mechanical Cutter the moment it's
 * revealed, so the scene both looks like and truly is operating our block, not Create's Press.
 */
public class CutterScenes {

    public static void cutting(SceneBuilder builder, SceneBuildingUtil util) {
        CreateSceneBuilder scene = new CreateSceneBuilder(builder);
        scene.title("mechanical_cutter", "Cutting Items with the Mechanical Cutter");
        scene.configureBasePlate(0, 0, 5);
        scene.world().showSection(util.select().layer(0), Direction.UP);
        scene.idle(5);

        ElementLink<WorldSectionElement> depot =
                scene.world().showIndependentSection(util.select().position(2, 1, 1), Direction.DOWN);
        scene.world().moveSection(depot, util.vector().of(0, 0, 1), 0);
        scene.idle(10);

        Selection cutterS = util.select().position(2, 3, 2);
        BlockPos cutterPos = util.grid().at(2, 3, 2);
        BlockPos depotPos = util.grid().at(2, 1, 1);
        scene.world().modifyBlock(cutterPos, state -> ModBlocks.MECHANICAL_CUTTER.get()
                .defaultBlockState()
                .setValue(BlockStateProperties.HORIZONTAL_FACING, state.getValue(BlockStateProperties.HORIZONTAL_FACING)),
                false);
        scene.world().setKineticSpeed(cutterS, 0);
        scene.world().showSection(cutterS, Direction.DOWN);
        scene.idle(10);

        scene.world().showSection(util.select().fromTo(2, 1, 3, 2, 1, 5), Direction.NORTH);
        scene.idle(3);
        scene.world().showSection(util.select().position(2, 2, 3), Direction.SOUTH);
        scene.idle(3);
        scene.world().showSection(util.select().position(2, 3, 3), Direction.NORTH);
        scene.world().setKineticSpeed(cutterS, -32);
        scene.effects().indicateSuccess(cutterPos);
        scene.idle(10);

        Vec3 cutterSide = util.vector().blockSurface(cutterPos, Direction.WEST);
        scene.overlay().showText(60)
                .pointAt(cutterSide)
                .placeNearTarget()
                .attachKeyFrame()
                .text("The Mechanical Cutter can process cutting board recipes on items provided beneath it");
        scene.idle(70);
        scene.overlay().showText(60)
                .pointAt(cutterSide.subtract(0, 2, 0))
                .placeNearTarget()
                .text("The Input items can be dropped or placed on a Depot under the Cutter");
        scene.idle(50);
        ItemStack pumpkinPie = new ItemStack(Items.PUMPKIN_PIE);
        scene.world().createItemOnBeltLike(depotPos, Direction.NORTH, pumpkinPie);
        Vec3 depotCenter = util.vector().centerOf(depotPos.south());
        scene.overlay().showControls(depotCenter, Pointing.UP, 30).withItem(pumpkinPie);
        scene.idle(10);

        Class<MechanicalCutterBlockEntity> type = MechanicalCutterBlockEntity.class;
        scene.world().modifyBlockEntity(cutterPos, type, pte -> pte.getPressingBehaviour()
                .start(Mode.BELT));
        scene.idle(30);
        scene.world().modifyBlockEntity(cutterPos, type, pte -> pte.getPressingBehaviour()
                .makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), pumpkinPie));
        scene.world().removeItemsFromBelt(depotPos);
        ItemStack slice = new ItemStack(ModItems.PUMPKIN_PIE_SLICE.get(), 4);
        scene.world().createItemOnBeltLike(depotPos, Direction.UP, slice);
        scene.idle(10);
        scene.overlay().showControls(depotCenter, Pointing.UP, 50).withItem(slice);
        scene.idle(60);

        scene.world().hideIndependentSection(depot, Direction.NORTH);
        scene.idle(5);
        scene.world().showSection(util.select().fromTo(0, 1, 3, 0, 2, 3), Direction.DOWN);
        scene.idle(10);
        scene.world().showSection(util.select().fromTo(4, 1, 2, 0, 2, 2), Direction.SOUTH);
        scene.idle(20);
        BlockPos beltPos = util.grid().at(0, 1, 2);
        scene.overlay().showText(40)
                .pointAt(util.vector().blockSurface(beltPos, Direction.WEST))
                .placeNearTarget()
                .attachKeyFrame()
                .text("When items are provided on a belt...");
        scene.idle(30);

        ElementLink<BeltItemElement> pie = scene.world().createItemOnBelt(beltPos, Direction.SOUTH, pumpkinPie);
        scene.idle(15);
        ElementLink<BeltItemElement> pie2 = scene.world().createItemOnBelt(beltPos, Direction.SOUTH, pumpkinPie);
        scene.idle(15);
        scene.world().stallBeltItem(pie, true);
        scene.world().modifyBlockEntity(cutterPos, type, pte -> pte.getPressingBehaviour()
                .start(Mode.BELT));

        scene.overlay().showText(50)
                .pointAt(cutterSide)
                .placeNearTarget()
                .attachKeyFrame()
                .text("The Cutter will hold and process them automatically");

        scene.idle(30);
        scene.world().modifyBlockEntity(cutterPos, type, pte -> pte.getPressingBehaviour()
                .makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), pumpkinPie));
        scene.world().removeItemsFromBelt(cutterPos.below(2));
        pie = scene.world().createItemOnBelt(cutterPos.below(2), Direction.UP, slice);
        scene.world().stallBeltItem(pie, true);
        scene.idle(15);
        scene.world().stallBeltItem(pie, false);
        scene.idle(15);
        scene.world().stallBeltItem(pie2, true);
        scene.world().modifyBlockEntity(cutterPos, type, pte -> pte.getPressingBehaviour()
                .start(Mode.BELT));
        scene.idle(30);
        scene.world().modifyBlockEntity(cutterPos, type, pte -> pte.getPressingBehaviour()
                .makePressingParticleEffect(depotCenter.add(0, 8 / 16f, 0), pumpkinPie));
        scene.world().removeItemsFromBelt(cutterPos.below(2));
        pie2 = scene.world().createItemOnBelt(cutterPos.below(2), Direction.UP, slice);
        scene.world().stallBeltItem(pie2, true);
        scene.idle(15);
        scene.world().stallBeltItem(pie2, false);
    }

}
