package com.tienda.venta_services.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_det_venta")
    private Long idDetVenta;
    @Column(name = "id_venta")
    private Long idVenta;
    @Column(name = "id_producto")
    private Long idProducto;

    private Integer cantidad;

    private Double precio;

    public DetalleVenta() {
    }

    public DetalleVenta(Long idDetVenta, Long idVenta, Long idProducto, Integer cantidad, Double precio) {
        this.idDetVenta = idDetVenta;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getIdDetVenta() {
        return idDetVenta;
    }

    public void setIdDetVenta(Long idDetVenta) {
        this.idDetVenta = idDetVenta;
    }

    

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    

    

    
    
}