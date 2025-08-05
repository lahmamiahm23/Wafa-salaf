package com.example.wafaapp.customValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
public @interface AgeConstraint {
    String message() default "Age must be at least 16 years";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};

    int value();
}
