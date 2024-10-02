package acutetr1angle.m0ss.event.events;

import acutetr1angle.m0ss.event.impl.CancellableEvent;
import lombok.Getter;

@Getter
public class EventKey extends CancellableEvent {
    private int key;

    public EventKey(int key) {
        this.key = key;
    }
}
