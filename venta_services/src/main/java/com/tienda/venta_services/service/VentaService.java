package com.tienda.venta_services.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tienda.venta_services.cliente.InventarioClient;
import com.tienda.venta_services.cliente.ProductoClient;
import com.tienda.venta_services.entity.DetalleVenta;
import com.tienda.venta_services.entity.Venta;
import com.tienda.venta_services.modelo.InventarioResponse;
import com.tienda.venta_services.modelo.ProductoResponse;
import com.tienda.venta_services.modelo.VentaRequest;
import com.tienda.venta_services.repository.DetalleVentaRepository;
import com.tienda.venta_services.repository.VentaRepository;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final DetalleVentaRepository detalleRepository;
    private final ProductoClient productoClient;
    private final InventarioClient inventarioClient;

    public VentaService(VentaRepository ventaRepository,
                        DetalleVentaRepository detalleRepository,
                        ProductoClient productoClient,
                        InventarioClient inventarioClient) {

        this.ventaRepository = ventaRepository;
        this.detalleRepository = detalleRepository;
        this.productoClient = productoClient;
        this.inventarioClient = inventarioClient;
    }

    public List<Venta> listar() {
        return ventaRepository.findAll();
    }

    public Venta buscar(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Venta registrarVenta(VentaRequest request) {

        // 1. Consultar producto
        ProductoResponse producto =
                productoClient.obtenerProducto(request.getIdProducto());

        if (producto == null) {
            throw new RuntimeException("Producto no encontrado.");
        }

        // 2. Consultar inventario
        InventarioResponse inventario =
                inventarioClient.obtenerInventario(request.getIdProducto());

        if (inventario == null) {
            throw new RuntimeException("Inventario no encontrado.");
        }

        // 3. Validar stock
        if (inventario.getStock() < request.getCantidad()) {
            throw new RuntimeException("Stock insuficiente.");
        }

        // 4. Calcular total
        Double total = producto.getPrecio() * request.getCantidad();

        // 5. Crear venta
        Venta venta = new Venta();
        venta.setFecha(LocalDateTime.now());
        venta.setTotal(total);

        Venta ventaGuardada = ventaRepository.save(venta);

        // 6. Crear detalle
        DetalleVenta detalle = new DetalleVenta();
        detalle.setIdVenta(ventaGuardada.getIdVenta());
        detalle.setIdProducto(producto.getIdProducto());
        detalle.setCantidad(request.getCantidad());
        detalle.setPrecio(producto.getPrecio());

        detalleRepository.save(detalle);

        return ventaGuardada;
    }

    public void eliminar(Long idVenta) {
        ventaRepository.deleteById(idVenta);
    }

}