package com.example.itsresttime.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class generateToken {

    public String getToken(String name, String email) {
        int ran = new Random().nextInt(100);
        return name + "@" + ran + email;
    }
}
