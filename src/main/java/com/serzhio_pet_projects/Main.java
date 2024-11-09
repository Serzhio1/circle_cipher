package com.serzhio_pet_projects;

import java.io.IOException;
import java.util.Scanner;

import static com.serzhio_pet_projects.analyzer.FileMetaData.printCompressedInfo;
import com.serzhio_pet_projects.decoder.RleDecoder;
import com.serzhio_pet_projects.encoder.RleEncoder;
import static com.serzhio_pet_projects.input.InputFileReader.readTextFromFile;
import static com.serzhio_pet_projects.input.InputFileVerifier.checkPathToInputFile;
import com.serzhio_pet_projects.output.OutputFileWriter;
import static com.serzhio_pet_projects.output.OutputFileWriter.createPathToOutputFile;

public class Main {

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите абсолютный путь к файлу: ");
            String pathToInputFile = scanner.nextLine();
            String resultData = new String();

            while (checkPathToInputFile(pathToInputFile) == null) {
                System.out.print("Путь до входного файла указан неверно. Повторите попытку: ");
                pathToInputFile = scanner.nextLine();
            }

            String inputData = readTextFromFile(pathToInputFile);

            if (inputData == null) {
                System.out.println("В файле не оказалось никакой информации");
                return;
            }
            
            System.out.print("Выберете операцию: «c_mode» - сжатие данных, «d_mode» - восстановление данных: ");
            String modeOperation = scanner.nextLine();

            while (!modeOperation.equals("c_mode") & !modeOperation.equals("d_mode")) {
                System.out.print("Такой операции нет. Выберете: «c_mode» - сжатие данных, «d_mode» - восстановление данных: ");
                modeOperation = scanner.nextLine();
            }

            String pathToOutputFile = createPathToOutputFile(pathToInputFile, modeOperation);
            OutputFileWriter outputFileWriter = new OutputFileWriter(pathToOutputFile);

            switch (modeOperation) {
                case "c_mode" -> {
                    resultData = RleEncoder.encode(inputData); 
                    printCompressedInfo(pathToInputFile, pathToOutputFile);
                }
                case "d_mode" -> resultData = RleDecoder.decode(inputData);
            }

            outputFileWriter.writeResultDataToFile(resultData);
            System.out.println("Результат находится в новом файле, по пути: " + pathToOutputFile);
        }
    }
}
