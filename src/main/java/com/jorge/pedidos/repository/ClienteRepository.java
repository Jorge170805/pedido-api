package com.jorge.pedidos.repository;

import com.jorge.pedidos.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Long> {

}
