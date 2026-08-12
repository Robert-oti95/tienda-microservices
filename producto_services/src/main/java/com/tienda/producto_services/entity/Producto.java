package com.tienda.producto_services.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;

    private String nombre;

    private Double precio;

    public Producto() {
    }

    public Producto(Long id, String nombre, Double precio) {
        this.id_producto = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id_producto;
    }

    public void setId(Long id) {
        this.id_producto = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    // Getters y Setters

}