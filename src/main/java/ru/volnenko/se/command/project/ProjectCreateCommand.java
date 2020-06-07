package ru.volnenko.se.command.project;

import org.springframework.stereotype.Component;

import ru.volnenko.se.api.repository.IProjectRepository;
import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.controller.ICommandReader;

/**
 * @author Denis Volnenko
 */
@Component
public final class ProjectCreateCommand implements ICommand {

    private final ICommandReader commandReader;
    private final IProjectRepository projectRepository;

    public ProjectCreateCommand(ICommandReader commandReader, IProjectRepository projectRepository) {
        this.commandReader = commandReader;
        this.projectRepository = projectRepository;
    }

    @Override
    public String description() {
        return "Create new project.";
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public void execute() {
        System.out.println("[PROJECT CREATE]");
        System.out.println("ENTER NAME:");
        final String name = commandReader.nextLine();
        projectRepository.createProject(name);
        System.out.println("[OK]");
        System.out.println();
    }

}
