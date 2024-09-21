package cn.acutetr1angle.m0ss.features.command.commands;

import cn.acutetr1angle.m0ss.Client;
import cn.acutetr1angle.m0ss.features.command.Command;
import cn.acutetr1angle.m0ss.features.modules.Module;

public class ToggleCommand extends Command {
    public ToggleCommand() {
        super("toggle");
    }
    @Override
    public void run(String[] args) {
        if (args.length == 0) {
            //报错
            return;
        }
        String name = args[0];
        for (Module modules : Client.instance.moduleManager.getModules()) {
            if (modules.name.equalsIgnoreCase(name)) {
                modules.toggle();
            }
        }
    }
}
