package acutetr1angle.m0ss.features.modules;


import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.utils.ChatUtil;
import acutetr1angle.m0ss.utils.Wrapper;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.util.EnumChatFormatting;

@Getter
@Setter
public class Module implements Wrapper {

    public String name;
    public String description;
    public boolean state;
    public static int categoryCount;
    public static float allowedClickGuiHeight = 300;
    private String author = "";
    private boolean expanded;
    public Category category;


    public Module(String name,Category category){
        this.name = name;
        this.description = "";
        this.category = category;
        this.state = false;
    }

    public Module(String name, String description, Category category){
        this.name = name;
        this.description = description;
        this.category = category;
        this.state = false;
    }

    public boolean isOn(){
        return this.state;
    }

    public void enable() {
        onEnable();
        Client.instance.eventManager.register(this);
        this.state = true;
        ChatUtil.sendMessage(this.name + EnumChatFormatting.GREEN + " enabled");
    }
    public void disable() {
        onDisable();
        Client.instance.eventManager.unregister(this);
        this.state = false;
        ChatUtil.sendMessage(this.name + EnumChatFormatting.RED +" disabled");
    }


    public void toggle() {
        if (state) {
            disable();
        } else {
            enable();
        }
    }

    public boolean nullcheck() {
        return mc.thePlayer == null || mc.theWorld == null;
    }


    public void onUpdate() {

    }
    
    
    public void onEnable() {

    }
    
    
    public void onDisable() {

    }
    
    
    public void onRender3D() {
        
    }
    
    
    public void onRender2D() {
        
    }
    public enum Category{
        PLAYER,
        CLIENT,
        RENDER,
        COMBAT,
        MOVEMENT,
        MISC
    }

}
