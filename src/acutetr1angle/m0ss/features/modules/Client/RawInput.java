package acutetr1angle.m0ss.features.modules.Client;


import acutetr1angle.m0ss.features.modules.Module;
import acutetr1angle.m0ss.utils.RawMouseHelper;
import lombok.Getter;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Mouse;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

import java.lang.reflect.Constructor;

@Getter
public class RawInput extends Module {
    public static int dx = 0;
    public static int dy = 0;
    public static Mouse mouse;
    public RawInput() {
        super("RawInput", Category.MISC);
    }
    private static ControllerEnvironment createDefaultEnvironment() throws ReflectiveOperationException {
        Constructor<ControllerEnvironment> constructor = (Constructor<ControllerEnvironment>) Class.forName("net.java.games.input.DefaultControllerEnvironment").getDeclaredConstructors()[0];
        constructor.setAccessible(true);
        return constructor.newInstance();
    }
    @Override
    public void onEnable() {
        mc.mouseHelper = new RawMouseHelper();
        Thread inputThread = new Thread(() -> {
            while (true) {
                if (mouse == null) {
                    try {
                        Controller[] controllers;
                        controllers = createDefaultEnvironment().getControllers();
                        for (int i = 0; i < controllers.length; i++) {
                            if (controllers[i].getType() == Controller.Type.MOUSE) {
                                controllers[i].poll();
                                if (((Mouse)controllers[i]).getX().getPollData() != 0.0 || ((Mouse)controllers[i]).getY().getPollData() != 0.0) {
                                    mouse = (Mouse)controllers[i];
                                    Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Found mouse"));
                                }
                            }
                        }
                    } catch (ReflectiveOperationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    mouse.poll();

                    dx += (int)mouse.getX().getPollData();
                    dy += (int)mouse.getY().getPollData();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        inputThread.setName("inputThread");
        inputThread.start();
    }
}

