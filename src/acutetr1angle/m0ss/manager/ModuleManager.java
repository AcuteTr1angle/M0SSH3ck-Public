package acutetr1angle.m0ss.manager;

import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.features.modules.Combat.KillAura;
import acutetr1angle.m0ss.features.modules.Misc.AutoBMW;
import acutetr1angle.m0ss.features.modules.Movement.StrafeFix;
import acutetr1angle.m0ss.features.modules.Player.Sprint;
import acutetr1angle.m0ss.features.modules.Module;
import acutetr1angle.m0ss.features.modules.Render.FullBright;
import acutetr1angle.m0ss.features.modules.Render.NoHurtCam;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
public class ModuleManager {
    private final Map<String, Module> moduleMap = new HashMap<>();
    public void init() {
        Client.instance.eventManager.register(this);
        add(new Sprint());
        add(new FullBright());
        add(new NoHurtCam());
        add(new AutoBMW());
        add(new StrafeFix());
        add(new KillAura());
    }

    public void add(Module module) {
        moduleMap.put(module.name,module);
    }

    public Module getModule(String name) {
        for (Module module : moduleMap.values()) {
            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }
        return null;
    }

    public Map<String, Module> getModuleMap() {
        return moduleMap;
    }
}
