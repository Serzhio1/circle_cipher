package com.serzhio_pet_projects.encoder;

public class RleEncoder {

    public static String encode(String text) {
        StringBuilder compressedText = new StringBuilder();
        String[] words = text.split(" ");
        for (String word: words) {
            String compressedWord = encodeWord(word);
            compressedText.append(compressedWord).append(" ");
        }
        compressedText.deleteCharAt(compressedText.length() - 1);
        return compressedText.toString();
    }

    private static String encodeWord(String word) {

        if (word.length()==1) {
            return word;

        } else {
            StringBuilder compressedWord = new StringBuilder();
            int countSameChars = 1;

            for (int i=0; i<=(word.length()-2); i++) {
                if (i!=(word.length()-2)) {
                    if (word.charAt(i)==word.charAt(i+1)) {
                        countSameChars++;
                    } else {
                        compressedWordAppendChars(compressedWord, countSameChars, word, i);
                        countSameChars = 1;
                    } 

                } else {
                    if (word.charAt(i)==word.charAt(i+1)) {
                        countSameChars++;
                        compressedWord.append(countSameChars).append(word.charAt(i));
                    } else {
                        compressedWordAppendChars(compressedWord, countSameChars, word, i);
                        compressedWord.append(word.charAt(i+1));
                    }
                }
            } return compressedWord.toString();
        } 
    } 

    private static void compressedWordAppendChars(StringBuilder compressedWord, int countSameChars, String word, int i) {
        if (countSameChars>1) {
            if (countSameChars==2) {
                compressedWord.append(word.charAt(i)).append(word.charAt(i));
            } else {
                compressedWord.append(countSameChars).append(word.charAt(i));
            }
        } else {
            compressedWord.append(word.charAt(i));
        } 
    }
}
