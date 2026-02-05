package com.jorge.pedidos.dto.request;

import lombok.Data;

@Data
public class AgregarProductoPedidoDTO {
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
}
