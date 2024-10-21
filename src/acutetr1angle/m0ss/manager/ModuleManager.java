package acutetr1angle.m0ss.manager;

import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.event.annotations.EventTarget;
import acutetr1angle.m0ss.event.events.EventKey;
import acutetr1angle.m0ss.features.modules.Client.*;
import acutetr1angle.m0ss.features.modules.Movement.*;
import acutetr1angle.m0ss.features.modules.Combat.*;
import acutetr1angle.m0ss.features.modules.Player.*;
import acutetr1angle.m0ss.features.modules.*;
import acutetr1angle.m0ss.features.modules.Render.*;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ModuleManager {
    private final Map<String, Module> moduleMap = new HashMap<>();
    public void init() {
        Client.instance.eventManager.register(this);
        add(new Sprint());
        add(new FullBright());
        add(new NoHurtCam());
        add(new StrafeFix());
        add(new KillAura());
        add(new RawInput()); //有神比问题不能使用
        add(new KeepSprint());
        add(new Fly());
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

    @EventTarget
    public void onKey(EventKey e) {
        moduleMap.values().stream()
                .filter(module -> module.getKey() == e.getKey() && e.getKey() != -1)
                .forEach(Module::toggle);
    }

    public Map<String, Module> getModuleMap() {
        return moduleMap;
    }
}
