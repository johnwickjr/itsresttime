package com.example.itsresttime.util;

import org.springframework.stereotype.Component;

@Component
public class StoringToken {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
