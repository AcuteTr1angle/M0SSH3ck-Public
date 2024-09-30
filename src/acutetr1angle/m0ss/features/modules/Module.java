package acutetr1angle.m0ss.features.modules;


import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.utils.ChatUtil;
import acutetr1angle.m0ss.utils.Wrapper;
import lombok.Getter;
import net.minecraft.util.EnumChatFormatting;
@Getter
public class Module implements Wrapper {

    public String name;
    public String introduce;
    public Category category;
    public boolean state;


    public Module(String name,Category category){
        this.name = name;
        this.introduce = "";
        this.category = category;
        this.state = false;
    }

    public Module(String name,String introduce,Category category){
        this.name = name;
        this.introduce = introduce;
        this.category = category;
        this.state = false;
    }

    public boolean inOn(){
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

    public enum Category {
        Combat,
        Misc,
        Movement,
        Render,
        Player,
        Exploit,
        Client
    }

}
