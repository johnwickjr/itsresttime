package com.example.itsresttime.controller;

import com.example.itsresttime.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;


    @PostMapping("/file-upload")
    public ResponseEntity<?> fileUpload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println(file.getOriginalFilename());
        fileUploadService.fileUpload(file);
        return ResponseEntity.ok().build();
    }
}
