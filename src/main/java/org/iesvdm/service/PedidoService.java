package org.iesvdm.service;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	private PedidoDAO pedidoDAO;
	
	public PedidoService(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}
	
	public List<Pedido> listAll() {
		
		return pedidoDAO.getAll();
	}
	
	public Pedido one(Integer id) {
		Optional<Pedido> optPed = pedidoDAO.find(id);
		if (optPed.isPresent())
			return optPed.get();
		else 
			return null;
	}
	
	public void newPedido(Pedido pedido) {
		
		pedidoDAO.create(pedido);
		
	}
}
