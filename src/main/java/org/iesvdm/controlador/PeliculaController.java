package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.modelo.Categoria;
import org.iesvdm.modelo.Idioma;
import org.iesvdm.modelo.Pelicula;
import org.iesvdm.service.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class PeliculaController {

	private PeliculaService peliculaService;
	
	public PeliculaController(PeliculaService peliculaService) {
		this.peliculaService = peliculaService;
	}
	
	@GetMapping("/peliculas")
	public String listar(Model model) {
		
		List<Pelicula> listaPeliculas =  peliculaService.listAll();
		model.addAttribute("listaPeliculas", listaPeliculas);
				
		return "peliculas";
		
	}
	
	@GetMapping("/peliculas/crear")
	public String crear(Model model) {
		
		Pelicula pelicula = new Pelicula();
		List<Idioma> listaIdiomas = peliculaService.listadoIdiomas();
		List<Categoria> listaCategorias = peliculaService.listadoCategorias();
		
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("listaIdiomas", listaIdiomas);
		model.addAttribute("listaCategorias", listaCategorias);
		
		return "crear-pelicula";
		
	}
	
	@PostMapping("/peliculas/crear")
	public String submitCrear(@Valid @ModelAttribute("pelicula") Pelicula pelicula, BindingResult bindingResulted, Model model) {
		
		String view;
		
		if (bindingResulted.hasErrors()) {
			view = "crear-pelicula";
			List<Idioma> listaIdiomas = peliculaService.listadoIdiomas();
			List<Categoria> listaCategorias = peliculaService.listadoCategorias();
			model.addAttribute("pelicula", pelicula);
			model.addAttribute("listaIdiomas", listaIdiomas);
			model.addAttribute("listaCategorias", listaCategorias);
		} else {
			view = "redirect:/peliculas";
			peliculaService.newPelicula(pelicula);
		}

				
		return view;
		
	}
	
}
