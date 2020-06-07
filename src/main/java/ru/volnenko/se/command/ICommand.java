package ru.volnenko.se.command;

/**
 * @author Denis Volnenko
 */
public interface ICommand {

    public abstract void execute() throws Exception;

    public abstract String command();

    public abstract String description();

}
