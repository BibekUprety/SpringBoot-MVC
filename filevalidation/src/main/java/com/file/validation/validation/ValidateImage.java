package com.file.validation.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD, ElementType.PARAMETER})/*
this is for field level
*/
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ImageValidatorAspect.class })
public @interface ValidateImage {
    String message() default "Please Enter valid Image";

    String url() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
