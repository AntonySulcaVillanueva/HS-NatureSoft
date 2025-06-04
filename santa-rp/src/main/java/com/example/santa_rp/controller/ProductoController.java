package com.example.santa_rp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.santa_rp.model.Producto;
import com.example.santa_rp.service.ProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/section/productos")
@RequiredArgsConstructor
public class ProductoController {
	/*
    private final ProductoService productoService;
    

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    } 

    @GetMapping("/activos")
    public ResponseEntity<List<Producto>> findAllActive() {
        return ResponseEntity.ok(productoService.findAllActive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.save(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto updated = productoService.update(id, producto);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        productoService.softDelete(id);
        return ResponseEntity.noContent().build();
    }

    // busqueda por filtros
    // Filtros: nombre, categoria, marca, unidad de medida, estado, precio unidad, precio docena, stock, fecha caducidad
    @GetMapping("/seach")
    public ResponseEntity<List<Producto>> buscarPorFiltros(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String categoriaNombre,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String unidadMedida,
            @RequestParam(required = false) Boolean estado,
            @RequestParam(required = false) Double precioUnidadMin,
            @RequestParam(required = false) Double precioUnidadMax,
            @RequestParam(required = false) Double precioDocenaMin,
            @RequestParam(required = false) Double precioDocenaMax,
            @RequestParam(required = false) Integer stockMin,
            @RequestParam(required = false) Integer stockMax,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCaducidadDesde,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaCaducidadHasta
    ) {
        List<Producto> productos = productoService.buscarPorFiltros(
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
                fechaCaducidadHasta
        );

        return ResponseEntity.ok(productos);
    }

    // busqueda por sku y ya sea una letra semejante o igual
    @GetMapping("/buscar-sku")
    public ResponseEntity<List<Producto>> buscarPorSku(@RequestParam(required = false) String sku) {
        List<Producto> productos = productoService.buscarPorSku(sku);
        return ResponseEntity.ok(productos);
    }
    */
}
