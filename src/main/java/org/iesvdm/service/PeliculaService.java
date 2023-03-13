package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.CategoriaDAO;
import org.iesvdm.dao.IdiomaDAO;
import org.iesvdm.dao.PeliculaDAO;
import org.iesvdm.modelo.Categoria;
import org.iesvdm.modelo.Idioma;
import org.iesvdm.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaService {

	private PeliculaDAO peliculaDAO;
	
	@Autowired
	private IdiomaDAO idiomaDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	public PeliculaService(PeliculaDAO peliculaDAO) {
		this.peliculaDAO = peliculaDAO;
	}
	
	public List<Pelicula> listAll() {
		
		return peliculaDAO.getAll();
	}
	
	public void newPelicula(Pelicula pelicula) {
		
		peliculaDAO.create(pelicula);
		
	}
	
	public List<Idioma> listadoIdiomas() {
		return idiomaDAO.getAll();
	}
	
	public List<Categoria> listadoCategorias() {
		return categoriaDAO.getAll();
	}
}
