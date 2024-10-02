package acutetr1angle.m0ss.utils;

import acutetr1angle.m0ss.features.modules.Client.RawInput;
import net.minecraft.util.MouseHelper;

public class RawMouseHelper extends MouseHelper {

    @Override
    public void mouseXYChange()
    {
        this.deltaX = RawInput.dx;
        RawInput.dx = 0;
        this.deltaY = -RawInput.dy;
        RawInput.dy = 0;
    }
}
