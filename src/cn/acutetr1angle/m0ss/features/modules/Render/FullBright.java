package cn.acutetr1angle.m0ss.features.modules.Render;

import cn.acutetr1angle.m0ss.features.modules.Module;
import net.minecraft.client.settings.GameSettings;

public class FullBright extends Module {
    public FullBright() {
        super("FullBright",Category.Render);
    }
    @Override
    public void onEnable() {
        mc.gameSettings.saturation = 15;
    }
    @Override
    public void onDisable() {
        mc.gameSettings.saturation = 1;
    }
}
