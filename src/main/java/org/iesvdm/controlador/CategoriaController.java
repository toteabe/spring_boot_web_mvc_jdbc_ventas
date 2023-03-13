package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.dto.CategoriaDTO;
import org.iesvdm.modelo.Categoria;
import org.iesvdm.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class CategoriaController {

	private CategoriaService categoriaService;
	
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@GetMapping("/categorias/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		CategoriaDTO categoria = categoriaService.oneDTO(id);
		
		model.addAttribute("categoria", categoria);
		
		return "detalle-categoria";
		
	}
	
}
