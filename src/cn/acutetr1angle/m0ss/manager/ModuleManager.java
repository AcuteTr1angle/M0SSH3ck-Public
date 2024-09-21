package cn.acutetr1angle.m0ss.manager;

import cn.acutetr1angle.m0ss.Client;
import cn.acutetr1angle.m0ss.features.modules.Player.Sprint;
import cn.acutetr1angle.m0ss.features.modules.Module;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    private final ArrayList<Module> modules = new ArrayList<>();


    public void init() {
        Client.instance.eventManager.register(this);
        add(new Sprint());
    }

    public void add(Module module) {
        modules.add(module);
    }

    public List<Module> getModules() {
        return modules;
    }
}
