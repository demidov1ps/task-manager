package ru.volnenko.se.command.data.bin;

import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.constant.DataConstant;

import java.io.File;
import java.nio.file.Files;

import org.springframework.stereotype.Component;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataBinaryClearCommand implements ICommand {

    @Override
    public String command() {
        return "data-bin-clear";
    }

    @Override
    public String description() {
        return "Remove binary data.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_BINARY);
        Files.deleteIfExists(file.toPath());
    }

}
