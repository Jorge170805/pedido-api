package com.jorge.pedidos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PedidoItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fid_producto")
    private ProductoEntity producto;
    @Column
    private Integer cantidad;
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    @ManyToOne
    @JoinColumn(name = "fid_pedido")
    private PedidoEntity pedido;
}
