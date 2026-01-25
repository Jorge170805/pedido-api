package com.jorge.pedidos.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
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
