package ru.volnenko.se.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.error.CommandAbsentException;
import ru.volnenko.se.error.CommandCorruptException;

/**
 * @author Denis Volnenko
 */
@Component
public final class Bootstrap {

    private final ICommandReader commandReader;
    private final Map<String, ICommand> commands = new LinkedHashMap<>();

    public Bootstrap(ICommandReader commandReader, List<ICommand> commandsList) {
        this.commandReader = commandReader;
        if (commandsList.isEmpty()) {
            throw new CommandAbsentException();
        }
        for (ICommand command : commandsList) {
            String cliCommand = command.command();
            String cliDescription = command.description();
            if (cliCommand == null || cliCommand.isEmpty()) {
                throw new CommandCorruptException();
            }
            if (cliDescription == null || cliDescription.isEmpty()) {
                throw new CommandCorruptException();
            }
            commands.put(cliCommand, command);
        }
    }

    public void start() throws Exception {
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String command = "";
        while (!"exit".equals(command)) {
            command = commandReader.nextLine();
            execute(command);
        }
    }

    private void execute(final String command) throws Exception {
        if (command == null || command.isEmpty()) return;
        final ICommand abstractCommand = commands.get(command);
        if (abstractCommand == null) return;
        abstractCommand.execute();
    }
}
