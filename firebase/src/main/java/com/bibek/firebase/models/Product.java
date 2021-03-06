package com.bibek.firebase.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 7:11 AM
 **/
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String address;

    @Lob
    private String image;


    @Lob
    private byte[] imageBytes;
//    private String imageUrl;
}
