package acutetr1angle.m0ss.features.setting;

public class Setting<T>{

    public final String Name;
    public final T defaultValue;
    public T Value;
    private T Min;
    private T Max;

    public Setting(String name, T defaultValue) {
        this.Name = name;
        this.defaultValue = defaultValue;
        this.Value = defaultValue;
        this.Min = defaultValue;
        this.Max = defaultValue;
    }
    public Setting(String name, T defaultValue,T Value,T Min,T Max) {
        this.Name = name;
        this.defaultValue = defaultValue;
        this.Value = Value;
        this.Min = Min;
        this.Max = Max;
    }

    public T getMax() {
        return Max;
    }

    public T getMin() {
        return Min;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

    public T getValue() {
        return Value;
    }

    public String getName() {
        return Name;
    }

}
