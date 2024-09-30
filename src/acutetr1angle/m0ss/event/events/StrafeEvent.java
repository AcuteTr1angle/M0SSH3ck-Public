package acutetr1angle.m0ss.event.events;

import acutetr1angle.m0ss.event.impl.CancellableEvent;
import acutetr1angle.m0ss.event.impl.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StrafeEvent extends CancellableEvent {
    public float strafe;
    public float forward;
    public float friction;
    public float yaw;

    public StrafeEvent(float strafe, float forward, float friction, float yaw) {
        this.strafe = strafe;
        this.forward = forward;
        this.friction = friction;
        this.yaw = yaw;
    }
}
