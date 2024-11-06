package com.serzhio_pet_projects.decoder;

public class RleDecoder {

    public static String decode(String encodeText) {

        if (encodeText.length()==1) {
            return encodeText;
        } else {
            StringBuilder resultString = new StringBuilder();
            String suffix;
    
            String[] words = encodeText.split(" ");
            for (String word: words) {
                for (int i=0; i<word.length(); i++) {
                    char cur_cymbol = word.charAt(i);
                    if (Character.isDigit(cur_cymbol)) {
                        int count_repeat = Character.getNumericValue(cur_cymbol);
                        suffix = String.valueOf(word.charAt(i+1)).repeat(count_repeat); 
                        resultString.append(suffix);
                        i++;
                    } else {
                        resultString.append(cur_cymbol);
                    }
                }
                resultString.append(" ");
            }
            return resultString.toString().trim();
        }
    }
}
