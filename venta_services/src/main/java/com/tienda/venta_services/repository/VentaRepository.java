package com.tienda.venta_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.venta_services.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}