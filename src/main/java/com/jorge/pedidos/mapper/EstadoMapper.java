package com.jorge.pedidos.mapper;

import com.jorge.pedidos.dto.EstadoDTO;
import com.jorge.pedidos.model.EstadoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoMapper {
    public EstadoDTO entityToDto (EstadoEntity estado);

    public EstadoEntity dtoToEntity (EstadoDTO estado);
}
