package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
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
	
	private float comision;
	
}