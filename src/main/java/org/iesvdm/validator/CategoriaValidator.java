package org.iesvdm.validator;

import org.iesvdm.modelo.Cliente;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoriaValidator implements ConstraintValidator<RangoCategoria, Integer> {
	
    private final int[] valoresValidos = new int[]{100, 200, 300, 400, 500, 600, 700, 800, 1000};

    @Override
    public void initialize(RangoCategoria constraintAnnotation) {
    	
    }
    
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        for (int i : valoresValidos) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
}