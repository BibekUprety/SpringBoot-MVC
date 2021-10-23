package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author bibek
 * @project google
 * @project 05/10/2021 - 7:15 AM
 **/
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer name;

    private String file;
}
