//package com.bibek.firebase.firebase;
//
//import java.io.FileInputStream;
//
///**
// * @author bibek
// * @project firebase
// * @project 29/10/2021 - 3:53 PM
// **/
//public class AdminSDK {
//
//    String bucketName = environment.getRequiredProperty("FIREBASE_BUCKET_NAME");
//    String projectId = environment.getRequiredProperty("FIREBASE_PROJECT_ID");
//    FileInputStream serviceAccount =
//            new FileInputStream("/home/user/Downloads/service-account-file.json");
//        StorageOptions.newBuilder()
//                .setProjectId(projectId)
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//            .build();
//}
