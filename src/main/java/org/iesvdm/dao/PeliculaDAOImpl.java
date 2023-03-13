package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PeliculaDAOImpl implements PeliculaDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override	
	public synchronized void create(Pelicula pelicula) {
		
							//Desde java15+ se tiene la triple quote """ para bloques de texto como cadenas.
		String sqlInsert = """
							INSERT INTO pelicula (titulo, descripcion, anyo_lanzamiento, id_idioma, id_idioma_original, duracion_alquiler, rental_rate, duracion, replacement_cost, clasificacion, caracteristicas_especiales) 
							VALUES  (     ?,         ?,         ?,       ?,		?,		?,		?,		?,		?,		?,		?)
						   """;
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		//Con recuperación de id generado
		int rows = jdbcTemplate.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(sqlInsert, new String[] { "id" });
			int idx = 1;
			ps.setString(idx++, pelicula.getTitulo());
			ps.setString(idx++, pelicula.getDescripcion());
			ps.setInt(idx++, pelicula.getAnyo_lanzamiento());
			ps.setInt(idx++, pelicula.getId_idioma());
			ps.setInt(idx++, pelicula.getId_idioma_original());
			ps.setInt(idx++, pelicula.getDuracion_alquiler());
			ps.setDouble(idx++, pelicula.getRental_rate());
			ps.setInt(idx++, pelicula.getDuracion());
			ps.setDouble(idx++, pelicula.getReplacement_cost());
			ps.setString(idx++, pelicula.getClasificacion());
			ps.setString(idx, pelicula.getCaracteristicas_especiales());
			return ps;
		},keyHolder);
		
		pelicula.setId_pelicula(keyHolder.getKey().intValue());

		log.info("Insertados {} registros.", rows);
	}
	
	@Override
	public List<Pelicula> getAll() {
		

		List<Pelicula> listPel = jdbcTemplate.query(
                "SELECT * FROM pelicula",
                (rs, rowNum) -> new Pelicula(rs.getInt("id_pelicula"),
                						 	rs.getString("titulo"),
                						 	rs.getString("descripcion"),
                						 	rs.getInt("anyo_lanzamiento"),
                						 	rs.getInt("id_idioma"),
                						 	rs.getInt("id_idioma_original"),
                						 	rs.getInt("duracion_alquiler"),
                						 	rs.getDouble("rental_rate"),
                						 	rs.getInt("duracion"),
                						 	rs.getDouble("replacement_cost"),
                						 	rs.getString("clasificacion"),
                						 	rs.getString("caracteristicas_especiales")
                						 	)
				);
		
		log.info("Devueltos {} registros.", listPel.size());
		
        return listPel;
	}
	
}