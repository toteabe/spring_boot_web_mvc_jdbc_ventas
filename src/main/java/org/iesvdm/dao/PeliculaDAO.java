package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Pelicula;

public interface PeliculaDAO {

	public void create(Pelicula pelicula);
	public List<Pelicula> getAll();
}
