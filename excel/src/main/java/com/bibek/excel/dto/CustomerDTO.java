package com.bibek.excel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author bibek
 * @project excel
 * @project 30/11/2021 - 11:55 AM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private MultipartFile file;
}
