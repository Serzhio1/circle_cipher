package com.serzhio_pet_projects.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class InputFileReader {
    private final String filePath;

    public InputFileReader(String filePath) {
        this.filePath = filePath;
    }

    public String readTextFromFile() throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line=bufferedReader.readLine()) != null) {
            result.append(line);
            result.append(" ");
        }
        if (!isFileTextEmpty(result)) {
            return result.toString();
        } else {
            return null;
        }
    }

    private static boolean isFileTextEmpty(StringBuilder text) {
        return text.isEmpty();
    }
}
