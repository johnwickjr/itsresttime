package com.example.itsresttime.controller;

import com.example.itsresttime.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AfterAccessController {

    @Autowired
    private Service service;

    @GetMapping("/get-data")
    public String getMyData(@RequestHeader("token") String token) {
        System.out.println(token);
        if (service.validateToken(token)) {
            return "user is authenticated";
        }
        return "invalid user";
    }

}
