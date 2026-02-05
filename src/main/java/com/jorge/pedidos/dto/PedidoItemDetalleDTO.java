package com.jorge.pedidos.dto;

import lombok.Data;

@Data
public class PedidoItemDetalleDTO {
    private Long id;
    private ProductoDTO producto;
    private Integer cantidad;
    private Double precioUnitario;
}
