package com.example;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Main{

    public static void main(String[] args) {
        BritishTimeConverter converter = new BritishTimeConverter();

        // Test cases
        System.out.println(converter.convert("12:00")); // noon
        System.out.println(converter.convert("00:00")); // midnight
        System.out.println(converter.convert("1:00"));  // one o'clock
        System.out.println(converter.convert("7:30"));  // half past seven
        System.out.println(converter.convert("8:40"));  // twenty to nine
        System.out.println(converter.convert("3:15"));  // quarter past three
        System.out.println(converter.convert("9:45"));  // quarter to ten
    }
}
