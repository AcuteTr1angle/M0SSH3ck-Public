package net.minecraft.util;

import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.event.events.MovementInputEvent;
import net.minecraft.client.settings.GameSettings;

public class MovementInputFromOptions extends MovementInput
{
    private final GameSettings gameSettings;

    public MovementInputFromOptions(GameSettings gameSettingsIn)
    {
        this.gameSettings = gameSettingsIn;
    }

    public void updatePlayerMoveState()
    {
        this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;

        if (this.gameSettings.keyBindLeft.isKeyDown())
        {
            ++this.moveForward;
        }

        if (this.gameSettings.keyBindRight.isKeyDown())
        {
            --this.moveForward;
        }

        if (this.gameSettings.keyBindBack.isKeyDown())
        {
            ++this.moveStrafe;
        }

        if (this.gameSettings.keyBindJump.isKeyDown())
        {
            --this.moveStrafe;
        }

        this.jump = this.gameSettings.keyBindSneak.isKeyDown();
        this.sneak = this.gameSettings.keyBindSprint.isKeyDown();

        MovementInputEvent event = new MovementInputEvent(moveForward,moveStrafe);
        Client.instance.getEventManager().call(event);
        moveForward = event.getForward();
        moveStrafe = event.getStrafe();

        if (this.sneak)
        {
            this.moveStrafe = (float)((double)this.moveStrafe * 0.3D);
            this.moveForward = (float)((double)this.moveForward * 0.3D);
        }
    }
}
