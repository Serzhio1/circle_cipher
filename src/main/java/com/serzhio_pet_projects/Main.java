package com.serzhio_pet_projects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.serzhio_pet_projects.encoder.RleEncoder;
import com.serzhio_pet_projects.input.InputFileReader;
import com.serzhio_pet_projects.output.OutputFileWriter;


public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);

        String pathToInputFile = InputFileReader.getPathToInputFile(scanner);
        String pathToOutputFile = OutputFileWriter.createPathToOutputFile(pathToInputFile);
        
        OutputFileWriter outputFileWriter = new OutputFileWriter(pathToOutputFile);

        if (InputFileReader.checkFileExist(pathToInputFile)) {

            InputFileReader inputFileReader = new InputFileReader(pathToInputFile);
            String inputData = inputFileReader.readTextFromFile();

            String compressedText = RleEncoder.encode(inputData);

            outputFileWriter.writeCompressedTextToFile(compressedText);
            System.out.println("Сжатый текст находится в новом файле, по пути: " + pathToOutputFile);
        } else {
            System.out.println("Проверьте, правильно ли вы указали путь до входного файла");
        }
    }
}