package com.bibek.firebase.fileStorage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 8:10 AM
 **/
@Component
@ConfigurationProperties(prefix = "storage")
public class StorageProperties {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
