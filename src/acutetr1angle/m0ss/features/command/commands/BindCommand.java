package acutetr1angle.m0ss.features.command.commands;

import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.features.command.Command;
import acutetr1angle.m0ss.features.modules.Module;
import acutetr1angle.m0ss.utils.ChatUtil;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class BindCommand extends Command {
    public BindCommand() {
        super("bind");
    }
    @Override
    public void run(String[] args) {
        if (args.length == 2) {
            Module module = Client.instance.getModuleManager().getModule(args[0]);
            if (module != null) {
                if (args[1].toUpperCase().startsWith("MOUSE")) {
                    int key = Mouse.getButtonIndex(args[1].toUpperCase().replace("MOUSE", "BUTTON"));
                    module.setMouseKey(key);
                    ChatUtil.sendMessage(EnumChatFormatting.GREEN + "Success bound " + module.getName() + " to " + Mouse.getButtonName(module.getMouseKey()) + "!");

                } else {
                    int key = Keyboard.getKeyIndex(args[1].toUpperCase());
                    module.setKey(key);
                    ChatUtil.sendMessage(EnumChatFormatting.GREEN + "Success bound " + module.getName() + " to " + Keyboard.getKeyName(module.getKey()) + "!");
                }
            }
        }
    }
}
