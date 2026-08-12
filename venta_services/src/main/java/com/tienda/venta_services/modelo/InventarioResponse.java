package com.tienda.venta_services.modelo;

public class InventarioResponse {

    private Long idInventario;
    private Long idProducto;
    private Integer stock;
    
    public Long getIdInventario() {
        return idInventario;
    }
    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }
    public Long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    

    

}