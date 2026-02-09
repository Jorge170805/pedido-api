package com.jorge.pedidos.mapper;

import com.jorge.pedidos.dto.ClienteDTO;
import com.jorge.pedidos.model.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    public ClienteDTO entityToDto (ClienteEntity cliente);

    public ClienteEntity dtoToEntity (ClienteDTO cliente);

    public List<ClienteDTO> listEntityToListDto (List<ClienteEntity> cliente);
}
