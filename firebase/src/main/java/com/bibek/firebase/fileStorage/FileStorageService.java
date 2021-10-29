package com.bibek.firebase.fileStorage;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 8:07 AM
 **/
@Service
public class FileStorageService {

    private Path rootLocation;

    public FileStorageService(StorageProperties storageProperties) {
        this.rootLocation = Paths.get(storageProperties.getLocation());
    }

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not initialize storage subjectLocation", e);
        }
    }

    public String store(MultipartFile file, String filepath) {

        UUID uuid = UUID.randomUUID();
        String filename = String.valueOf(new StringBuilder()
                .append(uuid)
                .append(".")
                .append(FilenameUtils.getExtension(file.getOriginalFilename())));

        StringBuilder dynamicFilePath = new StringBuilder();
        dynamicFilePath.append("/")
                .append(filepath)
                .append("/");

        Path baseFilePath = null;
        File fileDir = new File(this.rootLocation + File.separator.concat(String.valueOf(dynamicFilePath)));

        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        baseFilePath = Paths.get(fileDir.getPath());
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("cannot store" + filename);
            }
            if (filename.contains("..")) {
                throw new RuntimeException("cannot store" + filename);

            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, baseFilePath.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to store file " + filename, e);
        }

        return fileDir.getPath().concat("/").concat(filename);


    }


}
