package com.tienda.venta_services.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.venta_services.entity.Venta;
import com.tienda.venta_services.modelo.VentaRequest;
import com.tienda.venta_services.service.VentaService;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService service;

    public VentaController(VentaService service) {
        this.service = service;
    }

    @PostMapping
    public Venta registrar(@RequestBody VentaRequest request) {

        return service.registrarVenta(request);

    }

    @GetMapping
    public List<Venta> listar() {

        return service.listar();

    }
}