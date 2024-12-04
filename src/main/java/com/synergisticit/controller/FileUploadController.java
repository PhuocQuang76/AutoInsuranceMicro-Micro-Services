package com.synergisticit.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/uploadFile")
    public String handleFileUpload(@RequestBody byte[] fileBytes) {
        try {
            // Save the file to disk or process it as needed
            FileOutputStream stream = new FileOutputStream("path/to/save/file");
            stream.write(fileBytes);
            stream.close();
            return "File uploaded and saved successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file and save";
        }
    }
}