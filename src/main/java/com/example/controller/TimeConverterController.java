package com.example.controller;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.TimeConverterService;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/BritishTimeConverter")
public class TimeConverterController {

    @Autowired
    private TimeConverterService timeConverterService;

    @GetMapping("/")
    public String welcomeMessage(){
        return "Welcome to British TimeConverter website";
    }

    @GetMapping("/{time}")
    public String getTimeInBritishWay(@PathVariable
                                          @Length(min = 4, max = 5)
                                          @DateTimeFormat(pattern = "H:mm")
                                      LocalTime time){
        return timeConverterService.convert(time.toString());
    }
}
