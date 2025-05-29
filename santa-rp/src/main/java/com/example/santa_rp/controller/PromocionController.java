package com.example.santa_rp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.santa_rp.model.Promocion;
import com.example.santa_rp.service.PromocionService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/section/promociones")
@RequiredArgsConstructor
public class PromocionController {

    private final PromocionService promocionService;

    // Obtener todas las promociones
    @GetMapping
    public ResponseEntity<List<Promocion>> findAll() {
        return ResponseEntity.ok(promocionService.findAll());
    }

    // Obtener una promoción por ID
    @GetMapping("/{id}")
    public ResponseEntity<Promocion> findById(@PathVariable Long id) {
        Optional<Promocion> promocion = promocionService.findById(id);
        return promocion.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva promoción
    @PostMapping
    public ResponseEntity<Promocion> create(@RequestBody Promocion promocion) {
        return ResponseEntity.ok(promocionService.save(promocion));
    }

    // Actualizar una promoción
    @PutMapping("/{id}")
    public ResponseEntity<Promocion> update(@PathVariable Long id, @RequestBody Promocion promocion) {
        Promocion updated = promocionService.update(id, promocion);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una promoción (soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        promocionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Aplicar una promoción a un producto (esto puede incluir una actualización de stock)
    @PostMapping("/aplicar/{id}")
    public ResponseEntity<String> aplicarPromocion(@PathVariable Long id) {
        try {
            promocionService.aplicarPromocion(id);
            return ResponseEntity.ok("Promoción aplicada y stock actualizado.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al aplicar la promoción: " + e.getMessage());
        }
    }

    // Obtener promociones activas
    @GetMapping("/activas")
    public ResponseEntity<List<Promocion>> findActivePromotions() {
        return ResponseEntity.ok(promocionService.findActivePromotions());
    }
}
