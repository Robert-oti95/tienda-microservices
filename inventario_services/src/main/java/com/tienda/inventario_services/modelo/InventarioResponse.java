package com.tienda.inventario_services.modelo;

public class InventarioResponse {
    private Long idInventario;
    private Integer stock;
    private ProductoResponse producto;
    
    public Long getIdInventario() {
        return idInventario;
    }
    public void setIdInventario(Long idInventario) {
        this.idInventario = idInventario;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public ProductoResponse getProducto() {
        return producto;
    }
    public void setProducto(ProductoResponse producto) {
        this.producto = producto;
    }
    
    
   
}
