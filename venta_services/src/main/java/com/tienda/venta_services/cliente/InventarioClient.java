package com.tienda.venta_services.cliente;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tienda.venta_services.modelo.InventarioResponse;

@Component
public class InventarioClient {

    private final RestTemplate restTemplate;

    @Value("${inventario.service.url}")
    private String inventarioServiceUrl;

    public InventarioClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public InventarioResponse obtenerInventario(Long idProducto) {

        String url = inventarioServiceUrl + "/inventario/" + idProducto;

        return restTemplate.getForObject(
                url,
                InventarioResponse.class
        );
        /* return restTemplate.getForObject(
                "http://localhost:8081/inventario/producto/" + idProducto,
                InventarioResponse.class); */
    }
}