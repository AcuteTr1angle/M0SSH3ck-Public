package acutetr1angle.m0ss;

import acutetr1angle.m0ss.manager.CommandManager;
import acutetr1angle.m0ss.manager.EventManager;
import acutetr1angle.m0ss.manager.ModuleManager;
import acutetr1angle.m0ss.viamcp.viamcp.ViaMCP;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;
@Getter
public class Client {
    public static final String NAME = "M0SSh3ck";
    public static final String VERISON = "0.0.1-Public";
    public static Minecraft mc = Minecraft.getMinecraft();
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
        try {
            ViaMCP.create();

            // In case you want a version slider like in the Minecraft options, you can use this code here, please choose one of those:

            ViaMCP.INSTANCE.initAsyncSlider(); // For top left aligned slider
        } catch (Exception e) {
            e.printStackTrace();
        }
        Display.setTitle("Welcome " + Minecraft.getMinecraft().getSession().getUsername() + "\u0020\u007c\u0020\u4f60\u6b63\u5728\u4f7f\u7528\u004d\u0030\u0053\u0053\u0048\u0033\u0063\u006b");
    }

    public void shutdown() {

    }


}
