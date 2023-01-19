package org.iesvdm.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteDTO {

	public ClienteDTO() {
	}
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String ciudad;
	private int categoria;
	private String fotoPerfil;
	private double pedidoMax;
}
