package com.jorge.pedidos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private Double precio;
    @Column
    private Integer stock;
}
