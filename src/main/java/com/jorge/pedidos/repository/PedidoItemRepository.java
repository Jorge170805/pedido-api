package com.jorge.pedidos.repository;

import com.jorge.pedidos.model.PedidoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItemEntity, Long> {

}
