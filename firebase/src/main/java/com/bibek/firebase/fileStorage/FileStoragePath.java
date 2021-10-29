package com.bibek.firebase.fileStorage;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 8:38 AM
 **/
public enum FileStoragePath {

    CUSTOMER("customer");

    private String defaultFolderName;
    FileStoragePath(String defaultFolderName){
        this.defaultFolderName=defaultFolderName;
    }

    public String getDefaultFolderName() {
        return defaultFolderName;
    }

    public void setDefaultFolderName(String defaultFolderName) {
        this.defaultFolderName = defaultFolderName;
    }
}
