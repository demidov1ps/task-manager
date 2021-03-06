package ru.volnenko.se.command.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ru.volnenko.se.api.repository.ITaskRepository;
import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.entity.Task;

/**
 * @author Denis Volnenko
 */
@Component
public final class TaskListCommand implements ICommand {

    private final ITaskRepository taskRepository;

    public TaskListCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public String command() {
        return "task-list";
    }

    @Override
    public String description() {
        return "Show all tasks.";
    }

    @Async
    @Override
    public void execute() {
        System.out.println("[TASK LIST]");
        int index = 1;
        for (Task task: taskRepository.getListTask()) {
            System.out.println(index + ". " + task.getName());
            index++;
        }
        System.out.println();
    }

}
