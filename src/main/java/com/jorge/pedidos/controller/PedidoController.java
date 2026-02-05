package com.jorge.pedidos.controller;

import com.jorge.pedidos.dto.PedidoDTO;
import com.jorge.pedidos.dto.PedidoDetalleDTO;
import com.jorge.pedidos.dto.request.AgregarProductoPedidoDTO;
import com.jorge.pedidos.dto.request.EliminarProductoPedidoDTO;
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
    public PedidoDTO agregarProducto(@RequestBody AgregarProductoPedidoDTO dto) {
        return this.pedidoService.agregarProducto(dto);
    }

    @PostMapping("/confirmar/{idPedido}")
    public PedidoDTO confirmarPedido (@PathVariable Long idPedido) {
        return this.pedidoService.confirmarPedido(idPedido);
    }

    @GetMapping("/{idPedido}")
    public PedidoDetalleDTO obtenerDetallePedido (@PathVariable Long idPedido) {
        return this.pedidoService.obtenerDetallePedido(idPedido);
    }

    @PostMapping("/cancelar/{idPedido}")
    public PedidoDTO cancelarPedido (@PathVariable Long idPedido){
        return this.pedidoService.cancelarPedido(idPedido);
    }

    @DeleteMapping
    public PedidoDTO eliminarProducto (@RequestBody EliminarProductoPedidoDTO dto){
        return this.pedidoService.eliminarProducto(dto);
    }
}
