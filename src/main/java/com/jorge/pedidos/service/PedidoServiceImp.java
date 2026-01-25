package com.jorge.pedidos.service;

import com.jorge.pedidos.dto.PedidoDTO;
import com.jorge.pedidos.dto.PedidoItemDTO;
import com.jorge.pedidos.dto.request.AgregarProductoPedidoRequest;
import com.jorge.pedidos.mapper.PedidoMapper;
import com.jorge.pedidos.model.*;
import com.jorge.pedidos.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@Slf4j
public class PedidoServiceImp implements PedidoService {

    private static final Long ID_ESTADO_PEDIDO_CREADO = 1L;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Autowired
    private PedidoMapper pedidoMapper;


    @Override
    @Transactional
    public PedidoDTO crearPedido(Long idCliente) {
        log.info("inicio crearPedido");

        PedidoEntity pedido = new PedidoEntity();

        EstadoEntity estadoCreado = this.estadoRepository.getReferenceById(ID_ESTADO_PEDIDO_CREADO);
        pedido.setEstado(estadoCreado);

        ClienteEntity cliente = this.clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException("Cliente con el id " + idCliente + " no se encuentra en la base de datos"));
        pedido.setCliente(cliente);

        this.pedidoRepository.save(pedido);

        PedidoDTO pedidoDTO = this.pedidoMapper.entityToDto(pedido);
        log.info("fin crearPedido");
        return pedidoDTO;
    }

    @Override
    @Transactional
    public PedidoDTO agregarProducto(AgregarProductoPedidoRequest appr) {
        if(appr.getCantidad() < 0) {
            throw new RuntimeException("La cantidad no puede ser 0");
        }

        PedidoEntity pedido = this.pedidoRepository.findById(appr.getIdPedido()).orElseThrow(() -> new RuntimeException("No existe el pedido con el id " + appr.getIdPedido()));
        if(!pedido.getEstado().getId().equals(ID_ESTADO_PEDIDO_CREADO)){
            throw new RuntimeException("No se puede modificar un pedido confirmado o cancelado");
        }
        ProductoEntity producto = this.productoRepository.findById(appr.getIdProducto()).orElseThrow(() -> new RuntimeException("No existe el producto con el id " + appr.getIdProducto()));

        PedidoItemEntity pedidoItem = this.getPedidoItemEntity(appr.getIdPedido(), appr.getIdProducto());

        if(pedidoItem != null){
            // Actualizar
            System.out.println("Actualizar");
            Integer cantidadAntigua = pedidoItem.getCantidad();
            Double precioUnitarioAntiguo = pedidoItem.getPrecioUnitario();
            pedidoItem.setCantidad(cantidadAntigua + appr.getCantidad());
            pedidoItem.setPrecioUnitario(producto.getPrecio());

            pedido.setTotal(pedido.getTotal() - cantidadAntigua * precioUnitarioAntiguo + pedidoItem.getCantidad() * pedidoItem.getPrecioUnitario());
        }else{
            // Crear
            System.out.println("Crear");
            pedidoItem = new PedidoItemEntity();
            pedidoItem.setPedido(pedido);
            pedidoItem.setProducto(producto);
            pedidoItem.setCantidad(appr.getCantidad());
            pedidoItem.setPrecioUnitario(producto.getPrecio());
            this.pedidoItemRepository.save(pedidoItem);

            pedido.setTotal(pedido.getTotal() + pedidoItem.getCantidad() * pedidoItem.getPrecioUnitario());
        }
        return this.pedidoMapper.entityToDto(pedido);
    }

    private PedidoItemEntity getPedidoItemEntity(Long idPedido, Long idProducto) {
        PedidoItemEntity pedidoItem = null;
        List<PedidoItemEntity> lstPedidoItem = this.pedidoItemRepository.findByPedidoId(idPedido);
        for (PedidoItemEntity pi : lstPedidoItem){
            if(pi.getProducto().getId().equals(idProducto)){
                pedidoItem = pi;
                break;
            }
        }
        return pedidoItem;
    }

}
