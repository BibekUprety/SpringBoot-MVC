package com.example.demo;

import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.model.File;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;

/**
 * @author bibek
 * @project google
 * @project 05/10/2021 - 6:24 AM
 **/
@Service
public class FileManager {

    private GoogleDriveManager googleDriveManager;

    public FileManager(GoogleDriveManager googleDriveManager) {
        this.googleDriveManager = googleDriveManager;
    }

    public String uploadFile(MultipartFile file, String filePath) {
        try {
            if (null != file) {
                File fileMetadata = new File();
//                fileMetadata.setParents(Collections.singletonList());
                fileMetadata.setName(file.getOriginalFilename());
                File uploadFile = googleDriveManager.getInstance()
                        .files()
                        .create(fileMetadata, new InputStreamContent(
                                        file.getContentType(),
                                        new ByteArrayInputStream(file.getBytes())
                                )
                        )
                        .setFields("id").execute();
                return uploadFile.getId();

            }

        } catch (Exception e) {
            System.out.println("Error");
        }
        return null;
    }

}
