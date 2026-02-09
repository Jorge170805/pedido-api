package com.jorge.pedidos.scheduler;

import java.time.LocalDateTime;
import java.util.List;

import com.jorge.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jorge.pedidos.model.PedidoEntity;
import com.jorge.pedidos.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PedidoScheduler {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @Value("${pedido.confirmado.caducidad.minutos}")
    private long minutosCaducidad;

    /**
     * Se ejecuta todos los días a la 1:00 AM
     */
    @Scheduled(cron = "0 0 1 * * ?")
    @Transactional
    public void cancelarPedidosCreadosCaducados() {

        log.info("Inicio scheduler cancelarPedidosCreadosCaducados");

        LocalDateTime fechaLimite = LocalDateTime.now().minusMinutes(minutosCaducidad);

        List<PedidoEntity> pedidosCaducados = pedidoRepository.findPedidosCreadosAntesDe(fechaLimite);

        for (PedidoEntity pedido : pedidosCaducados) {
            this.pedidoService.cancelarPedido(pedido.getId());
            log.info("Pedido {} cancelado por caducidad", pedido.getId());
        }

        log.info("Fin scheduler cancelarPedidosCreadosCaducados");
    }
}