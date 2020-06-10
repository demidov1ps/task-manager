package ru.volnenko.se.command.data.json;

import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.constant.DataConstant;

import java.io.File;
import java.nio.file.Files;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataJsonClearCommand implements ICommand {

    @Override
    public String command() {
        return "data-json-clear";
    }

    @Override
    public String description() {
        return "Remove JSON file.";
    }

    @Async
    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_JSON);
        Files.deleteIfExists(file.toPath());
    }

}
