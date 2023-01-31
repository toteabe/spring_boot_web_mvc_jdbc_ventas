package org.iesvdm.validator;

import org.iesvdm.modelo.Cliente;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoriaValidator implements ConstraintValidator<RangoCategoria, Integer> {
	
	private int[] valoresValidos;
    
    @Override
    public void initialize(RangoCategoria constraintAnnotation) {
        this.valoresValidos = constraintAnnotation.valoresValidos();
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