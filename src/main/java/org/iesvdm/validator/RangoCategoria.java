package org.iesvdm.validator;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = CategoriaValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RangoCategoria {

	String message() default "{error.cliente.categoria.custom}";
	
	//Para validación en wizards, poco uso en la actualidad.
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    //Implementar el array que recoge la posible repetición de la anotación
  	@Target(ElementType.FIELD)
  	@Retention(RetentionPolicy.RUNTIME)
  	@Documented
  	@interface List {
  		RangoCategoria[] value();
  	}
}
