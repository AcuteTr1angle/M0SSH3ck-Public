package acutetr1angle.m0ss.features.modules.Render;

import acutetr1angle.m0ss.features.modules.Module;

public class FullBright extends Module {
    public FullBright() {
        super("FullBright", Category.RENDER);
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
