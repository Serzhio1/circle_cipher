package com.serzhio_pet_projects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.serzhio_pet_projects.decoder.RleDecoder;
import com.serzhio_pet_projects.encoder.RleEncoder;
import com.serzhio_pet_projects.input.InputFileReader;
import static com.serzhio_pet_projects.input.InputFileVerifier.checkPathToInputFile;
import com.serzhio_pet_projects.output.OutputFileWriter;
import static com.serzhio_pet_projects.output.OutputFileWriter.createPathToOutputFile;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите абсолютный путь к файлу: ");
            String pathToInputFile = scanner.nextLine();
            System.out.print("Выберете операцию: «c_mode» - сжатие данных, «d_mode» - восстановление данных: ");
            String modeOperation = scanner.nextLine();
            
            if (checkPathToInputFile(pathToInputFile)!=null) {
                InputFileReader inputFileReader = new InputFileReader(pathToInputFile);
                String inputData = inputFileReader.readTextFromFile();

                String pathToOutputFile = createPathToOutputFile(pathToInputFile, modeOperation);
                OutputFileWriter outputFileWriter = new OutputFileWriter(pathToOutputFile);

                if (inputData!=null) {
                    if ("c_mode".equals(modeOperation)) {
                        String compressedText = RleEncoder.encode(inputData);
                        outputFileWriter.writeCompressedTextToFile(compressedText);
                        System.out.println("Сжатый текст находится в новом файле, по пути: " + pathToOutputFile);    
                    } else {
                        if ("d_mode".equals(modeOperation)) {
                            String uncompressedText = RleDecoder.decode(inputData);
                            outputFileWriter.writeCompressedTextToFile(uncompressedText);
                            System.out.println("Разжатый текст находится в новом файле, по пути: " + pathToOutputFile);    
                        } else {
                            System.out.println("Такой операции не сущетсвует, введите: «c_mode» или «d_mode»");
                        }
                    }
                } else {
                    System.out.println("В файле не оказалось никакой информации");
                }

            } else {
                System.out.println("Проверьте, правильно ли вы указали путь до входного файла");
            }
        }
    }
}