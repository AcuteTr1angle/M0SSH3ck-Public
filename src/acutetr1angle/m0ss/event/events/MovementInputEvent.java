package acutetr1angle.m0ss.event.events;

import acutetr1angle.m0ss.event.impl.Event;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovementInputEvent implements Event {
    private  float forward,strafe;

    public MovementInputEvent(float forward, float strafe) {
        this.forward = forward;
        this.strafe = strafe;
    }
}
