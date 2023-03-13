package org.iesvdm.modelo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Categoria {

	public Categoria() {
	}
	
	private int id_categoria;
	private String nombre;
}
