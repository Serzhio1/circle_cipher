package com.serzhio_pet_projects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.serzhio_pet_projects.encoder.RleEncoder;
import com.serzhio_pet_projects.input.InputFileReader;
import static com.serzhio_pet_projects.input.InputFileVerifier.checkPathToInputFile;
import com.serzhio_pet_projects.output.OutputFileWriter;
import static com.serzhio_pet_projects.output.OutputFileWriter.createPathToOutputFile;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите абсолютный путь к файлу: ");
        String pathToInputFile = scanner.nextLine();
        
        if (checkPathToInputFile(pathToInputFile)!=null) {

            String pathToOutputFile = createPathToOutputFile(pathToInputFile);
            OutputFileWriter outputFileWriter = new OutputFileWriter(pathToOutputFile);

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