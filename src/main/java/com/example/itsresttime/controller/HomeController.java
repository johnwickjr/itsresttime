package com.example.itsresttime.controller;

import com.example.itsresttime.models.Student;
import com.example.itsresttime.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private Service service;

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("name", "email");
    }

    @GetMapping("/token/{name}/{email}")
    public Map<String, String> getToken(@PathVariable("name") String name, @PathVariable("email") String email) {
        String generatedToken = service.generateToken(name, email);
        Map<String, String> map = new HashMap<>();
        map.put("token", generatedToken);
        return map;
    }

    @GetMapping("/current-token")
    public String currentToken() {
        return service.lookupToken();
    }
}
