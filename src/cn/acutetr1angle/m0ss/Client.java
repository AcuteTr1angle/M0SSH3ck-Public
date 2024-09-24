package cn.acutetr1angle.m0ss;

import cn.acutetr1angle.m0ss.manager.CommandManager;
import cn.acutetr1angle.m0ss.manager.EventManager;
import cn.acutetr1angle.m0ss.manager.ModuleManager;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class Client {
    public static final String NAME = "M0SSH3ck";
    public static final String VERISON = "0.0.2";

    public static Client instance;
    public EventManager eventManager;
    public ModuleManager moduleManager;
    public CommandManager commandManager;

    public void init() {
        instance = this;
        eventManager = new EventManager();
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();


        eventManager.register(this);
        moduleManager.init();
        commandManager.init();

        Display.setTitle("Welcome " + Minecraft.getMinecraft().getSession().getUsername() + "\u0020\u007c\u0020\u4f60\u6b63\u5728\u4f7f\u7528\u004d\u0030\u0053\u0053\u0048\u0033\u0063\u006b");
    }

    public void shutdown() {

    }


}
