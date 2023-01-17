package org.iesvdm.mapstruct;

import org.iesvdm.modelo.Comercial;

import org.iesvdm.dto.ComercialDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComercialMapper {

	@Mapping(target = "numPedidosTotal", source = "numPedidosTotalIn")
	@Mapping(target = "numPedidosTrimestre", source = "numPedidosTrimestreIn")
	@Mapping(target = "numPedidosSemestre", source = "numPedidosSemestreIn")
	@Mapping(target = "numPedidosAnio", source = "numPedidosAnioIn")
	@Mapping(target = "numPedidosLustro", source = "numPedidosLustroIn")
	public ComercialDTO comercialAComercialDTO(Comercial comercial, int numPedidosTotalIn, int numPedidosTrimestreIn, int numPedidosSemestreIn, int numPedidosAnioIn, int numPedidosLustroIn);
	
	public Comercial comercialDTOAComercial(ComercialDTO comercial);
	
}
