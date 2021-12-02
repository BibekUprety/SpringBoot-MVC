package com.bibek.firebase.controller;

import com.bibek.firebase.dto.ProductDTO;
import com.bibek.firebase.fileStorage.FileStorageService;
import com.bibek.firebase.models.Product;
import com.bibek.firebase.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.MatchesPattern;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 7:23 AM
 **/
@RestController
@RequestMapping("/product")
public class ProductController {


    private final ProductService productService;
    private FileStorageService fileStorageService;

//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    public ProductController(ProductService productService, FileStorageService fileStorageService) {
        this.productService = productService;
        this.fileStorageService = fileStorageService;
    }
//
//    @PostMapping
//    public String save(@RequestBody Product product) throws ExecutionException, InterruptedException {
//        return productService.save(product);
//    }

//    @PostMapping("/image")
//    public Product saveProduct(@ModelAttribute ProductDTO productDTO){
//        return productService.saveProduct(productDTO);
//    }

//    @PostMapping("/profile/pic")
//    public Object upload(@ModelAttribute ProductDTO productDTO) {
////        logger.info("HIT -/upload | File Name : {}", multipartFile.getOriginalFilename());
//        return productService.upload(productDTO);
//    }

//    @PostMapping("/profile/pic/{fileName}")
//    public Object download(@PathVariable String fileName) throws IOException {
////        logger.info("HIT -/download | File Name : {}", fileName);
//        return fileStorageService.download(fileName);
//        }


//    @PostMapping
//    private ResponseEntity<?> save(@ModelAttribute ProductDTO productDTO){
//        productService.saveProduct(productDTO);
//        return ResponseEntity.ok("save");
//    }

    @PostMapping("/bytes")
    public ResponseEntity<?> saveS(@ModelAttribute ProductDTO productDTO) throws IOException {
        Product p = productService.bytes(productDTO);
        return ResponseEntity.ok("save");
    }

    @GetMapping(value = "/view",produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<?> gets(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(productService.getImage(id));
    }

    @PostMapping("/saveBytes")
    public ResponseEntity<?> saveBytessssss(@ModelAttribute ProductDTO productDTO) throws IOException {
        Product product =productService.saveBytesss(productDTO);
        return ResponseEntity.ok("save");

    }

    @GetMapping(value = "/byte/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    private ResponseEntity<?> read(@PathVariable Integer id) throws IOException {
        return ResponseEntity.ok(productService.getImageByte(id));
    }
}