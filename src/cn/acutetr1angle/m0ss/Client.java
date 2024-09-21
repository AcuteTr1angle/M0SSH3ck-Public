package cn.acutetr1angle.m0ss;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.Display;

public class Client {
    public static final String NAME = "M0SSH3ck";
    public static final String VERISON = "0.0.1";


    public static void start() {
        Display.setTitle("Welcome " + Minecraft.getMinecraft().getSession().getUsername() + " | 你正在使用M0SSH3ck");
    }

    public static void shutdown() {

    }


}
