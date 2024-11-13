package com.serzhio_pet_projects.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class InputFileReader {

    public static String readTextFromFile(String filePath) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line=bufferedReader.readLine()) != null) {
                result.append(line);
                result.append(" ");
            }
        }
        if (!isFileTextEmpty(result)) {
            return result.toString().replaceFirst("\\$$", "");
        } else {
            return null;
        }
    }

    private static boolean isFileTextEmpty(StringBuilder text) {
        return text.isEmpty();
    }
}
