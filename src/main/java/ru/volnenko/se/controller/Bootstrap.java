package ru.volnenko.se.controller;

import java.util.Map;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.error.CommandAbsentException;
import ru.volnenko.se.error.CommandCorruptException;
import ru.volnenko.se.event.CommandEvent;

/**
 * @author Denis Volnenko
 */
@Component
public final class Bootstrap {

    private final ICommandReader commandReader;
    private final AbstractApplicationContext context;

    public Bootstrap(ICommandReader commandReader, AbstractApplicationContext context) {
        this.commandReader = commandReader;
        this.context = context;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void validateCommands() {
        Map<String, ICommand> commands = context.getBeansOfType(ICommand.class);
        if (commands.isEmpty()) {
            throw new CommandAbsentException();
        }
        for (ICommand command : commands.values()) {
            String cliCommand = command.command();
            String cliDescription = command.description();
            if (cliCommand == null || cliCommand.isEmpty()) {
                throw new CommandCorruptException();
            }
            if (cliDescription == null || cliDescription.isEmpty()) {
                throw new CommandCorruptException();
            }
        }
    }

    public void start() throws Exception {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            command = commandReader.nextLine();
            context.publishEvent(new CommandEvent(command));
        }
    }
}
