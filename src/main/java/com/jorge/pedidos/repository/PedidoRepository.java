package com.jorge.pedidos.repository;

import com.jorge.pedidos.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
    @Query("SELECT p FROM PedidoEntity p WHERE p.estado.nombre = 'CREADO' AND p.fechaCreacion < :fecha")
    List<PedidoEntity> findPedidosCreadosAntesDe(LocalDateTime fecha);
}
