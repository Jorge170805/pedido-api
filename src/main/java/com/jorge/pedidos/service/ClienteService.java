package com.jorge.pedidos.service;

import com.jorge.pedidos.dto.ClienteDTO;


import java.util.List;

public interface ClienteService {

    ClienteDTO crearCliente(ClienteDTO request);

    List<ClienteDTO> listarClientes();

    ClienteDTO obtenerCliente(Long id);

    void eliminarCliente(Long id);
}
