package com.jorge.pedidos.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
@Data
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_confirmacion")
    private LocalDateTime fechaConfirmacion;

    @ManyToOne
    @JoinColumn(name = "fid_estado")
    private EstadoEntity estado;

    @ManyToOne
    @JoinColumn(name = "fid_cliente")
    private ClienteEntity cliente;

    @Column
    private Double total = 0.0;
}
