package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.dto.ClienteDTO;
import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.exception.MiExcepcion;
import org.iesvdm.mapstruct.ComercialMapper;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
@ControllerAdvice
public class ComercialController {
	
	private ComercialService comercialService;
	
	public ComercialController(ComercialService comercialService) {
		this.comercialService = comercialService;
	}
	
	@ExceptionHandler(MiExcepcion.class)
	public String handleMiExcepcion(Model model, MiExcepcion miExcepcion) {
		
		model.addAttribute("traza", miExcepcion.getMessage());
		
		return "error-mi-excepcion";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String handleAllUncaughtExceeption(Model model, RuntimeException exception) {
		
		model.addAttribute("traza", exception.getMessage());
		
		return "error";
	}
	
	@GetMapping("/comerciales")
	public String listar(Model model) {
		
		List<Comercial> listaComerciales =  comercialService.listAll();
		model.addAttribute("listaComerciales", listaComerciales);
				
		return "comerciales";
		
	}
	
	@GetMapping("/comerciales/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		Comercial comercial = comercialService.one(id);
		List<PedidoDTO> listaPedidos = comercialService.oneListaPedidos(id);
		List<ClienteDTO> listaClientes = comercialService.oneListaClientes(id);
		double total = comercialService.pedidoTotal(listaPedidos);
		double media = comercialService.pedidoMedia(listaPedidos);
		double max = comercialService.pedidoTotalMax(listaPedidos);
		double min = comercialService.pedidoTotalMin(listaPedidos);
		
		model.addAttribute("comercial", comercial);
		model.addAttribute("listaPedidos", listaPedidos);
		model.addAttribute("listaClientes", listaClientes);
		model.addAttribute("total", total);
		model.addAttribute("media", media);
		model.addAttribute("max", max);
		model.addAttribute("min", min);
		
		
		return "detalle-comercial";
		
	}
	
	@GetMapping("/comerciales/crear")
	public String crear(Model model) {
		
		Comercial comercial = new Comercial();
		model.addAttribute("comercial", comercial);
		
		return "crear-comercial";
		
	}
	
	@PostMapping("/comerciales/crear")
	public String submitCrear(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult bindingResulted, Model model) {
		
		String view;
		
		if (bindingResulted.hasErrors()) {
			view = "crear-comercial";
			model.addAttribute("comercial", comercial);
		} else {
			view = "redirect:/comerciales";
			comercialService.newComercial(comercial);
		}
				
		return view;
		
	}
	
	@GetMapping("/comerciales/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		
		Comercial comercial = comercialService.one(id);
		model.addAttribute("comercial", comercial);
		
		return "editar-comercial";
		
	}
	
	
	@PostMapping("/comerciales/editar/{id}")
	public String submitEditar(@Valid @ModelAttribute("comercial") Comercial comercial, BindingResult bindingResulted, Model model) {
		
		String view;
		
		if (bindingResulted.hasErrors()) {
			view = "editar-comercial";
			model.addAttribute("comercial", comercial);
		} else {
			view = "redirect:/comerciales";
			comercialService.replaceComercial(comercial);
		}
				
		return view;
	}
	
	@PostMapping("/comerciales/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		
		comercialService.deleteComercial(id);
		
		return new RedirectView("/comerciales");
	}
	
}
