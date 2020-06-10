package ru.volnenko.se.event;

public class CommandEvent {
    private final String command;

    public CommandEvent(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
