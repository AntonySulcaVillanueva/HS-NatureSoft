package com.example.santa_rp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.example.santa_rp.model.Categoria;
import com.example.santa_rp.repository.CategoriaRepository;
import com.example.santa_rp.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    // Lista todas las categorias
    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Busca una categoria por su ID
    @Override
    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    // Guarda una nueva categoria
    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualiza una categoria existente
    @Override
    public Categoria update(Long id, Categoria categoria) {
        return categoriaRepository.findById(id).map(existing -> {
            existing.setNombre(categoria.getNombre());
            existing.setDescripcion(categoria.getDescripcion());
            existing.setImagen1(categoria.getImagen1());
            existing.setImagen2(categoria.getImagen2());
            existing.setEstado(categoria.isEstado());
            return categoriaRepository.save(existing);
        }).orElse(null);
    }
    
    //lista de categorias activas
    @Override
    public List<Categoria> findAllActive() {
        return categoriaRepository.findByEstadoTrue();
    }

    //cambia el estado a false para simular la eliminacion
    @Override
    public void softDelete(Long id) {
        categoriaRepository.findById(id).ifPresent(categoria -> {
            categoria.setEstado(false);
            categoriaRepository.save(categoria);
        });
    }

    @Override
    public List<Categoria> searchNameAndStatus(String nombre, Boolean estado) {
       String nombreFiltrado = (nombre != null && !nombre.trim().isEmpty()) ? nombre : null;
        return categoriaRepository.searchNameAndStatus(nombreFiltrado, estado);
    }

   
}
