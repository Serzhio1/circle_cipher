package com.serzhio_pet_projects.encoder;

public class RleEncoder {

    public static String encodeFullText(String text) {
        StringBuilder compressedText = new StringBuilder();
        String[] words = text.split(" ");
        for (String word: words) {
            String compressedWord = encodeWord(word);
            compressedText.append(compressedWord).append(" ");
        }
        compressedText.deleteCharAt(compressedText.length() - 1);
        return compressedText.toString();
    }

    public static String encodeWord(String word) {
        if (word.length()==1) {
            return word;
        } else {
            StringBuilder compressedWord = new StringBuilder();
            int countSameChars = 1;

            for (int i=0; i<(word.length()-1); i++) {
                if (i!=(word.length()-2)) {
                    if (word.charAt(i)==word.charAt(i+1)) {
                        countSameChars++;
                    } else {
                        if (countSameChars>1) {
                            compressedWord.append(countSameChars).append(word.charAt(i));
                        } else {
                            compressedWord.append(word.charAt(i));
                        } countSameChars = 1;
                    } 
                } else {
                    if (word.charAt(i)==word.charAt(i+1)) {
                        countSameChars++;
                        compressedWord.append(countSameChars).append(word.charAt(i));
                    } else {
                        if (countSameChars > 1) {
                            compressedWord.append(countSameChars).append(word.charAt(i));
                        } else {
                            compressedWord.append(word.charAt(i));
                        }
                        compressedWord.append(word.charAt(i+1));
                    }
                }
            } return compressedWord.toString();
        } 
    } 
}
