package ru.volnenko.se.command.task;

import org.springframework.stereotype.Component;

import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.controller.ICommandReader;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskCreateCommand implements ICommand {

    private final ICommandReader commandReader;
    private final ITaskRepository taskRepository;

    public TaskCreateCommand(ICommandReader commandReader, ITaskRepository taskRepository) {
        this.commandReader = commandReader;
        this.taskRepository = taskRepository;
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "Create new task.";
    }

    @Override
    public void execute() {
        System.out.println("[TASK CREATE]");
        System.out.println("ENTER NAME:");
        final String name = commandReader.nextLine();
        taskRepository.createTask(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
