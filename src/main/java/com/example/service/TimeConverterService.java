package com.example.service;
import com.example.exception.custom.InvalidInputDataException;
import org.springframework.stereotype.Service;

import static com.example.utility.TimeConverterUtility.getHoursInWords;
import static com.example.utility.TimeConverterUtility.getMinutesInWords;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class TimeConverterService{

    public String convert(String input) {
        LocalTime time;
        try {
            time = LocalTime.parse(input, DateTimeFormatter.ofPattern("H:mm"));
        } catch (DateTimeParseException e) {
            throw new InvalidInputDataException("Supplied time input is invaild. Please use 24 hour time pattern of HH:MM as input");
        }
        int hour = time.getHour();
        int minute = time.getMinute();

        // Special cases
        if (hour == 0 && minute == 0) return "midnight";
        if (hour == 12 && minute == 0) return "noon";

        if (minute == 0) return getHoursInWords(hour) + " o'clock";
        if (minute == 15) return "quarter past " + getHoursInWords(hour);
        if (minute == 30) return "half past " + getHoursInWords(hour);
        if (minute == 45) return "quarter to " +getHoursInWords(hour + 1);

        if (minute < 30) {
            return getMinutesInWords(minute) + " past " + getHoursInWords(hour);
        } else {
            return getMinutesInWords(60 - minute) + " to " +getHoursInWords(hour + 1);
        }
    }
}