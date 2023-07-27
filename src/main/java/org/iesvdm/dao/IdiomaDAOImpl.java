package org.iesvdm.dao;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.iesvdm.modelo.Idioma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class IdiomaDAOImpl implements IdiomaDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Idioma> getAll() {
		

		List<Idioma> listidi = jdbcTemplate.query(
                "SELECT * FROM idioma",
                (rs, rowNum) -> new Idioma(rs.getInt("id_idioma"),
                						 	rs.getString("nombre")
                						 	)
				);
		
		log.info("Devueltos {} registros.", listidi.size());
		
        return listidi;
	}
	
	
}