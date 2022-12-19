package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.ComercialDAO;
/*import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.dao.PedidoDAOImpl;
import org.iesvdm.dto.ComercialDTO;
import org.iesvdm.dto.PedidoDTO;*/
import org.iesvdm.modelo.Comercial;
import org.springframework.stereotype.Service;

@Service
public class ComercialService {
	
	private ComercialDAO comercialDAO;
	
	public ComercialService(ComercialDAO comercialDAO) {
		this.comercialDAO = comercialDAO;
	}
	
	public List<Comercial> listAll() {
		
		return comercialDAO.getAll();
		
	}
	
	public Comercial one(Integer id) {
		Optional<Comercial> optCli = comercialDAO.find(id);
		if (optCli.isPresent())
			return optCli.get();
		else 
			return null;
	}
	
	/*public ComercialDTO oneDTO(Integer id) {
		PedidoDAO pedidoDAO = new PedidoDAOImpl();
		Optional<Comercial> optCom = comercialDAO.find(id);
		if (optCom.isPresent()) {
			Comercial c = optCom.get();
			ComercialDTO comercialDTO = new ComercialDTO(c);
			comercialDTO.setListaPedidosDTO(pedidoDAO.getAllDTO(comercialDTO.getId()));
			return comercialDTO;
		}
			
		else 
			return null;
	}*/
	
	public void newComercial(Comercial comercial) {
		
		comercialDAO.create(comercial);
		
	}
	
	public void replaceComercial(Comercial comercial) {
		
		comercialDAO.update(comercial);
		
	}
	
	public void deleteComercial(int id) {
		
		comercialDAO.delete(id);
		
	}
	
	
	

}
