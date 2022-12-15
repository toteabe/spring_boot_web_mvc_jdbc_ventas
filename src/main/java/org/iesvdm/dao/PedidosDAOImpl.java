package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PedidosDAOImpl implements PedidosDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Cliente> listarClientes(int idComercial) {
		// TODO Auto-generated method stub
		return null;
	}
}