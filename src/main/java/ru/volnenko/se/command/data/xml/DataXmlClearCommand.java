package ru.volnenko.se.command.data.xml;

import ru.volnenko.se.command.ICommand;
import ru.volnenko.se.constant.DataConstant;

import java.io.File;
import java.nio.file.Files;

import org.springframework.stereotype.Component;

/**
 * @author Denis Volnenko
 */
@Component
public final class DataXmlClearCommand implements ICommand {

    @Override
    public String command() {
        return "data-xml-clear";
    }

    @Override
    public String description() {
        return "Remove XML file.";
    }

    @Override
    public void execute() throws Exception {
        final File file = new File(DataConstant.FILE_XML);
        Files.deleteIfExists(file.toPath());
    }

}
