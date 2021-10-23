package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author bibek
 * @project google
 * @project 05/10/2021 - 6:37 AM
 **/
@RestController
@RequestMapping("/file")
public class MainController {

    private FileManager fileManager;
    private Service service;

    public MainController(FileManager fileManager, Service service) {
        this.fileManager = fileManager;
        this.service = service;
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<?> addFile(@RequestBody MultipartFile file, @RequestParam(required = false) String path){
        System.out.println("RequestCntai f"+ file.getOriginalFilename());
        String fileId = fileManager.uploadFile(file,path);
        if (fileId == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("added"+fileId);


    }

    @PostMapping
    public ResponseEntity<?> save(@ModelAttribute FDTo fdTo){
        Fto fdTo1 = service.save(fdTo);
        return ResponseEntity.ok("sucess");
    }
}
