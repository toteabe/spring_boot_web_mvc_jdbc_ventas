package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.dto.ComercialDTO;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Pedido;
import org.iesvdm.service.ClienteService;
import org.iesvdm.service.PedidoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class PedidoController {

	private PedidoService pedidoService;
	
	public PedidoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@GetMapping("/pedidos")
	public String listar(Model model) {
		
		List<Pedido> listaPedidos =  pedidoService.listAll();
		model.addAttribute("listaPedidos", listaPedidos);
				
		return "pedidos";
		
	}
	
	@GetMapping("/pedidos/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		Pedido pedido = pedidoService.one(id);
		
		model.addAttribute("pedido", pedido);
		
		return "detalle-pedido";
		
	}
	
	@GetMapping("/pedidos/crear")
	public String crear(Model model) {
		
		Pedido pedido = new Pedido();
		model.addAttribute("pedido", pedido);
		
		return "crear-pedido";
		
	}
	
	@PostMapping("/pedidos/crear")
	public String submitCrear(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult bindingResulted, Model model) {
		
		String view;
		
		/*if (bindingResulted.hasErrors()) {
			view = "crear-pedido";
			model.addAttribute("pedido", pedido);
		} else {
			view = "redirect:/pedidos";
			pedidoService.newPedido(pedido);
		}*/
		view = "redirect:/pedidos";
		pedidoService.newPedido(pedido);
				
		return view;
		
	}
	
}
