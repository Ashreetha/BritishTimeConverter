package com.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BritishTimeConverter {

    private static final String[] HOURS = {
            "twelve", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve", "one"
    };

    public String convert(String input) {
        LocalTime time = LocalTime.parse(input, DateTimeFormatter.ofPattern("H:mm"));
        int hour = time.getHour();
        int minute = time.getMinute();

        // Special cases
        if (hour == 0 && minute == 0) return "midnight";
        if (hour == 12 && minute == 0) return "noon";

        if (minute == 0) return HOURS[hour % 12] + " o'clock";
        if (minute == 15) return "quarter past " + HOURS[hour % 12];
        if (minute == 30) return "half past " + HOURS[hour % 12];
        if (minute == 45) return "quarter to " + HOURS[(hour + 1) % 12];

        if (minute < 30) {
            return toWords(minute) + " past " + HOURS[hour % 12];
        } else {
            return toWords(60 - minute) + " to " + HOURS[(hour + 1) % 12];
        }
    }

    private String toWords(int number) {
        String[] nums = {
                "", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
                "nineteen", "twenty"
        };

        if (number <= 20) return nums[number];
        return "twenty-" + nums[number - 20];
    }
}