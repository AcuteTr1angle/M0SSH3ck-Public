package cn.acutetr1angle.m0ss.utils;

import net.minecraft.util.ChatComponentText;

public class ChatUtil implements Wrapper{
    public static void sendMessage(String string) {
        mc.thePlayer.addChatMessage(new ChatComponentText(string));
    }
}
