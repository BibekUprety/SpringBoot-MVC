package com.example.demo;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import org.springframework.stereotype.Service;

import java.io.*;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

/**
 * @author bibek
 * @project google
 * @project 04/10/2021 - 4:30 PM
 **/
@Service
public class GoogleDriveManager {

    private static final String APPLICATION_NAME = "springboot";
    private static JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";


    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    public Drive getInstance() throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredential(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        return service;
    }

    private Credential getCredential(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        InputStream inputStream = GoogleDriveManager.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (inputStream == null) {
            throw new FileNotFoundException("Resource not found");
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(inputStream));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8074).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");


    }

}
