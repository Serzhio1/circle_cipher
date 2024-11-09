package com.serzhio_pet_projects.analyzer;

import java.io.File;
import java.io.IOException;

import static com.serzhio_pet_projects.tools.MathUtils.roundAvoid;

public class FileMetaData {

    public static void printCompressedInfo(String uncompressedFilePath, String compressedFilePath) throws IOException {
        long sizeUncompressedFile = getFileSize(uncompressedFilePath);
        long sizeCompressedFile = getFileSize(compressedFilePath);
        double сompressionEfficiencyForSize = getCompressionEfficiencyForSize(sizeUncompressedFile, sizeCompressedFile);

        System.out.println("Размер файла до сжатия: " + sizeUncompressedFile +  " байт");
        System.out.println("Размер файла после сжатия: " + sizeCompressedFile +  " байт");
        System.out.println("Файл был сжат на " + сompressionEfficiencyForSize + " %");
    }

    private static long getFileSize(String filePath){
        File file = new File(filePath);
        long fileSize = file.length();
        return fileSize;
    } 

    private static double getCompressionEfficiencyForSize(long sizeUncompressedFile, long sizeCompressedFile) {
        double result =  100 - ((double) sizeCompressedFile / sizeUncompressedFile) * 100;
        return roundAvoid(result, 2);
    }
}
