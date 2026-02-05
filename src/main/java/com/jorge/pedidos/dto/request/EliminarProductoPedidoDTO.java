package com.jorge.pedidos.dto.request;

import lombok.Data;

@Data
public class EliminarProductoPedidoDTO {
    private Long idPedido;
    private Long idProducto;


}
