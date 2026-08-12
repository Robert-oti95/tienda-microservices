package com.tienda.producto_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.producto_services.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long>{
    
}
