package com.example.santa_rp.service;

import com.example.santa_rp.model.Promocion;
import com.example.santa_rp.repository.PromocionRepository;
import com.example.santa_rp.model.Producto;
import com.example.santa_rp.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todas las promociones
    public List<Promocion> findAll() {
        return promocionRepository.findAll();
    }

    // Obtener una promoción por ID
    public Optional<Promocion> findById(Long id) {
        return promocionRepository.findById(id);
    }

    // Crear una nueva promoción
    public Promocion save(Promocion promocion) {
        return promocionRepository.save(promocion);
    }

    // Actualizar una promoción existente
    public Promocion update(Long id, Promocion promocion) {
        if (promocionRepository.existsById(id)) {
            promocion.setId_promocion(id);
            return promocionRepository.save(promocion);
        } else {
            return null;
        }
    }

    // Eliminar una promoción
    public void delete(Long id) {
        promocionRepository.deleteById(id);
    }

    // Aplicar una promoción a un producto (descontar stock)
    public void aplicarPromocion(Long id) {
        Promocion promocion = promocionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Promoción no encontrada"));

        Producto producto = promocion.getProducto();
        if (producto != null && producto.getStock() > 0) {
            // Reducir el stock del producto
            producto.setStock(producto.getStock() - 1);
            producto.actualizarEstadoStock(); // Actualizar el estado del producto
            productoRepository.save(producto); // Guardar el producto con el nuevo stock
        } else {
            throw new RuntimeException("Producto sin stock disponible");
        }
    }

    // Obtener todas las promociones activas
    public List<Promocion> findActivePromotions() {
        // Filtrar las promociones activas basadas en fechas o cualquier otra lógica
        return promocionRepository.findActivePromotions(); // Puedes personalizar esta consulta
    }
}
