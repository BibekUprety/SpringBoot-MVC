package com.bibek.firebase.controller;

import com.bibek.firebase.dto.ProductDTO;
import com.bibek.firebase.models.Product;
import com.bibek.firebase.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
//
//    @PostMapping
//    public String save(@RequestBody Product product) throws ExecutionException, InterruptedException {
//        return productService.save(product);
//    }

    @PostMapping("/image")
    public Product saveProduct(@ModelAttribute ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }
}
