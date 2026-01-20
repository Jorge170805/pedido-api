package com.jorge.pedidos.repository;

import com.jorge.pedidos.model.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

}
