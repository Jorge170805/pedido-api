package com.jorge.pedidos.service;

import com.jorge.pedidos.dto.PedidoItemDTO;

import java.util.List;

public interface PedidoItemService {
    List<PedidoItemDTO> obtenerPedidosItems (Long pedidoId);
}
