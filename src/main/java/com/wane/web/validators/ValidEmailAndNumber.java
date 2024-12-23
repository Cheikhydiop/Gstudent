package com.wane.web.validators;



import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CustomEmailAndNumberValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailAndNumber {
    String message() default "Email ou numéro invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}