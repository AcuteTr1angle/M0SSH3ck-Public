package acutetr1angle.m0ss.features.modules.Player;

import acutetr1angle.m0ss.event.annotations.EventTarget;
import acutetr1angle.m0ss.event.events.PlayerUpdateEvent;
import acutetr1angle.m0ss.features.modules.Module;
import acutetr1angle.m0ss.features.setting.impl.BooleanSetting;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint",Category.Player);
    }

   public BooleanSetting legit = new BooleanSetting("legit",true);

    @EventTarget
    public void onUpdate(PlayerUpdateEvent event) {
        if(legit.getValue)mc.gameSettings.keyBindInventory.pressed = true;
    }
}
