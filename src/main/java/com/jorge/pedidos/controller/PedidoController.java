package com.jorge.pedidos.controller;

import com.jorge.pedidos.dto.PedidoDTO;
import com.jorge.pedidos.dto.request.AgregarProductoPedidoRequest;
import com.jorge.pedidos.service.PedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedido")
@Slf4j
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @PostMapping("/{idCliente}")
    public PedidoDTO crearPedido (@PathVariable Long idCliente){
        return this.pedidoService.crearPedido(idCliente);
    }

    @PostMapping
    public PedidoDTO agregarProducto(@RequestBody AgregarProductoPedidoRequest appr) {
        return this.pedidoService.agregarProducto(appr);
    }
}
