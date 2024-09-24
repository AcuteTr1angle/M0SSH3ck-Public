package acutetr1angle.m0ss.features.command;

public abstract class Command {
    private String[] name;

    public Command(String... name) {
        this.name = name;
    }

    public String[] getName() {
        return name;
    }
    public abstract void run(String[] args);
}
