package com.example.demo.youtube.controller;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.Value;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

/**
 * @author bibek
 * @project google
 * @project 07/10/2021 - 3:40 PM
 **/
public class HomeController {
    private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);

    private static final String USER_IDENTIFY_KEY = "MY_DUMMY_USE";

    @Value("${google.oauth.callback.uri}")
    private String CALLBACK_URI;

    @Value("${google.secret.key.path}")
    private Resource gdSecretKeys;

    @Value("${google.credentials.folder.path}")
    private Resource credientialFolder;

    private GoogleAuthorizationCodeFlow flow;

    @PostConstruct
    public void init() throws IOException {
        GoogleClientSecrets secrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(gdSecretKeys.getInputStream()));
        flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, secrets, SCOPES

        )
                .setDataStoreFactory(new FileDataStoreFactory(credientialFolder.getFile())).build();


    }

    @GetMapping(value = {"/"})
    public String showHomePage() throws IOException {
        boolean isUserIsAunthencated = false;

        Credential credential = flow.loadCredential(USER_IDENTIFY_KEY);
        if (credential != null) {
            boolean tokenVlaid = credential.refreshToken();
            if (tokenVlaid = credential.refreshToken()) {
                isUserIsAunthencated = true;
            }
        }
        return isUserIsAunthencated ? "user is authenciated" : null;

    }

    @GetMapping(value = {"/googlesign"})
    public void dgGoogle(HttpServletResponse response) throws IOException {
        GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();
        String redirectUrl = url.setRedirectUri(CALLBACK_URI).setAccessType("offline").build();
        response.sendRedirect(redirectUrl);
    }

    @GetMapping(value = {"/oauth"})
    public String saveAuthorization(HttpServletRequest request) throws IOException {
        String code = request.getParameter("code");
        if (code != null) {
            saveToken(code);
            return "dasboard";
        }
        return "index";
    }

    private void saveToken(String code) throws IOException {
        GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(CALLBACK_URI).execute();
        flow.createAndStoreCredential(response, USER_IDENTIFY_KEY);
    }
}
