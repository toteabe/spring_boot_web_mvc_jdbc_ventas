package org.iesvdm.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@SuppressWarnings("unused")
public class Comercial {
	
	public Comercial() {
		
	}
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private float comision;
	//private String fotoPerfil;
	
}