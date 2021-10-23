package com.file.validation.dto;

import com.file.validation.validation.ValidateImage;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author bibek
 * @project filevalidation
 * @project 23/10/2021 - 2:22 PM
 **/
public class ClientBannerDetailsDTO {
    private Integer id;
    private String bannerTitle;
    private String bannerDescription;
    @ValidateImage
    private MultipartFile bannerFile;

}


