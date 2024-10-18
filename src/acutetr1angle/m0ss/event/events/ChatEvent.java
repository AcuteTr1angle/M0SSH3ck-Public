package acutetr1angle.m0ss.event.events;

import acutetr1angle.m0ss.event.impl.CancellableEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatEvent extends CancellableEvent {
    public String message;
    public ChatEvent(String message) {
        this.message = message;
    }
    public static class Send extends ChatEvent {
        public Send(String message) {
            super(message);
        }
    }
    public static class Receive extends ChatEvent {
        public Receive(String message) {
            super(message);
        }
    }
}
