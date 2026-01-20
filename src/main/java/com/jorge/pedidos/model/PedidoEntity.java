package com.jorge.pedidos.model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;
    @Column
    private EstadoEnum estado;
    @ManyToOne
    @JoinColumn(name = "fid_cliente")
    private ClienteEntity cliente;
    @Column
    private Double total;
}
