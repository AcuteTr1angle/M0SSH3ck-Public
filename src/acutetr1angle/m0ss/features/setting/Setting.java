package acutetr1angle.m0ss.features.setting;

import java.util.function.BooleanSupplier;

public class Setting{
    private final String name;
    public final BooleanSupplier precondition;

    public Setting(String name) {
        this.name = name;
        this.precondition = null;
    }

    public Setting(String name, BooleanSupplier precondition) {
        this.name = name;
        this.precondition = precondition;
    }
}
