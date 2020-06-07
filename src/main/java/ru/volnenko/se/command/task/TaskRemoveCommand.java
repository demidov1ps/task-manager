package ru.volnenko.se.command.task;

import org.springframework.stereotype.Component;

import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.controller.ICommandReader;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskRemoveCommand implements ICommand {

    private final ICommandReader commandReader;

    public TaskRemoveCommand(ICommandReader commandReader) {
        this.commandReader = commandReader;
    }

    @Override
    public String command() {
        return "task-remove";
    }

    @Override
    public String description() {
        return "Remove selected task.";
    }

    @Override
    public void execute() {
        System.out.println("[REMOVING TASK]");
        System.out.println("Enter task order index:");
        final Integer orderIndex = commandReader.nextInteger();
        if (orderIndex == null) {
            System.out.println("Error! Incorrect order index...");
            System.out.println();
            return;
        }
        System.out.println("[OK]");
    }

}
