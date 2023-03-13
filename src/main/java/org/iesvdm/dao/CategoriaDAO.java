package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Categoria;
import org.iesvdm.modelo.Idioma;

public interface CategoriaDAO {

	Optional<Categoria> find(int id);
	
	int conteoPeliculas(int id);
	
	public List<Categoria> getAll();
}
