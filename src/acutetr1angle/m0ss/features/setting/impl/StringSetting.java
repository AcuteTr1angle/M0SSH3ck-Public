package acutetr1angle.m0ss.features.setting.impl;

import acutetr1angle.m0ss.features.setting.Setting;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringSetting extends Setting {
    private final String defaultValue;
    public boolean precondition;
    public StringSetting(String name, String defaultValue){
        this(name,defaultValue,true);
    }
    public StringSetting(String name, String defaultValue, boolean precondition){
        super(name);
        this.defaultValue = defaultValue;
        this.precondition = precondition;
    }
}
