package com.jorge.pedidos.controller;

import com.jorge.pedidos.dto.ClienteDTO;
import com.jorge.pedidos.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
@Slf4j
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping
    public ClienteDTO crearCliente (@RequestBody ClienteDTO dto){
        return this.clienteService.crearCliente(dto);
    }

    @GetMapping("/listarClientes")
    public List<ClienteDTO> listarCliente (){
        return this.clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO obtenerCliente (@PathVariable Long id){
        return this.clienteService.obtenerCliente(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCliente (@PathVariable Long id){
        this.clienteService.eliminarCliente(id);
    }

}
