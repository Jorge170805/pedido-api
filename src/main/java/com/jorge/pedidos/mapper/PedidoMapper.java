package com.jorge.pedidos.mapper;

import com.jorge.pedidos.dto.PedidoDTO;
import com.jorge.pedidos.model.PedidoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class, ClienteMapper.class})
public interface PedidoMapper {
    public PedidoDTO entityToDto (PedidoEntity pedido);

    public PedidoEntity dtoToEntity (PedidoDTO pedido);
}
