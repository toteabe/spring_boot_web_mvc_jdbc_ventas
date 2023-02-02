package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.dto.PedidoDTO;
import org.iesvdm.modelo.Cliente;
import org.iesvdm.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PedidoDAOImpl implements PedidoDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override	
	public synchronized void create(Pedido pedido) {
		
							//Desde java15+ se tiene la triple quote """ para bloques de texto como cadenas.
		String sqlInsert = """
							INSERT INTO pedido (total, fecha, id_cliente, id_comercial) 
							VALUES  (     ?,         ?,         ?,       ?)
						   """;
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		//Con recuperación de id generado
		int rows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
			int idx = 1;
			ps.setDouble(idx++, pedido.getTotal());
			ps.setDate(idx++, pedido.getFecha());
			ps.setInt(idx++, pedido.getId_cliente());
			ps.setInt(idx, pedido.getId_comercial());
			return ps;
		},keyHolder);
		
		pedido.setId(keyHolder.getKey().intValue());

		log.info("Insertados {} registros.", rows);
	}
	
	@Override
	public List<Pedido> getAll() {
		

		List<Pedido> listPed = jdbcTemplate.query(
                "SELECT * FROM pedido",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                						 	rs.getDouble("total"),
                						 	rs.getDate("fecha"),
                						 	rs.getInt("id_cliente"),
                						 	rs.getInt("id_comercial")
                						 	)
				);
		
		log.info("Devueltos {} registros.", listPed.size());
		
        return listPed;
	}
	
	@Override
	public List<Pedido> getAll(int idComercial) {
		

		List<Pedido> listPed = jdbcTemplate.query(
                "SELECT P.* FROM pedido P inner join cliente C on P.id_cliente = C.id WHERE P.id_comercial = ?",
                (rs, rowNum) -> new Pedido(rs.getInt("id"),
                						 	rs.getDouble("total"),
                						 	rs.getDate("fecha"),
                						 	rs.getInt("id_cliente"),
                						 	rs.getInt("id_comercial")
                						 	),
                idComercial
				);
		
		log.info("Devueltos {} registros.", listPed.size());
		
        return listPed;
	}
	
	@Override
	public Optional<Pedido> find(int id) {
		
		Pedido ped =  jdbcTemplate
				.queryForObject("SELECT * FROM pedido WHERE id = ?"														
								, (rs, rowNum) -> new Pedido(rs.getInt("id"),
            						 						rs.getDouble("total"),
            						 						rs.getDate("fecha"),
            						 						rs.getInt("id_cliente"),
            						 						rs.getInt("id_comercial")) 
								, id
								);
		
		if (ped != null) { 
			return Optional.of(ped);}
		else { 
			log.info("Pedido no encontrado.");
			return Optional.empty(); }
        
	}
	
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
	
	@Override
	public int numPedidosComercial(long idCliente, int idComercial) {
		
		int numPedidos = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM pedido where id_comercial = ? and id_cliente = ?",
                Integer.class,
                idComercial, idCliente
				);

		log.info("El cliente tiene {} pedidos.", numPedidos);
		
		return numPedidos;

	}
	
	@Override
	public int numPedidosComercial(long idCliente, int idComercial, int numDias) {
		
		int numPedidos = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM pedido where id_comercial = ? AND id_cliente = ? AND fecha >= DATE_SUB(NOW(), INTERVAL ? DAY)",
                Integer.class,
                idComercial, idCliente, numDias
				);

		log.info("El cliente tiene {} pedidos.", numPedidos);
		
		return numPedidos;

	}
	
}