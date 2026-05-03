package com.example.cleanpedidos.domain.valueobject;

public class LineaPedido {
    private final String producto;
    private final int cantidad;
    private final Dinero precio;

    public LineaPedido(String producto, int cantidad, Dinero precio) {
        if (producto == null || producto.isBlank())
            throw new IllegalArgumentException("Producto no puede ser vacío");
        if (cantidad <= 0)
            throw new IllegalArgumentException("Cantidad debe ser mayor a cero");
        if (precio == null)
            throw new IllegalArgumentException("Precio no puede ser nulo");
        
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Dinero subtotal() {
        return precio.multiplicar(cantidad);
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Dinero getPrecio() {
        return precio;
    }
}
