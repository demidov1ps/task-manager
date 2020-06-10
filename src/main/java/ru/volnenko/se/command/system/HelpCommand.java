package ru.volnenko.se.command.system;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.ICommand;

/**
 * @author Denis Volnenko
 */
@Component
public final class HelpCommand implements ICommand {

    private final AbstractApplicationContext context;

    public HelpCommand(AbstractApplicationContext context) {
        this.context = context;
    }

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String description() {
        return "Show all commands.";
    }

    @Async
    @Override
    public void execute() {
        context.getBeansOfType(ICommand.class).values().forEach(
                command -> System.out.println(command.command()+ ": " + command.description()));
    }

}
