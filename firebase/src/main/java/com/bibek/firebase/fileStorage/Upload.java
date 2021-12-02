//package com.bibek.firebase.fileStorage;
//
//import com.google.api.services.storage.Storage;
//import com.google.cloud.storage.Blob;
//import com.google.cloud.storage.BlobId;
//import com.google.cloud.storage.BlobInfo;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
///**
// * @author bibek
// * @project firebase
// * @project 29/10/2021 - 3:54 PM
// **/
//public class Upload {
//
//
//    public String[] uploadFile(MultipartFile multipartFile) throws IOException {
//        File file = convertMultiPartToFile(multipartFile);
//        Path filePath = file.toPath();
//        String objectName = generateFileName(multipartFile);
//
//        Storage storage = storageOptions.getService();
//
//        BlobId blobId = BlobId.of(bucketName, objectName);
//        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
//        Blob blob = storage.create(blobInfo, Files.readAllBytes(filePath));
//
////        log.info("File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);
//        return new String[]{"fileUrl", objectName};
//    } @Override
//    public ResponseEntity<Object> downloadFile(String fileName, HttpServletRequest request) throws Exception {
//        Storage storage = storageOptions.getService();
//
//        Blob blob = storage.get(BlobId.of(bucketName, fileName));
//        ReadChannel reader = blob.reader();
//        InputStream inputStream = Channels.newInputStream(reader);
//
//        byte[] content = null;
//        log.info("File downloaded successfully.");
//
//        content = IOUtils.toByteArray(inputStream);
//
//        final ByteArrayResource byteArrayResource = new ByteArrayResource(content);
//
//        return ResponseEntity
//                .ok()
//                .contentLength(content.length)
//                .header("Content-type", "application/octet-stream")
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
//                .body(byteArrayResource);
//
//    }
//
//}
