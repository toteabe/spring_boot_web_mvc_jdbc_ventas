package org.iesvdm.modelo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
//La anotación @Data de lombok proporcionará el código de: 
//getters/setters, toString, equals y hashCode
//propio de los objetos POJOS o tipo Beans
@Data
//Para generar un constructor con lombok con todos los args
@AllArgsConstructor
public class Cliente {
	
	public Cliente() {
	}
	
	private int id;
	
	@NotBlank(message = "{error.cliente.nombre.notBlank}")
	@Size(max=30, message = "{error.cliente.nombre.max}")
	private String nombre;
	
	@NotBlank(message = "{error.cliente.apellido1.notBlank}")
	@Size(max=30, message = "{error.cliente.apellido1.max}")
	private String apellido1;
	
	private String apellido2;
	
	@NotBlank(message = "{error.cliente.ciudad.notBlank}")
	@Size(max=50, message = "{error.cliente.ciudad.max}")
	private String ciudad;
	
	@NotNull(message = "{error.cliente.categoria.notNull}")
	@Min(value=100, message = "{error.cliente.categoria.min}")
	@Max(value=1000, message = "{error.cliente.categoria.max}")
	private int categoria;
	
	private String fotoPerfil;
	
	@Email(message = "{error.cliente.correo.formato}", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	private String correo;
	
}
