package ru.volnenko.se.command.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.command.ICommand;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskClearCommand implements ICommand {

    private final ITaskRepository taskRepository;

    public TaskClearCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public String description() {
        return "Remove all tasks.";
    }

    @Override
    public String command() {
        return "task-clear";
    }

    @Async
    @Override
    public void execute() {
        taskRepository.clear();
        System.out.println("[ALL TASK REMOVED]");
    }

}
