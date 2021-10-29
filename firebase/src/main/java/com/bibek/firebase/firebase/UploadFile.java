package com.bibek.firebase.firebase;

import com.bibek.firebase.dto.ProductDTO;
import com.google.api.client.auth.oauth2.Credential;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.web.multipart.MultipartFile;

import java.beans.BeanInfo;
import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.ExecutionException;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 11:16 AM
 **/
public class UploadFile {

    \ public String saveReview(ProductDTO review, MultipartFile file) throws ExecutionException, InterruptedException, IOException {

        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes());
        fos.close();
        BlobInfo blobInfo = storage.create(BlobInfo.newBuilder(BUCKET_NAME, file.getOriginalFilename()).build());
        System.out.println(blobInfo.getMediaLink());

//                                                                .build()
//                     file.openStream()


        Firestore dbFirestore= FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(review.getName()).set(review);

        return collectionApiFuture.get().getUpdateTime().toString();

    }

}
