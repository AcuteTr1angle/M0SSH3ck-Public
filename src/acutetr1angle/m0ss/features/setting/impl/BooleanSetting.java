package acutetr1angle.m0ss.features.setting.impl;

import acutetr1angle.m0ss.features.setting.Setting;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooleanSetting extends Setting {
    private final boolean defaultValue;
    public boolean precondition;
    public BooleanSetting(String name,boolean defaultValue){
        super(name);
        this.defaultValue = defaultValue;
    }
    public BooleanSetting(String name,boolean defaultValue,boolean precondition){
        super(name);
        this.defaultValue = defaultValue;
        this.precondition = precondition;
    }
}
