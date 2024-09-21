package cn.acutetr1angle.m0ss.features.event.events;

import cn.acutetr1angle.m0ss.features.event.impl.CancellableEvent;

public class EventKey extends CancellableEvent {
    private int key;

    public EventKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
