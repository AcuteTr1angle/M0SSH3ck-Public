package acutetr1angle.m0ss.features.setting.impl;

import acutetr1angle.m0ss.features.setting.Setting;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeySetting extends Setting {
    private final int keyBind,defaultKey;
    public boolean precondition;
    public KeySetting(String name, int keyBind, int defaultKey){
        this(name,keyBind, defaultKey,true);
    }
    public KeySetting(String name, int keyBind, int defaultKey, boolean precondition){
        super(name);
        this.keyBind = keyBind;
        this.defaultKey = defaultKey;
        this.precondition = precondition;
    }
}
