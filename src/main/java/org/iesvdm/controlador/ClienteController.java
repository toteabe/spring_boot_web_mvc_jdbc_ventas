package org.iesvdm.controlador;

import java.util.List;

import org.iesvdm.dto.ComercialDTO;
import org.iesvdm.exception.MiExcepcion;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.iesvdm.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.validation.Valid;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
@ControllerAdvice
public class ClienteController {
	
	private ClienteService clienteService;
	
	 public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
	 
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
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
	
	//@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Cliente> listaClientes =  clienteService.listAll();
		model.addAttribute("listaClientes", listaClientes);
				
		return "clientes";
		
	}
	
	@GetMapping("/clientes/{id}")
	public String detalle(Model model, @PathVariable Integer id ) {
		
		Cliente cliente = clienteService.one(id);
		List<ComercialDTO> listaComerciales = clienteService.listarComerciales(cliente.getId(), id);
		
		model.addAttribute("cliente", cliente);
		model.addAttribute("listaComerciales", listaComerciales);
		
		return "detalle-cliente";
		
	}
	
	@GetMapping("/clientes/crear")
	public String crear(Model model) {
		
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		
		return "crear-cliente";
		
	}
	
	@PostMapping("/clientes/crear")
	public String submitCrear(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResulted, Model model) {
		
		String view;
		
		if (bindingResulted.hasErrors()) {
			view = "crear-cliente";
			model.addAttribute("cliente", cliente);
		} else {
			view = "redirect:/clientes";
			clienteService.newCliente(cliente);
		}
				
		return view;
		
	}
	
	@GetMapping("/clientes/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {
		
		Cliente cliente = clienteService.one(id);
		model.addAttribute("cliente", cliente);
		
		return "editar-cliente";
		
	}
	
	
	@PostMapping("/clientes/editar/{id}")
	public String submitEditar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult bindingResulted, Model model) {
		
		String view;
		
		if( bindingResulted.hasErrors()) {
			view = "editar-cliente";
			model.addAttribute("cliente", cliente);
		} else {
			view="redirect:/clientes";
			clienteService.replaceCliente(cliente);
		}
		
		return view;
	}
	
	@PostMapping("/clientes/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {
		
		clienteService.deleteCliente(id);
		
		return new RedirectView("/clientes");
	}
	
	
	
	

}
