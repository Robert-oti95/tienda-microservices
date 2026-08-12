package com.tienda.venta_services.modelo;

public class VentaRequest {

    private Long idProducto;

    private Integer cantidad;

   

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    

    // getters y setters

}