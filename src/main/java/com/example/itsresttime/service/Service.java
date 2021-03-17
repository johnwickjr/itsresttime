package com.example.itsresttime.service;

import com.example.itsresttime.util.JWT;
import com.example.itsresttime.util.StoringToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
    @Autowired
    private StoringToken storingToken;
    @Autowired
    private JWT jwt;


    public String generateToken(String name, String email) {
        String token = jwt.getToken(name, email);
        storingToken.setToken(token);
        return token;
    }

    public Boolean validateToken(String token) {
        return token.equals(storingToken.getToken());
    }

    public String lookupToken() {
        return storingToken.getToken();
    }
}
