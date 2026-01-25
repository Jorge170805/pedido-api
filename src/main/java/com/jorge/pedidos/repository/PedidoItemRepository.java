package com.jorge.pedidos.repository;

import com.jorge.pedidos.model.PedidoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoItemRepository extends JpaRepository<PedidoItemEntity, Long> {


    List<PedidoItemEntity> findByPedido_IdOrderByCantidadDesc (Long id);


    @Query(value =  "SELECT e " +
                    "FROM PedidoItemEntity e " +
                    "WHERE e.pedido.id = :id " +
                    "ORDER BY e.cantidad desc",
    nativeQuery = false)
    List<PedidoItemEntity> findByPedidoId (Long id);

    @Query(value =  "SELECT e.* " +
                    "FROM pedido_item e " +
                    "WHERE e.fid_pedido = :id " +
                    "ORDER BY e.cantidad desc",
            nativeQuery = true)
    List<PedidoItemEntity> findByPedidoIdSQL (Long id);

}
