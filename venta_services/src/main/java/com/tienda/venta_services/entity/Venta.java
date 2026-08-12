package com.tienda.venta_services.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;

    private LocalDateTime fecha;

    private Double total;

    public Venta() {
    }

    public Venta(Long idVenta, LocalDateTime fecha, Double total) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.total = total;
    }


    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    

    
}