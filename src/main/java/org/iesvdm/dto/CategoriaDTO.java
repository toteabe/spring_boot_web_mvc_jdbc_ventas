package org.iesvdm.dto;

import org.iesvdm.modelo.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriaDTO {
	
	public CategoriaDTO(Categoria cat) {
		this.id_categoria = cat.getId_categoria();
		this.nombre = cat.getNombre();
		this.conteoPeliculas = 0;
	}
	private int id_categoria;
	private String nombre;
	private int conteoPeliculas;
}
