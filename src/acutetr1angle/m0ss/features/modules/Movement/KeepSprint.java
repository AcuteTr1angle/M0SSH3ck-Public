package acutetr1angle.m0ss.features.modules.Movement;

import acutetr1angle.m0ss.event.annotations.EventTarget;
import acutetr1angle.m0ss.event.events.SprintEvent;
import acutetr1angle.m0ss.features.modules.Module;

public class KeepSprint extends Module {
    public KeepSprint() {
        super("KeepSprint","Springing when attack entities",Category.Movement);
    }
    @EventTarget
    public void onSprint(SprintEvent event) {
        event.setCancelled(true);
    }
}
