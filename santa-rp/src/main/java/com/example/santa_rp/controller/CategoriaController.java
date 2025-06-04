package com.example.santa_rp.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.santa_rp.model.Categoria;
import com.example.santa_rp.service.CategoriaService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/section/categorias")
@RequiredArgsConstructor
public class CategoriaController 
{
	/*
    private final CategoriaService categoriaService;


    @GetMapping("/buscar")
    public ResponseEntity<List<Categoria>> searchNameAndStatus(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Boolean estado) {

        List<Categoria> categorias = categoriaService.searchNameAndStatus(nombre, estado);
        return ResponseEntity.ok(categorias);
    }


    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        return ResponseEntity.ok(categoriaService.findAll());

    }

    //metodo listar rodos los activos
    @GetMapping("/activas")
    public ResponseEntity<List<Categoria>> findAllActive() {
        return ResponseEntity.ok(categoriaService.findAllActive());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        return categoria.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> sava(@RequestBody Categoria categoria) {
        Categoria saved = categoriaService.save(categoria);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        Categoria updated = categoriaService.update(id, categoria);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    //metodo para suponer la eliminacion y soo cambiar el estado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        categoriaService.softDelete(id);
        return ResponseEntity.noContent().build();
    }
    
    */
    
	}
