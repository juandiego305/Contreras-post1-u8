package com.example.cleanpedidos.adapter.in.web.dto;

import com.example.cleanpedidos.domain.valueobject.PedidoId;
import com.example.cleanpedidos.usecase.CrearPedidoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final CrearPedidoUseCase crearUseCase;

    public PedidoController(CrearPedidoUseCase crearUseCase) {
        this.crearUseCase = crearUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> crear(@RequestBody CrearPedidoRequest req) {
        PedidoId id = crearUseCase.ejecutar(req.clienteNombre(), req.lineas());
        return Map.of("pedidoId", id.toString());
    }
}