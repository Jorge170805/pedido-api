package com.jorge.pedidos.repository;

import com.jorge.pedidos.model.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

}
