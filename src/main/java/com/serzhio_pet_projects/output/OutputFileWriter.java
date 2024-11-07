package com.serzhio_pet_projects.output;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class OutputFileWriter {

    private final String filePath;

    public OutputFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeCompressedTextToFile(String text) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(text);
        }
    }

    public static String createPathToOutputFile(String pathToInputFile, String modeOperation) {
        StringBuilder pathToOutputFile = new StringBuilder();
        pathToOutputFile.append(pathToInputFile, 0, pathToInputFile.lastIndexOf("."));
        if ("c_mode".equals(modeOperation) ) {
            pathToOutputFile.append("_compressed");
        } else {
            pathToOutputFile.append("_uncompressed");
        }
        pathToOutputFile.append(".txt");
        return pathToOutputFile.toString();
    }
}
