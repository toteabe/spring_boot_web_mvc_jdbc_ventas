package org.iesvdm.modelo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pedido {

	public Pedido() {
	}
	
	private int id;
	private double total;
	private Date fecha;
	private int id_cliente;
	private int id_comercial;
}