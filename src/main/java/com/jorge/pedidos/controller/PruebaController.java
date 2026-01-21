package com.jorge.pedidos.controller;

import com.jorge.pedidos.dto.ClienteDTO;
import com.jorge.pedidos.model.ClienteEntity;
import com.jorge.pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prueba")
public class PruebaController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    public ClienteDTO findById (@PathVariable Long id){
        ClienteEntity clienteEntity = this.clienteRepository.findById(id).get();
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clienteEntity.getId());
        clienteDTO.setNombre(clienteEntity.getNombre());
        clienteDTO.setEmail(clienteEntity.getEmail());
        return clienteDTO;
    }
}
