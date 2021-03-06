package ru.volnenko.se.command.project;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ru.volnenko.se.command.ICommand;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectRemoveCommand implements ICommand {

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "Remove selected project.";
    }

    @Async
    @Override
    public void execute() {

    }

}
