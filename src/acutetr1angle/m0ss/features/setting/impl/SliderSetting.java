package acutetr1angle.m0ss.features.setting.impl;

import acutetr1angle.m0ss.features.setting.Setting;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SliderSetting extends Setting {
    private double value;
    private final double defaultValue,MintValue,MaxValue,increment;
    public boolean precondition;
    public SliderSetting(String name, double defaultValue, double mintValue, double maxValue, boolean precondition){
        this(name,defaultValue,mintValue,maxValue,0.1,precondition);
    }
    public SliderSetting(String name, double defaultValue, double mintValue, double maxValue,double increment, boolean precondition){
        super(name);
        this.value = defaultValue;
        this.defaultValue = defaultValue;
        this.MintValue = mintValue;
        this.MaxValue = maxValue;
        this.increment = increment;
        this.precondition = precondition;
    }
    public SliderSetting(String name, int defaultValue, int mintValue, int maxValue) {
        this(name, defaultValue, mintValue, maxValue,1.0,true);
    }
    public SliderSetting(String name, int defaultValue, int mintValue, int maxValue,boolean precondition) {
        this(name, defaultValue, mintValue, maxValue,1.0,precondition);
    }
}
