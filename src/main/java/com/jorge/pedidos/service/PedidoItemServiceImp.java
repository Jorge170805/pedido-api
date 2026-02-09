package com.jorge.pedidos.service;

import com.jorge.pedidos.dto.PedidoItemDTO;
import com.jorge.pedidos.mapper.PedidoItemMapper;
import com.jorge.pedidos.model.PedidoItemEntity;
import com.jorge.pedidos.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoItemServiceImp implements PedidoItemService {

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Autowired
    private PedidoItemMapper pedidoItemMapper;

    @Override
    public List<PedidoItemDTO> obtenerPedidosItems(Long pedidoId) {

        List<PedidoItemEntity> pedidoItemEntities = this.pedidoItemRepository.findByPedido_IdOrderByCantidadDesc(pedidoId);
        List<PedidoItemDTO> pedidoItemDTOS = this.pedidoItemMapper.listEntityToListDto(pedidoItemEntities);
        return pedidoItemDTOS;
    }
}
