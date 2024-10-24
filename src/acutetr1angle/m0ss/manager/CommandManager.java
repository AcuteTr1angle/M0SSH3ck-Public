package acutetr1angle.m0ss.manager;

import acutetr1angle.m0ss.Client;
import acutetr1angle.m0ss.features.command.Command;
import acutetr1angle.m0ss.features.command.commands.BindCommand;
import acutetr1angle.m0ss.features.command.commands.ToggleCommand;

import java.util.ArrayList;

public class CommandManager {
    private final ArrayList<Command> commands = new ArrayList<>();

    public void init() {
        Client.instance.eventManager.register(this);
        add(new ToggleCommand());
        add(new BindCommand());
    }

    public void add(Command command) {
        commands.add(command);
    }

    public Command getCommand(String name) {
        for (Command command : commands) {
            for (String string : command.getName()) {
                if (string.equals(name)) {
                    return command;
                }
            }
        }
        return null;
    }
}
