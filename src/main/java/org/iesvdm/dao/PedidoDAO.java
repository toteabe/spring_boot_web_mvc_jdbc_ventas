package org.iesvdm.dao;

import java.util.List;

import org.iesvdm.dto.PedidoDTO;

public interface PedidoDAO {

	public List<PedidoDTO> getAllDTO(int idComercial);
}
