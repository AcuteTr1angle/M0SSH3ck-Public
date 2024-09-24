package acutetr1angle.m0ss.features.modules.Player;

import acutetr1angle.m0ss.event.annotations.EventTarget;
import acutetr1angle.m0ss.event.events.EventUpdate;
import acutetr1angle.m0ss.features.modules.Module;
import acutetr1angle.m0ss.features.setting.Setting;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint",Category.Player);
    }

    public Setting<Boolean> legit = new Setting<>("legit",true);

    @EventTarget
    public void onUpdate(EventUpdate e) {
        mc.thePlayer.setSprinting(true);
    }
}
