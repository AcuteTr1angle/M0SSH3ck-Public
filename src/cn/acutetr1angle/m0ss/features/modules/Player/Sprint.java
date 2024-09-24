package cn.acutetr1angle.m0ss.features.modules.Player;

import cn.acutetr1angle.m0ss.features.event.annotations.EventTarget;
import cn.acutetr1angle.m0ss.features.event.events.EventUpdate;
import cn.acutetr1angle.m0ss.features.modules.Module;
import cn.acutetr1angle.m0ss.features.setting.Setting;

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
