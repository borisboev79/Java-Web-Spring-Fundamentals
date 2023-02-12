package com.softuni.mobilele.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.YearMonth;

public class YearPastOrPresentValidator implements ConstraintValidator<YearPastOrPresent, Integer> {

    private int minYear;

    @Override
    public void initialize(YearPastOrPresent constraintAnnotation) {
        this.minYear = constraintAnnotation.minYear();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        int currentYear = YearMonth.now().getYear();

        return value >= minYear && value <= currentYear;
    }
}
