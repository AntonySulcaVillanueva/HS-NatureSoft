package com.example.santa_rp.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.santa_rp.model.Producto;
import com.example.santa_rp.repository.ProductoRepository;
import com.example.santa_rp.service.ProductoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private final ProductoRepository productoRepository;



    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Long id, Producto producto) {
        return productoRepository.findById(id).map(existing -> {
            existing.setNombre(producto.getNombre());
            existing.setDescripcion(producto.getDescripcion());
            existing.setCategoria(producto.getCategoria());
            existing.setPeso_unidad(producto.getPeso_unidad());
            existing.setUnidad_medida(producto.getUnidad_medida());
            existing.setPrecio_unidad(producto.getPrecio_unidad());
            existing.setPrecio_docena(producto.getPrecio_docena());
            existing.setDescuento_docenas(producto.getDescuento_docenas());
            existing.setStock(producto.getStock());
            existing.setFecha_caducidad(producto.getFecha_caducidad());
            existing.setMarca(producto.getMarca());
            existing.setEstado(producto.isEstado());
            existing.setSku(producto.getSku());
            existing.setImagenes(producto.getImagenes());
            return productoRepository.save(existing);
        }).orElse(null);
    }

    @Override
    public List<Producto> findAllActive() {
        return productoRepository.findByEstadoTrue();
    }

    @Override
    public void softDelete(Long id) {
        productoRepository.findById(id).ifPresent(producto -> {
            producto.setEstado(false);
            productoRepository.save(producto);
        });
    }

    // Metodo para busqueda por nombre y demas atributos
    @Override
    public List<Producto> buscarPorFiltros(
            String nombre,
            String categoriaNombre,
            String marca,
            String unidadMedida,
            Boolean estado,
            Double precioUnidadMin,
            Double precioUnidadMax,
            Double precioDocenaMin,
            Double precioDocenaMax,
            Integer stockMin,
            Integer stockMax,
            LocalDate fechaCaducidadDesde,
            LocalDate fechaCaducidadHasta) {

        return productoRepository.filtroCompleto(
                nombre,
                categoriaNombre,
                marca,
                unidadMedida,
                estado,
                precioUnidadMin,
                precioUnidadMax,
                precioDocenaMin,
                precioDocenaMax,
                stockMin,
                stockMax,
                fechaCaducidadDesde,
                fechaCaducidadHasta);
    }

    // Metodo para buscar por sku y por una letra semejante
    @Override
    public List<Producto> buscarPorSku(String sku) {
        return productoRepository.buscarPorSku(sku);
    }

}
