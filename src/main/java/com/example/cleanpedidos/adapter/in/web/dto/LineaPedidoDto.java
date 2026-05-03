package com.example.cleanpedidos.adapter.in.web.dto;

public record LineaPedidoDto(
    String productoNombre,
    int cantidad,
    double precioUnitario
) {}
