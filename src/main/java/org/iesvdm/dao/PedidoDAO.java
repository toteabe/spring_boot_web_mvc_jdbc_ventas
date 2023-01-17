package org.iesvdm.dao;

import java.util.List;

import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Pedido;

public interface PedidoDAO {

	public List<Pedido> getAll(int idComercial);
	public List<PedidoDTO> getAllDTO(int idComercial);
	public int numPedidosComercial(int id);
	public int numPedidosComercial(int id, int numDias);
	/*public int numPedidosComercialTrimestre(int d);
	public int numPedidosComercialSemestre(int d);
	public int numPedidosComercialAño(int d);
	public int numPedidosComercialLustro(int d);*/
	
}
