package acutetr1angle.m0ss.features.modules.Combat;

import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.event.annotations.EventTarget;
import acutetr1angle.m0ss.event.events.MotionUpdateEvent;
import acutetr1angle.m0ss.event.events.PlayerUpdateEvent;

import acutetr1angle.m0ss.features.modules.Module;
import acutetr1angle.m0ss.features.modules.Movement.StrafeFix;
import acutetr1angle.m0ss.utils.Timer;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

public class KillAura extends Module {
    public KillAura() {
        super("KillAura","Test", Category.COMBAT);
    }
    private float[] angle;
    private final Timer attackTimer = new Timer();
    @EventTarget
    public void onMotion(MotionUpdateEvent event) {
        if (!Client.instance.getModuleManager().getModule("StrafeFix").isOn()) {
            if (angle != null) {
                event.setYaw(angle[0]);
                event.setPitch(angle[1]);
                angle = null;
            }
        }
    }

    @EventTarget
    public void onMotion(PlayerUpdateEvent event) {
        if (nullcheck()) {
            return;
        }
        EntityLivingBase target = null;
        for (Entity entity : mc.theWorld.loadedEntityList) {
            if (entity instanceof EntityLivingBase && mc.thePlayer.getDistanceToEntity(entity) < 3 && entity != mc.thePlayer) {
                target = (EntityLivingBase) entity;
                break;
            }
        }
        if (target == null) {
            return;
        }

        StrafeFix strafeFix = (StrafeFix) Client.instance.getModuleManager().getModule("StrafeFix");
        strafeFix.setAngle(angle = getAngles(target));

        if (attackTimer.passedMs(700L / 20)) {
            mc.playerController.attackEntity(mc.thePlayer, target);
            mc.thePlayer.swingItem();
            attackTimer.reset();
        }
    }
    public static float[] getAngles(Entity entity) {
        if (entity == null)
            return null;
        final EntityPlayerSP thePlayer = mc.thePlayer;

        final double diffX = entity.posX - thePlayer.posX,
                diffY = entity.posY + entity.getEyeHeight() * 0.9 - (thePlayer.posY + thePlayer.getEyeHeight()),
                diffZ = entity.posZ - thePlayer.posZ, dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ); // @on

        final float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F,
                pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / Math.PI);
        return new float[]{thePlayer.rotationYaw + MathHelper.wrapDegrees(yaw - thePlayer.rotationYaw), thePlayer.rotationPitch + MathHelper.wrapDegrees(pitch - thePlayer.rotationPitch)};
    }
}
