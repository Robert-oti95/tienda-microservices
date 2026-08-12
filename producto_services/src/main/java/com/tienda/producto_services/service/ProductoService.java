package com.tienda.producto_services.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.producto_services.entity.Producto;
import com.tienda.producto_services.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Producto buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Producto actualizar(Long id, Producto producto) {

        Producto p = repository.findById(id).orElse(null);

        if (p != null) {
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());

            return repository.save(p);
        }

        return null;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
