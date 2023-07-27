package org.iesvdm;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootWebMvcJdbcVentasApplication implements CommandLineRunner{

	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcJdbcVentasApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*log.info("*******************************");
		log.info("*Prueba de arranque ClienteDAO*");
		log.info("*******************************");
		
		clienteDAO.getAll().forEach(c -> log.info("Cliente: {}", c));
		
		int id = 1;
		Optional<Cliente> cliente = clienteDAO.find(id);
		
		if (cliente.isPresent()) {
			log.info("Cliente {}: {}", id, cliente.get());
			
			String nombreOld = cliente.get().getNombre();
			
			cliente.get().setNombre("Jose M");
			
			clienteDAO.update(cliente.get());
			
			cliente = clienteDAO.find(id);
			
			log.info("Cliente {}: {}", id, cliente.get());
			
			//Volvemos a cargar el nombre antiguo..
			cliente.get().setNombre(nombreOld);
			clienteDAO.update(cliente.get());
			
		}
		
		// Como es un cliente nuevo a persistir, id a 0
		Cliente clienteNew = new Cliente(0, "Jose M", "Martín", null, "Málaga", 100, null);
		
		//create actualiza el id
		clienteDAO.create(clienteNew);
		
		log.info("Cliente nuevo con id = {}", clienteNew.getId());
		
		clienteDAO.getAll().forEach(c -> log.info("Cliente: {}", c));
		
		//borrando por el id obtenido de create
		clienteDAO.delete(clienteNew.getId());
		
		clienteDAO.getAll().forEach(c -> log.info("Cliente: {}", c));
		
		log.info("************************************");
		log.info("*FIN: Prueba de arranque ClienteDAO*");
		log.info("************************************");
		
		log.info("\n\n\n");
		
		log.info("*******************************");
		log.info("*Prueba de arranque ComercialDAO*");
		log.info("*******************************");
		
		comercialDAO.getAll().forEach(c -> log.info("Comercial: {}", c));
		
		id = 1;
		Optional<Comercial> comercial = comercialDAO.find(id);
		
		if (cliente.isPresent()) {
			log.info("Comercial {}: {}", id, comercial.get());
			
			String nombreOld = comercial.get().getNombre();
			
			comercial.get().setNombre("Jose M");
			
			comercialDAO.update(comercial.get());
			
			comercial = comercialDAO.find(id);
			
			log.info("Comercial {}: {}", id, comercial.get());
			
			comercial.get().setNombre(nombreOld);
			comercialDAO.update(comercial.get());
			
		}
		
		Comercial comercialNew = new Comercial(0, "Jose M", "Martín", "Sánchez", 2000);
		
		comercialDAO.create(comercialNew);
		
		log.info("Comercial nuevo con id = {}", comercialNew.getId());
		
		comercialDAO.getAll().forEach(c -> log.info("Comercial: {}", c));
		
		comercialDAO.delete(comercialNew.getId());
		
		comercialDAO.getAll().forEach(c -> log.info("Comercial: {}", c));
		
		log.info("************************************");
		log.info("*FIN: Prueba de arranque ComercialDAO*");
		log.info("************************************");
		*/
	}

}
