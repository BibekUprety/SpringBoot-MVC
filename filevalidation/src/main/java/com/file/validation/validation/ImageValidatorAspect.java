package com.file.validation.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


@Component
public class ImageValidatorAspect implements ConstraintValidator<ValidateImage, MultipartFile> {

        private String constraintMessage;
        private String fileName;

        Pattern pattern = Pattern.compile("(?:jpg|gif|png|jpeg|JPG|GIF|PNG|JPEG)");

        @Override
        public void initialize(ValidateImage constraintAnnotation) {
            constraintMessage = constraintAnnotation.message();
            fileName = constraintAnnotation.url();
        }

        @Override
        public boolean isValid(MultipartFile multipartFile, ConstraintValidatorContext context) {
            String extension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
//            if (multipartFile.getOriginalFilename() == null || extension.isEmpty()) {
//                return false;
//            } else if (pattern.matcher(extension).matches()) {
//                return true;
//            } else {
//                context.disableDefaultConstraintViolation();
//                context.buildConstraintViolationWithTemplate(constraintMessage).addConstraintViolation();
//                return false;
//            }
            if (pattern.matcher(extension).matches()){
                return true;
            }
            else{
                return false;
            }


        }
}
