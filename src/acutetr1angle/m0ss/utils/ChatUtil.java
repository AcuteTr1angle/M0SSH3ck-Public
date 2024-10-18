package acutetr1angle.m0ss.utils;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class ChatUtil implements Wrapper{
    public static void sendMessage(String string) {
        mc.thePlayer.addChatMessage(new ChatComponentText("[" + EnumChatFormatting.AQUA + "M] " + EnumChatFormatting.WHITE + string));
    }
}
