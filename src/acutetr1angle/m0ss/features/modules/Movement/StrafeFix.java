package acutetr1angle.m0ss.features.modules.Movement;

import acutetr1angle.m0ss.event.annotations.EventPriority;
import acutetr1angle.m0ss.event.annotations.EventTarget;
import acutetr1angle.m0ss.event.events.JumpEvent;
import acutetr1angle.m0ss.event.events.MotionUpdateEvent;
import acutetr1angle.m0ss.event.events.MovementInputEvent;
import acutetr1angle.m0ss.event.events.StrafeEvent;

import acutetr1angle.m0ss.features.modules.Module;
import net.minecraft.util.MathHelper;

public class StrafeFix extends Module {
    private float[] angle;
    private boolean needUpdate;

    public StrafeFix() {
        super("StrafeFix", Category.MOVEMENT);
    }

    public void setAngle(float[] angle) {
        this.angle = angle;
        this.needUpdate = true;
    }
    @EventTarget
    public void onMovementInput(MovementInputEvent event) {
        if (angle == null || !needUpdate) return;
        final float forward = event.getForward();
        final float strafe = event.getStrafe();

        final double yaw = MathHelper.wrapAngleTo180_double(Math.toDegrees(direction(mc.thePlayer.rotationYaw, forward, strafe)));

        if (forward == 0 && strafe == 0) {
            return;
        }

        float closestForward = 0, closestStrafe = 0, closestDifference = Float.MAX_VALUE;

        for (float predictedForward = -1F; predictedForward <= 1F; predictedForward += 1F) {
            for (float predictedStrafe = -1F; predictedStrafe <= 1F; predictedStrafe += 1F) {
                if (predictedStrafe == 0 && predictedForward == 0) continue;

                final double predictedAngle = MathHelper.wrapAngleTo180_double(Math.toDegrees(direction(angle[0], predictedForward, predictedStrafe)));
                final double difference = Math.abs(yaw - predictedAngle);

                if (difference < closestDifference) {
                    closestDifference = (float) difference;
                    closestForward = predictedForward;
                    closestStrafe = predictedStrafe;
                }
            }
        }

        event.setForward(closestForward);
        event.setStrafe(closestStrafe);
    }

    @EventTarget
    public void onUpdate(MotionUpdateEvent event) {
        if (needUpdate) {
            event.setYaw(angle[0]);
            event.setPitch(angle[1]);
            needUpdate = false;
        }
    }
    @EventTarget
    public void onStrafe(StrafeEvent event) {
        if (needUpdate) {
            event.setYaw(angle[0]);
        }
    }
    @EventTarget
    public void onJump(JumpEvent event) {
        if (needUpdate) {
            event.setYaw(angle[0]);
        }
    }
    private enum state{
        strict,
    }
    public double direction(float rotationYaw, final double moveForward, final double moveStrafing) {
        if (moveForward < 0F) rotationYaw += 180F;

        float forward = 1F;

        if (moveForward < 0F) forward = -0.5F;
        else if (moveForward > 0F) forward = 0.5F;

        if (moveStrafing > 0F) rotationYaw -= 90F * forward;
        if (moveStrafing < 0F) rotationYaw += 90F * forward;

        return Math.toRadians(rotationYaw);
    }
}
