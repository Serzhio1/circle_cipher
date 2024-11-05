package com.serzhio_pet_projects.input;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class InputFileVerifier {

    public static String checkPathToInputFile(String pathToInputFile) {
            if (checkFileExist(pathToInputFile)) {
                return pathToInputFile;
            } else {
                return null;
            }
    }

    private static boolean checkFileExist(String pathString) {
        Path path = Paths.get(pathString);
        return Files.exists(path);
    }
}
