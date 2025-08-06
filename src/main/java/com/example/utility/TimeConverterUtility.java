package com.example.utility;

public class TimeConverterUtility {
    public static final String[] HOURS = {
            "twelve", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven"
    };

    public static String[] MINUTES = {
                "", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty"
    };

    public static String getHoursInWords(int hour) {
        return HOURS[hour % 12];
    }

    public static String getMinutesInWords(int number) {
        if (number <= 20) return MINUTES[number];
        return "twenty-" + MINUTES[number - 20];
    }
}
