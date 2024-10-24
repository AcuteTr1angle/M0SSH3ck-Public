package acutetr1angle.m0ss.features.setting.impl;

import acutetr1angle.m0ss.features.setting.Setting;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnumSetting<T extends Enum<T>> extends Setting {
    private final T defaultValue;
    public boolean precondition;
    private T value;
    public EnumSetting(String name, T defaultValue) {
        super(name);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }
}
