package com.example.itsresttime.service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadService {

    private String DIR = "D:\\images";

    public boolean fileUpload(MultipartFile multipartFile) {

        try {

            // sometimes create problem so, we use Nio here
//            InputStream inputStream = multipartFile.getInputStream();
//
//            byte[] bytes = new byte[inputStream.available()];
//
//            String DIR = "D:\\images";
//            FileOutputStream outputStream = new FileOutputStream(DIR + File.separator + multipartFile.getOriginalFilename());
//
//            outputStream.write(bytes);
//
//            outputStream.flush();
//            outputStream.close();

            //working one
            Files.copy(multipartFile.getInputStream(), Paths.get(DIR + File.separator + multipartFile.getOriginalFilename())
                    , StandardCopyOption.REPLACE_EXISTING);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
