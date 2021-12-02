package com.bibek.firebase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 7:50 AM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private String name;
    private String address;
    private MultipartFile image;

    private MultipartFile imagesBytes;

//    private MultipartFile imageUrl;
}
