package com.jorge.pedidos.mapper;

import com.jorge.pedidos.dto.PedidoDTO;
import com.jorge.pedidos.dto.PedidoDetalleDTO;
import com.jorge.pedidos.model.PedidoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class, ClienteMapper.class})
public interface PedidoMapper {
    public PedidoDTO entityToDto (PedidoEntity pedido);

    public PedidoEntity dtoToEntity (PedidoDTO pedido);

    public PedidoDetalleDTO entityToDetalleDto (PedidoEntity pedido);
}
