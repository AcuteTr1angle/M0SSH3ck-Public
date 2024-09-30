/*
 * Decompiled with CFR 0_132.
 */
package acutetr1angle.m0ss.event.events;


import acutetr1angle.m0ss.event.impl.CancellableEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JumpEvent extends CancellableEvent {
    public float motion;
    public float yaw;

    public JumpEvent(float yaw, float motion) {
        this.yaw = yaw;
        this.motion = motion;
    }

}

