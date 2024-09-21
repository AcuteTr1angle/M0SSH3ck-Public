package cn.acutetr1angle.m0ss.features.modules.Client;

import cn.acutetr1angle.m0ss.features.event.annotations.EventTarget;
import cn.acutetr1angle.m0ss.features.event.events.EventUpdate;
import cn.acutetr1angle.m0ss.features.modules.Module;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint",Category.Client);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        mc.thePlayer.setSprinting(true);
    }
}
