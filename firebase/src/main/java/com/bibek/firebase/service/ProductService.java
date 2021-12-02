package com.bibek.firebase.service;

import com.bibek.firebase.dto.ProductDTO;
import com.bibek.firebase.fileStorage.FileStorageService;
import com.bibek.firebase.models.Product;
import com.bibek.firebase.reop.ProductRepo;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.concurrent.ExecutionException;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 7:17 AM
 **/
@Service
@RequiredArgsConstructor
public class ProductService {

    private final FileStorageService fileStorageService;
    private final ProductRepo productRepo;


    public Product saveBytesss(ProductDTO productDTO) throws IOException {
        byte[] image = productDTO.getImagesBytes().getBytes();
        Product product=Product.builder()
                .name(productDTO.getName())
                .imageBytes(image)
                .build();

        return productRepo.save(product);

    }



    public byte[] getImageByte(Integer id) throws IOException {
//        Product product1 = productRepo.getById(Long.parseLong(id));
//        byte[] encode = Base64.getEncoder().encode(product);

        System.out.println("here..."+id);
        Product product = productRepo.findById(id).get();
//        System.out.println(product);
//
//        byte[] product1 = Base64.getEncoder().encode(product.getImageBytes());
//        ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream(product1);
//        BufferedImage bufferedImage=ImageIO.read(byteArrayInputStream);
//        System.out.println(bufferedImage);
        return product.getImageBytes();
//        return bufferedImage;



    }


//    public Product saveProduct(ProductDTO productDTO) {
//
//        Product product = Product.builder()
//                .id(productDTO.getId())
//                .name(productDTO.getName())
//                .address(productDTO.getAddress())
//                .build();
//
//        if (productDTO.getImageUrl() != null) {
//            product.setImageUrl(fileStorageService.upload(productDTO.getImageUrl()));
//        }
//
//        return productRepo.save(product);
//    }


    public Product bytes(ProductDTO productDTO) throws IOException {

//        byte[] fileContent = FileUtils.readFileToByteArray(new File(String.valueOf(productDTO.getImage())));
//        String images = Base64.getEncoder().encodeToString(fileContent);
//        String images = Base64.getEncoder().encodeToString(productDTO.getImage().getBytes());


        Product product = Product.builder()
                .id(productDTO.getId())
                .address(productDTO.getAddress())
                .build();

        product.setImage(fileStorageService.getEncodedByteStringFromFile(productDTO.getImage()));
        return productRepo.save(product);


    }

//    public String getImage(String imageEncode) throws FileNotFoundException {
//        System.out.println(imageEncode);
//       String imageEncodedFile= productRepo.findByImage(imageEncode);
//        FileInputStream stream=new FileInputStream(imageEncodedFile);
//
//        return ;
//
//    }



    public Resource getImage(Integer id) {
//        String product=productRepo.findByImage(id);

//        String imagePath= fileStorageService.getEncodedByteString(product);
//        System.out.println(product);

//        String stringImage=getImage();
//        if (imagePath ==null || imagePath.isEmpty()){
//            throw  new RuntimeException("id not found");
//        }
//        InputStream inputStream =getClass().getResourceAsStream(imagePath);
//        return (Resource) inputStream;

return null;
    }


//    }




}
