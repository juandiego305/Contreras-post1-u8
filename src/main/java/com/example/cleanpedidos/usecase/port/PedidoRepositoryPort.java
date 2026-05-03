package com.example.cleanpedidos.usecase.port;

import com.example.cleanpedidos.domain.entity.Pedido;
import com.example.cleanpedidos.domain.valueobject.PedidoId;

public interface PedidoRepositoryPort {
    void guardar(Pedido pedido);
    Pedido obtenerPorId(PedidoId id);
}
