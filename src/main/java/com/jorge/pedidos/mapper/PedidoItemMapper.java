package com.jorge.pedidos.mapper;

import com.jorge.pedidos.dto.PedidoItemDTO;
import com.jorge.pedidos.dto.PedidoItemDetalleDTO;
import com.jorge.pedidos.model.PedidoItemEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoItemMapper {
    public List<PedidoItemDTO> listEntityToListDto (List<PedidoItemEntity> pedido);

    public List<PedidoItemEntity> listDtoToListEntity (List<PedidoItemDTO> pedido);

    public List<PedidoItemDetalleDTO> listEntityToListDetalleDto (List<PedidoItemEntity> pedido);



}
