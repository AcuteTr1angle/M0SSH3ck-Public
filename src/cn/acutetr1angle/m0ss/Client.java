package cn.acutetr1angle.m0ss;

import cn.acutetr1angle.m0ss.manager.CommandManager;
import cn.acutetr1angle.m0ss.manager.EventManager;
import cn.acutetr1angle.m0ss.manager.ModuleManager;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class Client {
    public static final String NAME = "M0SSH3ck";
    public static final String VERISON = "0.0.1";

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

        Display.setTitle("Welcome " + Minecraft.getMinecraft().getSession().getUsername() + " | 你正在使用M0SSH3ck");
    }

    public void shutdown() {

    }


}
