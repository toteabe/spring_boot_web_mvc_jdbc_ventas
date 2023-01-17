package org.iesvdm.dto;

import java.util.List;

import org.iesvdm.modelo.Pedido;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComercialDTO {

private int id;

	public ComercialDTO() {
		
	}

	private String nombre;
	private String apellido1;
	private String apellido2;
	private float comision;
	private List<Pedido> listaPedidos;
}
