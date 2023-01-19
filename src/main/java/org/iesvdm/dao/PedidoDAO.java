package org.iesvdm.dao;

import java.util.List;

import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Pedido;

public interface PedidoDAO {

	public List<Pedido> getAll(int idComercial);
	public List<PedidoDTO> getAllDTO(int idComercial);
	public int numPedidosComercial(long idCliente, int id);
	public int numPedidosComercial(long idCliente, int id, int numDias);
}
