package com.serzhio_pet_projects.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class InputFileReader {
    private final String filePath;

    public InputFileReader(String filePath) {
        this.filePath = filePath;
    }

    public String readTextFromFile() throws FileNotFoundException, IOException {
        StringBuilder result = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while((line=bufferedReader.readLine()) != null) {
                result.append(line);
                result.append(" ");
                
            return result.toString();
            }
        }
        return filePath;
    }

    public static String getPathToInputFile(Scanner scanner) {
            System.out.print("Введите абсолютный путь к файлу: ");
            String pathToInputFile = scanner.nextLine();

            return pathToInputFile;
    }

    public static boolean checkFileExist(String pathString) {
        Path path = Paths.get(pathString);
        if (Files.exists(path)) {
            return true;
        } else {
            System.out.println("По указанному пути не было найдено файла");
            return false;
        }
    }
}
