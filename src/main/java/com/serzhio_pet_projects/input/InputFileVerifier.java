package com.serzhio_pet_projects.input;

import java.io.File;
import java.util.Objects;


public class InputFileVerifier {

    public static String checkPathToInputFile(String pathToInputFile) {
            if (checkFileExist(pathToInputFile)) {
                return pathToInputFile;
            } else {
                return null;
            }
    }

    private static boolean checkFileExist(String path) {
        if (Objects.isNull(path) || path.isEmpty()) {
            return false;
        } else {
            File file = new File(path);
            return file.isFile();
        }
    }
}
