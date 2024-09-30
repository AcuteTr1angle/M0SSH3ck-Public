package acutetr1angle.m0ss.event.events;

import acutetr1angle.m0ss.event.impl.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotionUpdateEvent implements Event {
    private double x,y,z;
    private float yaw,pitch;
    private boolean onGround;
    private boolean modifield;

    public MotionUpdateEvent(double x, double y, double z,float yaw, float pitch, boolean onGround) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
    }
    public void setYaw(float yaw) {
        this.yaw = yaw;
        this.modifield = true;
    }
}
