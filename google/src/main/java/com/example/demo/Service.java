package com.example.demo;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * @author bibek
 * @project google
 * @project 05/10/2021 - 7:15 AM
 **/
@org.springframework.stereotype.Service
public class Service {
    private Repo repo;
    private FileManager fileManager;
    private GoogleDriveManager googleDriveManager;

    public Service(Repo repo, FileManager fileManager) {
        this.repo = repo;
        this.fileManager = fileManager;
    }

    public Fto save(FDTo f) {
        Fto fto = Fto.builder().
                name(f.getName())
                .build();
        if (f.getFile() != null) {
            fto.setFile(fileManager.uploadFile(f.getFile(),path));

        }
        return repo.save(fto);
    }
}
