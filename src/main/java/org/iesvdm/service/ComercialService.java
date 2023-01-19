package org.iesvdm.service;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.iesvdm.dao.ClienteDAO;
import org.iesvdm.dao.ComercialDAO;
import org.iesvdm.dao.PedidoDAO;
import org.iesvdm.dao.PedidoDAOImpl;
import org.iesvdm.dto.ClienteDTO;
import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComercialService {
	
	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
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
	
	public List<PedidoDTO> oneListaPedidos(Integer id) {
		List<PedidoDTO> listaPedidos = pedidoDAO.getAllDTO(id);
		return listaPedidos;
	}
	
	public List<ClienteDTO> oneListaClientes (Integer id) {
		
		List<ClienteDTO> listaClientes = clienteDAO.getAllClienteDTO(id);
		return listaClientes;
	}
	
	public double pedidoTotal(List<PedidoDTO> lista) {
		
		double total = 0;
		if (lista.size() != 0) {
			for (PedidoDTO p : lista) {
				total += p.getTotal();
			}
		}
		return total;
	}
	
	public double pedidoMedia(List<PedidoDTO> lista) {
		
		double media = 0;
		if (lista.size() != 0)
			media = pedidoTotal(lista) / lista.size();
		return media;
	}
	
	public double pedidoTotalMax(List<PedidoDTO> lista) {
		
		double max = 0;
		if (lista.size() != 0) {
			max = lista.get(0).getTotal();
			for (PedidoDTO p : lista) {
				if (p.getTotal() > max)
					max = p.getTotal();
			}
		}
		return max;
	}
	
	public double pedidoTotalMin(List<PedidoDTO> lista) {
		
		double min = 0;
		if (lista.size() != 0) {
			min = lista.get(0).getTotal();
			for (PedidoDTO p : lista) {
				if (p.getTotal() < min)
					min = p.getTotal();
			}
		}
		return min;
	}
	
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
