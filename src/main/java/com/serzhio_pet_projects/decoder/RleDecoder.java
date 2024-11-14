package com.serzhio_pet_projects.decoder;

public class RleDecoder {

    public static String decode(String encodeText) {

        if (encodeText.length()==1) {
            return encodeText;
        } else {
            String[] words = encodeText.split(" ");

            StringBuilder resultString = new StringBuilder();
            String suffix;
            boolean makeBigNumber = false;
            StringBuilder bigNumber = new StringBuilder();
             
            for (String word: words) {
                for (int i=0; i<word.length(); i++) {
                    char curСymbol = word.charAt(i);
                    if (Character.isDigit(curСymbol)) {
                        if (makeBigNumber) {
                            bigNumber.append(curСymbol);
                            if (!Character.isDigit(word.charAt(i+1))) {
                                int count_repeat = Integer.parseInt(bigNumber.toString());
                                suffix = String.valueOf(word.charAt(i+1)).repeat(count_repeat); 
                                resultString.append(suffix);
                                makeBigNumber = false;
                                i++;
                            }
                        } else {
                            if (Character.isDigit(word.charAt(i+1))) {
                                bigNumber.append(curСymbol);
                                makeBigNumber = true;
                            } else {
                                int count_repeat = Character.getNumericValue(curСymbol);
                                suffix = String.valueOf(word.charAt(i+1)).repeat(count_repeat); 
                                resultString.append(suffix);
                                i++;
                            }
                        }
                    } else {
                        resultString.append(curСymbol);
                    }
                }
                resultString.append(" ");
            }
            return resultString.toString().trim();
        }
    }
}
