package org.iesvdm.mapstruct;

import org.iesvdm.modelo.Comercial;
import org.iesvdm.modelo.Pedido;

import java.util.List;

import org.iesvdm.dto.ComercialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComercialMapper {

	@Mapping(target = "listaPedidos", source = "listaPedidosIn")
	public ComercialDTO comercialAComercialDTO(Comercial comercial, List<Pedido> listaPedidosIn);
	
	public Comercial comercialDTOAComercial(ComercialDTO comercial);
	
}
