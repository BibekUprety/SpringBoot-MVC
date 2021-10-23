package com.example.demo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author bibek
 * @project google
 * @project 05/10/2021 - 8:23 AM
 **/
@Data
public class FDTo {
    private Integer name;
    private MultipartFile file;
}
