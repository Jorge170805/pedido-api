package com.jorge.pedidos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class EstadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
}
