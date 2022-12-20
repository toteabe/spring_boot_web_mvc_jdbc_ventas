package org.iesvdm.dao;

import java.util.List;
import java.util.Optional;

import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PedidoDAOImpl implements PedidoDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<PedidoDTO> getAllDTO(int idComercial) {
		

		List<PedidoDTO> listPed = jdbcTemplate.query(
                "SELECT P.*, C.nombre as nombre_cliente FROM pedido P inner join cliente C on P.id_cliente = C.id WHERE P.id_comercial = ?",
                (rs, rowNum) -> new PedidoDTO(rs.getInt("id"),
                						 	rs.getDouble("total"),
                						 	rs.getDate("fecha"),
                						 	rs.getInt("id_cliente"),
                						 	rs.getInt("id_comercial"),
                						 	rs.getString("nombre_cliente") 
                						 	),
                idComercial
				);
		
		log.info("Devueltos {} registros.", listPed.size());
		
        return listPed;
	}
}