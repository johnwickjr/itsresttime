package com.example.itsresttime.controller;

import com.example.itsresttime.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/student")
    public Student getStudent(){
        return new Student("name","email");
    }
}
