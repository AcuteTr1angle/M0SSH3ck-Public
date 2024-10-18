package acutetr1angle.m0ss.features.modules.Movement;

import acutetr1angle.m0ss.event.annotations.EventTarget;
import acutetr1angle.m0ss.event.events.BlockAABBEvent;

import acutetr1angle.m0ss.features.modules.Module;
import net.minecraft.util.AxisAlignedBB;

public class Fly extends Module {
    public Fly() {
        super("Fly", Category.MOVEMENT);
    }
    @EventTarget
    public void onBlockAABB(BlockAABBEvent event) {
        final double x = event.getBlockPos().getX(), y = event.getBlockPos().getY(), z = event.getBlockPos().getZ();
        if (y < mc.thePlayer.posY) {
            event.setBoundingBox(AxisAlignedBB.fromBounds(-15, -1, -15, 15, 1, 15).offset(x, y, z));
        }
    }
}
