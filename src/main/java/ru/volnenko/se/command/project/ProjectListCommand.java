package ru.volnenko.se.command.project;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import ru.volnenko.se.api.service.IProjectService;
import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.entity.Project;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectListCommand implements ICommand {

    private final IProjectService projectService;

    public ProjectListCommand(IProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "Show all projects.";
    }

    @Async
    @Override
    public void execute() {
        System.out.println("[PROJECT LIST]");
        int index = 1;
        for (Project project: projectService.getListProject()) {
            System.out.println(index++ + ". " + project.getName());
        }
        System.out.println();
    }

}
