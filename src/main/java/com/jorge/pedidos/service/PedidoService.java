package com.jorge.pedidos.service;

import com.jorge.pedidos.dto.PedidoDTO;
import com.jorge.pedidos.dto.PedidoDetalleDTO;
import com.jorge.pedidos.dto.request.AgregarProductoPedidoDTO;
import com.jorge.pedidos.dto.request.EliminarProductoPedidoDTO;

public interface PedidoService {
    PedidoDTO crearPedido (Long idCliente);

    PedidoDTO agregarProducto (AgregarProductoPedidoDTO appr);

    PedidoDTO eliminarProducto (EliminarProductoPedidoDTO eppr);

    PedidoDTO confirmarPedido (Long idPedido);

    PedidoDetalleDTO obtenerDetallePedido(Long idPedido);

    PedidoDTO cancelarPedido (Long idPedido);


}
