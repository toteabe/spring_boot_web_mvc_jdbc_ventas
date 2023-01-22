package org.iesvdm.modelo;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@AllArgsConstructor
@SuppressWarnings("unused")
public class Comercial {
	
	public Comercial() {
		
	}
	
	private int id;
	
	@NotBlank(message = "{error.comercial.nombre.notBlank}")
	@Size(max=30, message = "{error.comercial.nombre.max}")
	private String nombre;
	
	@NotBlank(message = "{error.comercial.apellido1.notBlank}")
	@Size(max=30, message = "{error.comercial.apellido1.max}")
	private String apellido1;
	
	private String apellido2;
	
	@NotNull(message = "{error.comercial.comision.notNull}")
	@DecimalMin(value="0.276", inclusive=true, message = "{error.comercial.comision.min}")
	@DecimalMax(value="0.946", inclusive=true, message = "{error.comercial.comision.max}")
	private BigDecimal comision;
	
}