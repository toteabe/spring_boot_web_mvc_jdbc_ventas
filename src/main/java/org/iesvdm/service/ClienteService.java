package org.iesvdm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.dto.ComercialDTO;
import org.iesvdm.mapstruct.ComercialMapper;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	private ComercialMapper comercialMapper;
	
	private ClienteDAO clienteDAO;
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	
	
	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ClienteService(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	public List<Cliente> listAll() {
		
		return clienteDAO.getAll();
		
	}
	
	public Cliente one(Integer id) {
		Optional<Cliente> optCli = clienteDAO.find(id);
		if (optCli.isPresent())
			return null;
		else 
			return null;
	}
	
	public List<ComercialDTO> listarComerciales(long idCliente, Integer id) {
		
		List<Comercial> lista = clienteDAO.listarComerciales(id);
		List<ComercialDTO> listaDTO = new ArrayList<>();
		
		for (Comercial comercial : lista) {
			listaDTO.add(comercialMapper.comercialAComercialDTO(
					comercial, 
					pedidoDAO.numPedidosComercial(idCliente, comercial.getId()),
					pedidoDAO.numPedidosComercial(idCliente, comercial.getId(), 90),
					pedidoDAO.numPedidosComercial(idCliente, comercial.getId(), 181),
					pedidoDAO.numPedidosComercial(idCliente, comercial.getId(), 365),
					pedidoDAO.numPedidosComercial(idCliente, comercial.getId(), 1825)
			));
		}
		
		return listaDTO;
		
	}
	
	public void newCliente(Cliente cliente) {
		
		clienteDAO.create(cliente);
		
	}
	
	public void replaceCliente(Cliente cliente) {
		
		clienteDAO.update(cliente);
		
	}
	
	public void deleteCliente(int id) {
		
		clienteDAO.delete(id);
		
	}
	
	

}
