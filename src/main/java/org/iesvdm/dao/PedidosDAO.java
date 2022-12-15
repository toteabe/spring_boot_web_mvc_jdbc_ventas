package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;

public interface PedidosDAO {

	public List<Cliente> listarClientes(int idComercial);
}
