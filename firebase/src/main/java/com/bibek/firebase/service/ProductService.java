package com.bibek.firebase.service;

import com.bibek.firebase.dto.ProductDTO;
import com.bibek.firebase.fileStorage.FileStoragePath;
import com.bibek.firebase.fileStorage.FileStorageService;
import com.bibek.firebase.models.Product;
import com.bibek.firebase.reop.ProductRepo;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 7:17 AM
 **/
@Service
public class ProductService {

    private final FileStorageService fileStorageService;
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(FileStorageService fileStorageService, ProductRepo productRepo) {
        this.fileStorageService = fileStorageService;
        this.productRepo = productRepo;
    }

    private static final String COLLECTION_NAME = "products";

    public String save(Product product) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> resultApiFuture = dbFirestore.collection(COLLECTION_NAME).document(product.getName()).set(product);
        return resultApiFuture.get().getUpdateTime().toString();
    }

    public Product saveProduct(ProductDTO productDTO) {

        Product product = Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .address(productDTO.getAddress())
                .build();

        if (productDTO.getImageUrl() != null) {
            product.setImageUrl(fileStorageService.store(productDTO.getImageUrl(),
                    FileStoragePath.CUSTOMER.getDefaultFolderName().concat("/")));

        }

        return productRepo.save(product);

    }
}
