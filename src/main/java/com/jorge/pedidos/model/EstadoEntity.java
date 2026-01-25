package com.jorge.pedidos.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "estado")
@Data
public class EstadoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
}
