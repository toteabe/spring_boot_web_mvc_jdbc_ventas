package org.iesvdm.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PedidoDTO {

	public PedidoDTO() {
	}
	
	private int id;
	private double total;
	private Date fecha;
	private int id_cliente;
	private int id_comercial;
	private String nombreCliente;
}
