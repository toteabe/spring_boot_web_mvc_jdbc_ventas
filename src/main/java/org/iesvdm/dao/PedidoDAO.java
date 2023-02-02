package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Pedido;

public interface PedidoDAO {

	public void create(Pedido pedido);
	public List<Pedido> getAll(int idComercial);
	public List<Pedido> getAll();
	public List<PedidoDTO> getAllDTO(int idComercial);
	public int numPedidosComercial(long idCliente, int id);
	public int numPedidosComercial(long idCliente, int id, int numDias);
	Optional<Pedido> find(int id);
}
