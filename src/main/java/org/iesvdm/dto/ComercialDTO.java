package org.iesvdm.dto;

import java.text.DecimalFormat;
import java.util.List;

import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;

import lombok.AllArgsConstructor;
import lombok.Data;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

@Data
@AllArgsConstructor
@SuppressWarnings("unused")
public class ComercialDTO {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private float comision;
	private List<PedidoDTO> listaPedidosDTO;
	private static int max = 500;
	
	public ComercialDTO() {
		
	}
	
	public ComercialDTO(Comercial comercial) {
		this.id = comercial.getId();
		this.nombre = comercial.getNombre();
		this.apellido1 = comercial.getApellido1();
		this.apellido2 = comercial.getApellido2();
		this.comision = comercial.getComision();
	}
	
	public String listaPedidosTotal() {
		
		double total = 0;
		if (listaPedidosDTO.size() != 0) {
			for (PedidoDTO p : listaPedidosDTO) {
				total += p.getTotal();
			}
		}
		return df.format(total);
	}
	
	public String listaPedidosMedia() {
		
		double media = 0;
		double total = 0;
		if (listaPedidosDTO.size() != 0) {
			for (PedidoDTO p : listaPedidosDTO) {
				total += p.getTotal();
			}
			media = total / listaPedidosDTO.size();
		}
		return df.format(media);
	}

	public double max() {
		
		double max = 0;
		if (listaPedidosDTO.size() != 0) {
			max = listaPedidosDTO.get(0).getTotal();
			for (PedidoDTO p : listaPedidosDTO) {
				if (p.getTotal() > max)
					max = p.getTotal();
			}
		}
		return max;
		
	}
	
	public double min() {
		
		double min = 0;
		if (listaPedidosDTO.size() != 0) {
			min = listaPedidosDTO.get(0).getTotal();
			for (PedidoDTO p : listaPedidosDTO) {
				if (p.getTotal() < min)
					min = p.getTotal();
			}
		}
		return min;
		
	}
	
	public List<PedidoDTO> listaOrdenada() {
		
		return listaPedidosDTO.stream()
				.sorted(comparing(PedidoDTO::getTotal, reverseOrder()))
				.collect(toList());
	}
	
	
}