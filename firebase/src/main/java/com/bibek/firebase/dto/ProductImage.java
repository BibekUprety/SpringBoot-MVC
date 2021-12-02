package com.bibek.firebase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bibek
 * @project firebase
 * @project 02/11/2021 - 12:24 PM
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

    private Integer id;
    private byte[] image;
}
