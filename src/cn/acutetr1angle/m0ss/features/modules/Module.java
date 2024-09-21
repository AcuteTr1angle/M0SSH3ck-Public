package cn.acutetr1angle.m0ss.features.modules;


public class Module {
    public String name;
    public String introduce;
    public Category category;
    public boolean state;
    public Module(String name,Category category){
        this.name = name;
        this.introduce = "none";
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
    public void Enable(){
        this.state = true;
    }
    public void Disable(){
        this.state = false;
    }
    public enum Category {Combat, Misc, Movement, Render, Player, Exploit, Client}
    public void onUpdate(){}
    public void onEnable(){}
    public void onDisable(){}
    public void onRender3D(){}
    public void onRender2D(){}
}
