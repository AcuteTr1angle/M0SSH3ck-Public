package acutetr1angle.m0ss.manager;

import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.features.modules.Player.Sprint;
import acutetr1angle.m0ss.features.modules.Module;
import acutetr1angle.m0ss.features.modules.Render.FullBright;
import acutetr1angle.m0ss.features.modules.Render.NoHurtCam;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final ArrayList<Module> modules = new ArrayList<>();


    public void init() {
        Client.instance.eventManager.register(this);
        add(new Sprint());
        add(new FullBright());
        add(new NoHurtCam());
    }

    public void add(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }
}
