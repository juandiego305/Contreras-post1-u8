package com.example.cleanpedidos.domain.valueobject;

import java.util.UUID;

public class PedidoId {
    private final String valor;

    public PedidoId(String valor) {
        if (valor == null || valor.isBlank())
            throw new IllegalArgumentException("PedidoId no puede ser vacío");
        this.valor = valor;
    }

    public static PedidoId nuevo() {
        return new PedidoId(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoId)) return false;
        PedidoId pedidoId = (PedidoId) o;
        return valor.equals(pedidoId.valor);
    }

    @Override
    public int hashCode() {
        return valor.hashCode();
    }
}
