package com.tienda.inventario_services.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.inventario_services.cliente.ProductoClient;
import com.tienda.inventario_services.entity.Inventario;
import com.tienda.inventario_services.modelo.InventarioResponse;
import com.tienda.inventario_services.modelo.ProductoResponse;
import com.tienda.inventario_services.repository.InventarioRepository;

@Service
public class InventarioService {

    private final InventarioRepository repository;
    private final ProductoClient productoClient;

    public InventarioService(InventarioRepository repository,
                             ProductoClient productoClient) {

        this.repository = repository;
        this.productoClient = productoClient;
    }

    public List<Inventario> listar() {
        return repository.findAll();
    }

    public Inventario buscar(Long idProducto) {
        return repository.findByIdProducto(idProducto).orElse(null);
    }

    public InventarioResponse buscarPorProducto(Long idProducto) {

        Inventario inventario = repository.findByIdProducto(idProducto)
                .orElse(null);

        if (inventario == null) {
            return null;
        }

        ProductoResponse producto =
                productoClient.obtenerProducto(idProducto);

        InventarioResponse response = new InventarioResponse();

        response.setIdInventario(inventario.getIdInventario());
        response.setStock(inventario.getStock());
        response.setProducto(producto);

        return response;
    }

    public Inventario guardar(Inventario inventario) {

        ProductoResponse producto =
                productoClient.obtenerProducto(inventario.getIdProducto());

        if (producto == null) {
            throw new RuntimeException("El producto no existe.");
        }

        return repository.save(inventario);
    }

    public Inventario actualizar(Long idInventario, Inventario inventario) {

        Inventario existente = repository.findById(idInventario).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setIdProducto(inventario.getIdProducto());
        existente.setStock(inventario.getStock());

        return repository.save(existente);

    }

    public void eliminar(Long idInventario) {
        repository.deleteById(idInventario);
    }

}