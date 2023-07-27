package org.iesvdm.modelo;

import java.sql.Date;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pelicula {

	public Pelicula() {
	}
	
	private int id_pelicula;
	
	@NotBlank(message = "{error.pelicula.titulo.notBlank}")
	@Size(min=3, message = "{error.pelicula.titulo.min}")
	private String titulo;
	
	@Size(max=300, message = "{error.pelicula.descripcion.max}")
	private String descripcion;
	
	private int anyo_lanzamiento;
	
	private int id_idioma;
	
	private int id_idioma_original;
	
	private int duracion_alquiler;
	
	@DecimalMin(value= "1.0", message = "{error.pelicula.rental_rate.min}")
	private double rental_rate;
	
	@Min(value= 1, message = "{error.pelicula.duracion.min}")
	private int duracion;
	
	@DecimalMin(value= "19.99", message = "{error.pelicula.replacement_cost.min}")
	private double replacement_cost;
	
	private String clasificacion; //ENUM
	
	private String caracteristicas_especiales; //ENUM
}
