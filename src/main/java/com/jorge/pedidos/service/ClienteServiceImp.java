package com.jorge.pedidos.service;

import com.jorge.pedidos.dto.ClienteDTO;
import com.jorge.pedidos.exception.NotFoundException;
import com.jorge.pedidos.mapper.ClienteMapper;
import com.jorge.pedidos.model.ClienteEntity;
import com.jorge.pedidos.repository.ClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    @Override
    public ClienteDTO crearCliente(ClienteDTO dto) {
        log.info("Creando cliente");

        ClienteEntity cliente = clienteMapper.dtoToEntity(dto);
        ClienteEntity guardado = clienteRepository.save(cliente);

        return clienteMapper.entityToDto(guardado);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        log.info("Listando clientes");
        return this.clienteMapper.listEntityToListDto(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO obtenerCliente(Long id) {
        log.info("Obteniendo cliente con id {}", id);

        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente con id " + id + " no existe"));
        return clienteMapper.entityToDto(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        log.info("Eliminando cliente con id {}", id);

        ClienteEntity cliente = clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente con id " + id + " no existe"));

        clienteRepository.delete(cliente);
    }
}
