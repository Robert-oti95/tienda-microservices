package com.tienda.inventario_services.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.tienda.inventario_services.entity.Inventario;
import com.tienda.inventario_services.modelo.InventarioResponse;
import com.tienda.inventario_services.service.InventarioService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService service;

    public InventarioController(InventarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Inventario> listar() {
        return service.listar();
    }

    @GetMapping("/{idInventario}")
    public Inventario buscar(@PathVariable Long idInventario) {
        return service.buscar(idInventario);
    }

    @GetMapping("/producto/{idProducto}")
    public InventarioResponse buscarPorProducto(@PathVariable Long idProducto) {
        return service.buscarPorProducto(idProducto);
    }

    @PostMapping
    public Inventario guardar(@RequestBody Inventario inventario) {
        return service.guardar(inventario);
    }

    @PutMapping("/{idInventario}")
    public Inventario actualizar(@PathVariable Long idInventario,
                                 @RequestBody Inventario inventario) {

        return service.actualizar(idInventario, inventario);

    }

    @DeleteMapping("/{idInventario}")
    public void eliminar(@PathVariable Long idInventario) {
        service.eliminar(idInventario);
    }

}