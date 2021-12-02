//package com.bibek.firebase.firebase;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.io.FileInputStream;
//import java.io.IOException;
//
///**
// * @author bibek
// * @project firebase
// * @project 28/10/2021 - 7:12 AM
// **/
//
//@Service
//public class FirebaseInitialization {
//
//    @PostConstruct
//    public void initialization() throws IOException {
////        FileInputStream serviceAccount =
////                new FileInputStream("./serviceAccountKey.json");
////
////        FirebaseOptions options = new FirebaseOptions.Builder()
////                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
////                .build();
////
////        FirebaseApp.initializeApp(options);
//
//
//        FileInputStream serviceAccount =
//                new FileInputStream("./serviceAccountKey.json");
//
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                .build();
//
//        FirebaseApp.initializeApp(options);
//
//
//
//    }
//
//
//}
