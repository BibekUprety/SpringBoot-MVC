package com.bibek.firebase.fileStorage;

import com.bibek.firebase.reop.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 8:07 AM
 **/
@Service
@RequiredArgsConstructor
public class FileStorageService {

    private final ResourceLoader resourceLoader;
    private final ProductRepo productRepo;

    @SneakyThrows
    public byte[] getEncodedByteString(String filePath) {
        Path path = Paths.get(filePath);
        byte[] data = Files.readAllBytes(path);
        return Base64.getDecoder().decode(data);
    }

    @SneakyThrows
    public String getEncodedByteStringFromFile(MultipartFile file) {
        byte[] data = file.getBytes();
        return Base64.getEncoder().encodeToString(data);
    }


//    public Resource loadAsResource() {
//        Resource resource =  resourceLoader.getResource("classpath:serviceAccountKey.json");
//        System.out.println(resource.isFile());
//        productRepo.findByImage(7);
//        Base64.getDecoder().
//        return resource;
//
//    }

}




















//
//
//    public String store(MultipartFile file, String filepath) {
//
//        UUID uuid = UUID.randomUUID();
//        String filename = String.valueOf(new StringBuilder()
//                .append(uuid)
//                .append(".")
//                .append(FilenameUtils.getExtension(file.getOriginalFilename())));
//
//        StringBuilder dynamicFilePath = new StringBuilder();
//        dynamicFilePath.append("/")
//                .append(filepath)
//                .append("/");
//
//        Path baseFilePath = null;
//        File fileDir = new File(this.rootLocation + File.separator.concat(String.valueOf(dynamicFilePath)));
//
//        if (!fileDir.exists()) {
//            fileDir.mkdir();
//        }
//        baseFilePath = Paths.get(fileDir.getPath());
//        try {
//            if (file.isEmpty()) {
//                throw new RuntimeException("cannot store" + filename);
//            }
//            if (filename.contains("..")) {
//                throw new RuntimeException("cannot store" + filename);
//
//            }
//            try (InputStream inputStream = file.getInputStream()) {
//                Files.copy(inputStream, baseFilePath.resolve(filename),
//                        StandardCopyOption.REPLACE_EXISTING);
//            }
//        } catch (IOException e) {
//            throw new IllegalArgumentException("Failed to store file " + filename, e);
//        }
//
//        return fileDir.getPath().concat("/").concat(filename);
//
//
//    }
//


