package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Categoria;
import org.iesvdm.modelo.Idioma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CategoriaDAOImpl implements CategoriaDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Optional<Categoria> find(int id) {
		
		Categoria cat =  jdbcTemplate
				.queryForObject("SELECT * FROM categoria WHERE id_categoria = ?"														
								, (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
            						 						rs.getString("nombre")) 
								, id
								);
		
		if (cat != null) { 
			return Optional.of(cat);}
		else { 
			log.info("Categoria no encontrado.");
			return Optional.empty(); }
        
	}

	@Override
	public int conteoPeliculas(int id) {
		
		int numPeliculas = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM pelicula_categoria where id_categoria = ?",
                Integer.class,
                id
				);

		log.info("El cliente tiene {} pedidos.", numPeliculas);
		
		return numPeliculas;
	}
	
	@Override
	public List<Categoria> getAll() {
		
		List<Categoria> listCat = jdbcTemplate.query(
                "SELECT * FROM categoria",
                (rs, rowNum) -> new Categoria(rs.getInt("id_categoria"),
                						 	rs.getString("nombre")
                						 	)
				);
		
		log.info("Devueltos {} registros.", listCat.size());
		
        return listCat;
	}
	
	
}