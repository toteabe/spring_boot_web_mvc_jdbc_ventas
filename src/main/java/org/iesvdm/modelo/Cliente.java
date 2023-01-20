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
	@Size(max=30, message = "{error.cliente.nombre.size}")
	private String nombre;
	
	@NotBlank(message = "Por favor, introduzca el primer apellido.")
	@Size(max=30, message = "Apellido como máximo de 30 caracteres.")
	private String apellido1;
	
	private String apellido2;
	
	@NotBlank(message = "Por favor, introduzca la ciudad.")
	@Size(max=50, message = "Ciudad como máximo de 50 caracteres.")
	private String ciudad;
	
	@NotNull(message = "Por favor, introduzca la categoría.")
	@Min(value=100, message ="Categoría como mínimo 100")
	@Max(value=1000, message = "Categoría como máximo de 1000.")
	private int categoria;
	
	private String fotoPerfil;
	
	@Email(message = "Formato de email incorrecto", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	private String correo;
	
}
