package com.db.efolder.service;

import com.db.efolder.domain.DocServiceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class EDocService {
    private static final String UPLOADED_FOLDER = System.getProperty("java.io.dir");
    public DocServiceResponse uploadTMSheet(MultipartFile file,String docinfo) {
        DocServiceResponse response = new DocServiceResponse();
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            response.setCode("200");
            response.setCode("File uploaded successfully");
        }catch (IOException e){
            e.printStackTrace();
            response.setCode("500");
            response.setMessage("Exception occurred during upload");
        }
        return response;
    }
}
