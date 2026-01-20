package com.jorge.pedidos.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    @Column
    private String email;
}
