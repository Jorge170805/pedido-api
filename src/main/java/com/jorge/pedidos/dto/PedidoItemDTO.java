package com.jorge.pedidos.dto;

import com.jorge.pedidos.model.PedidoEntity;
import com.jorge.pedidos.model.ProductoEntity;
import lombok.Data;
@Data
public class PedidoItemDTO {
    private Long id;
    private ProductoEntity producto;
    private Integer cantidad;
    private Double precioUnitario;
    private PedidoEntity pedido;
}
