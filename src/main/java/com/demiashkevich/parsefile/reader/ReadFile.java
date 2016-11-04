package com.demiashkevich.parsefile.reader;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

    private static final String PATH_TEXT = "data/information.txt";
    private static final Logger LOGGER = Logger.getLogger(ReadFile.class);

    public String readFile(){
        String result;
        try {
            result = new String(Files.readAllBytes(Paths.get(PATH_TEXT)), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            LOGGER.fatal(exception);
            throw new RuntimeException(exception);
        }
        return result;
    }

}
