package com.serzhio_pet_projects.tools;

public class MathUtils {
    public static double roundAvoid(double number, int places) {
        double scale = Math.pow(10, places);
        return Math.round(number * scale) / scale;
    }
}
