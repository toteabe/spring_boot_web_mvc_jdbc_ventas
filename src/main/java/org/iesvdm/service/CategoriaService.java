package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.CategoriaDAO;
import org.iesvdm.dto.CategoriaDTO;
import org.iesvdm.modelo.Categoria;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

	private CategoriaDAO categoriaDAO;
	
	public CategoriaService(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}
	
	public Categoria one(Integer id) {
		Optional<Categoria> optCat = categoriaDAO.find(id);
		if (optCat.isPresent())
			return optCat.get();
		else 
			return null;
	}
	
	public CategoriaDTO oneDTO(Integer id) {
		Optional<Categoria> optCat = categoriaDAO.find(id);
		if (optCat.isPresent()) {
			CategoriaDTO catDTO = new CategoriaDTO(optCat.get());
			catDTO.setConteoPeliculas(categoriaDAO.conteoPeliculas(catDTO.getId_categoria()));
			return catDTO;
		}
		else 
			return null;
	}
	
}
