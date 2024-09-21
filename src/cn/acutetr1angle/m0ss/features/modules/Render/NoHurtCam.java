package cn.acutetr1angle.m0ss.features.modules.Render;

import cn.acutetr1angle.m0ss.features.modules.Module;

public class NoHurtCam extends Module {
    public static NoHurtCam INSTANCE;
    public NoHurtCam() {
        super("NoHurtCam",Category.Render);
        INSTANCE = this;
    }
}
