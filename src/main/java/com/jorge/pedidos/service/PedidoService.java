package com.jorge.pedidos.service;

import com.jorge.pedidos.dto.PedidoDTO;
import com.jorge.pedidos.dto.request.AgregarProductoPedidoRequest;

public interface PedidoService {
    PedidoDTO crearPedido (Long idCliente);

    PedidoDTO agregarProducto (AgregarProductoPedidoRequest appr);

    PedidoDTO confirmarPedido (Long idPedido);
}
