package com.bibek.customvalidation.customValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,})
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {

    String message() default "{email.invalid}";
    Class <?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};

}
