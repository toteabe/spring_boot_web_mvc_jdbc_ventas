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
	
	@NotBlank(message = "Por favor, introduzca el nombre.")
	@Size(max=30, message = "Nombre como máximo de 30 caracteres.")
	private String nombre;
	
	@NotBlank(message = "Por favor, introduzca el primer apellido.")
	@Size(max=30, message = "Apellido como máximo de 30 caracteres.")
	private String apellido1;
	
	private String apellido2;
	
	@DecimalMin(value="0.276", inclusive=true, message = "La comisión debe ser superior o igual a 0.276.")
	@DecimalMax(value="0.946", inclusive=true, message = "La comisión debe ser inferior o igual a 0.946.")
	private BigDecimal comision;
	
}