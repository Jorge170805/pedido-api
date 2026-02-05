package com.jorge.pedidos.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoDTO {
    private Long id;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaConfirmacion;
    private EstadoDTO estado;
    private ClienteDTO cliente;
    private Double total;
}

