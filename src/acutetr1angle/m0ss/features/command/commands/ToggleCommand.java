package acutetr1angle.m0ss.features.command.commands;

import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.features.command.Command;
import acutetr1angle.m0ss.features.modules.Module;
import acutetr1angle.m0ss.utils.ChatUtil;
import net.minecraft.util.EnumChatFormatting;

public class ToggleCommand extends Command {
    public ToggleCommand() {
        super("toggle","t");
    }
    @Override
    public void run(String[] args) {
        if (args.length == 0) {
            ChatUtil.sendMessage(EnumChatFormatting.RED + "Please enter the module name");
            return;
        }
        String name = args[0];
        Module module = Client.instance.getModuleManager().getModule(name);
        if (module != null) {
            module.toggle();
        } else {
            ChatUtil.sendMessage(EnumChatFormatting.RED + "Module not found!");
        }
    }
}
