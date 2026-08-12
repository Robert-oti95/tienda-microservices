package com.tienda.inventario_services.cliente;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tienda.inventario_services.modelo.ProductoResponse;

@Component
public class ProductoClient {

    private final RestTemplate restTemplate;

    @Value("${producto.service.url}")
    private String productoServiceUrl;

    public ProductoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public ProductoResponse obtenerProducto(Long idProducto) {

        String url = productoServiceUrl + "/producto/" + idProducto;

        return restTemplate.getForObject(url, ProductoResponse.class);

    /*  String url = "http://localhost:8080/producto/" + idProducto;
        return restTemplate.getForObject(url, ProductoResponse.class); */
        
    }
}