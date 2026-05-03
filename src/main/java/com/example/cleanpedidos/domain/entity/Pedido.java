package com.example.cleanpedidos.domain.entity;

import com.example.cleanpedidos.domain.valueobject.*;
import java.util.*;

public class Pedido {
    private final PedidoId id;
    private final String clienteNombre;
    private final List<LineaPedido> lineas = new ArrayList<>();
    private EstadoPedido estado = EstadoPedido.BORRADOR;

    public Pedido(PedidoId id, String clienteNombre) {
        this.id = Objects.requireNonNull(id);
        if (clienteNombre == null || clienteNombre.isBlank())
            throw new IllegalArgumentException("El cliente es obligatorio");
        this.clienteNombre = clienteNombre;
    }

    public void agregarLinea(String producto, int cantidad, Dinero precio) {
        if (estado != EstadoPedido.BORRADOR)
            throw new IllegalStateException("Solo se agregan lineas en BORRADOR");
        if (cantidad <= 0)
            throw new IllegalArgumentException("Cantidad debe ser mayor a cero");
        lineas.add(new LineaPedido(producto, cantidad, precio));
    }

    public void confirmar() {
        if (lineas.isEmpty())
            throw new IllegalStateException("No se puede confirmar un pedido sin lineas");
        this.estado = EstadoPedido.CONFIRMADO;
    }

    public Dinero calcularTotal() {
        return lineas.stream().map(LineaPedido::subtotal)
                .reduce(Dinero.CERO, Dinero::sumar);
    }

    public PedidoId getId() {
        return id;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public List<LineaPedido> getLineas() {
        return new ArrayList<>(lineas);
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}