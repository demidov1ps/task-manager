package ru.volnenko.se.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.event.CommandEvent;

@Component
public class CommandExecutor {
    private final Map<String, ICommand> commands;

    public CommandExecutor(List<ICommand> commandsList) {
        this.commands = commandsList.stream().collect(Collectors.toMap(ICommand::command, bean->bean));
    }

    @EventListener(CommandEvent.class)
    public void ExecuteCommand(CommandEvent event) throws Exception {
        ICommand commandBean = commands.get(event.getCommand());
        if (commandBean != null) {
            commandBean.execute();
        }
    }
}
