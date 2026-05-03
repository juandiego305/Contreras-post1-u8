package com.example.cleanpedidos.domain.valueobject;

import java.math.BigDecimal;

public class Dinero {
    public static final Dinero CERO = new Dinero(BigDecimal.ZERO);
    
    private final BigDecimal cantidad;

    public Dinero(BigDecimal cantidad) {
        if (cantidad == null)
            throw new IllegalArgumentException("Cantidad no puede ser nula");
        if (cantidad.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        this.cantidad = cantidad;
    }

    public Dinero(double cantidad) {
        this(BigDecimal.valueOf(cantidad));
    }

    public Dinero sumar(Dinero otro) {
        if (otro == null)
            throw new IllegalArgumentException("No se puede sumar null");
        return new Dinero(this.cantidad.add(otro.cantidad));
    }

    public Dinero multiplicar(int factor) {
        return new Dinero(this.cantidad.multiply(BigDecimal.valueOf(factor)));
    }

    @Override
    public String toString() {
        return cantidad.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinero)) return false;
        Dinero dinero = (Dinero) o;
        return cantidad.compareTo(dinero.cantidad) == 0;
    }

    @Override
    public int hashCode() {
        return cantidad.hashCode();
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }
}