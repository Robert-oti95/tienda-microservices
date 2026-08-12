package com.tienda.inventario_services.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.inventario_services.entity.Inventario;


public interface InventarioRepository extends JpaRepository<Inventario, Long>{

    Optional <Inventario> findByIdProducto(Long idProducto);

}