package acutetr1angle.m0ss.event.events;

import acutetr1angle.m0ss.event.impl.CancellableEvent;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.Packet;

@Getter
@Setter
public class PacketEvent extends CancellableEvent {
    public Packet<?> packet;
    public PacketEvent(Packet<?> packet) {
        this.packet = packet;
    }
    public static class Send extends PacketEvent {
        public Send(Packet<?> packet) {
            super(packet);
        }
    }

    public static class Receive extends PacketEvent {
        public Receive(Packet<?> packet) {
            super(packet);
        }
    }
}
