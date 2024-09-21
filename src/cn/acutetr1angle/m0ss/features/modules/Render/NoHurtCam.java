package cn.acutetr1angle.m0ss.features.modules.Render;

import cn.acutetr1angle.m0ss.features.modules.Module;

public class NoHurtCam extends Module {
    public static boolean isEnable;
    public NoHurtCam() {
        super("NoHurtCam",Category.Render);
    }
    @Override
    public void onEnable() {
        isEnable = true;
    }
    @Override
    public void onDisable() {
        isEnable = false;
    }
}
