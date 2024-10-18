package acutetr1angle.m0ss.features.modules.Render;


import acutetr1angle.m0ss.features.modules.Module;

public class NoHurtCam extends Module {
    public static boolean isEnable;
    public NoHurtCam() {
        super("NoHurtCam", Category.RENDER);
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
