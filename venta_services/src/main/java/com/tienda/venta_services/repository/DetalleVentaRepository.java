package com.tienda.venta_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.venta_services.entity.DetalleVenta;

public interface DetalleVentaRepository
        extends JpaRepository<DetalleVenta, Long> {
}