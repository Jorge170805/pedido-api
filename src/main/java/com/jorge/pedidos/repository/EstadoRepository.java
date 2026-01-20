package com.jorge.pedidos.repository;

import com.jorge.pedidos.model.EstadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoEntity,Long> {

}
