package com.jorge.pedidos.dto.request;

import lombok.Data;

@Data
public class AgregarProductoPedidoRequest {
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
}
