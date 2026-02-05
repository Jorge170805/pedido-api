package com.jorge.pedidos.dto;


import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PedidoDetalleDTO {
    private Long id;
    private EstadoDTO estado;
    private LocalDateTime fechaCreacion;
    private Double total;
    private ClienteDTO cliente;
    private List<PedidoItemDetalleDTO> items;

}

